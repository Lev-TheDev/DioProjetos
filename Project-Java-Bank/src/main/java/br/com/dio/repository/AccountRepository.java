package br.com.dio.repository;

import br.com.dio.exception.AccountNotFoundException;
import br.com.dio.exception.PixBeingUsedException;
import br.com.dio.model.AccountWallet;
import br.com.dio.model.MoneyAudit;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static br.com.dio.repository.CommonRepository.checkFundsForTransaction;
import static java.time.temporal.ChronoUnit.SECONDS;

public class AccountRepository {

    private final List<AccountWallet> accounts = new ArrayList<>();

    public AccountWallet create(final List<String> pix, final long initialFunds) {
        if (!accounts.isEmpty()) {
            var pixBeingUsed = accounts.stream()
                    .flatMap(a -> a.getPix().stream())
                    .toList();
            for (var p : pix) {
                if (pixBeingUsed.contains(p)) {
                    throw new PixBeingUsedException("Pix already in use: " + p);
                }
            }
        }
        var newAccount = new AccountWallet(initialFunds, pix);
        accounts.add(newAccount);
        return newAccount;
    }

    public void deposit(final String pix, final long fundsAmount) {
        var target = findByPix(pix);
        target.addMoney(fundsAmount, "Deposit");
    }

    public long withdraw(final String pix, final long fundsAmount) {
        var source = findByPix(pix);
        checkFundsForTransaction(source, fundsAmount);
        source.reduceMoney(fundsAmount);
        return fundsAmount;
    }

    public void transferMoney(final String sourcePix, final String targetPix, final long amount) {
        var source = findByPix(sourcePix);
        var target = findByPix(targetPix);
        checkFundsForTransaction(source, amount);
        target.addMoney(source.reduceMoney(amount), source.getService(), "Transfer from " + sourcePix + " to " + targetPix);
    }

    public AccountWallet findByPix(final String pix){
        return accounts.stream()
                .filter(a -> a.getPix().contains(pix))
                .findFirst()
                .orElseThrow(() -> new AccountNotFoundException("Account not found for pix: " + pix));
    }

    public List<AccountWallet> list() {
        return this.accounts;
    }

    public Map<OffsetDateTime, List<MoneyAudit>> getHistory(final String pix){
        var wallet = findByPix(pix);
        var audit = wallet.getFinancialTransactions();
        return audit.stream()
                .collect(Collectors.groupingBy(t -> t.createdAt().truncatedTo(SECONDS)));
    }
}
