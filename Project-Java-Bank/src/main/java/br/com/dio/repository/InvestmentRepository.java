package br.com.dio.repository;

import br.com.dio.exception.*;
import br.com.dio.model.AccountWallet;
import br.com.dio.model.Investment;
import br.com.dio.model.InvestmentWallet;

import java.util.ArrayList;
import java.util.List;

import static br.com.dio.repository.CommonRepository.checkFundsForTransaction;

public class InvestmentRepository {

    private long nextId = 0;
    private final List<Investment> investments = new ArrayList<>();
    private final List<InvestmentWallet> wallets = new ArrayList<>();

    public Investment create(final long tax, final long initialFunds){
        this.nextId++;
        var investment = new Investment(this.nextId, tax, initialFunds);
        investments.add(investment);
        return investment;
    }

    public InvestmentWallet initInvestment(final AccountWallet account, final long id){
        if (investments.isEmpty()) {
            System.out.println("No investments found. Please create an investment first.");
            return null;
        }

        if (!wallets.isEmpty()) {
            var accountBeingUsed = wallets.stream()
                    .map(InvestmentWallet::getAccount)
                    .toList();
            if (accountBeingUsed.contains(account)) {
                throw new AccountWithInvestmentException("Account " + account + " already has an investment wallet!");
            }
        }

        var investment = findById(id);
        checkFundsForTransaction(account, investment.initialFunds());
        var wallet = new InvestmentWallet(investment, account, investment.initialFunds());
        wallets.add(wallet);
        System.out.println("Investment wallet successfully created: " + wallet);
        return wallet;
    }

    public InvestmentWallet deposit(final String pix, final long funds){
        var wallet = findWalletByAccountPix(pix);
        wallet.addMoney(wallet.getAccount().reduceMoney(funds), wallet.getService(), "Deposit to investment wallet");
        return wallet;
    }

    public InvestmentWallet withdraw(final String pix, final long funds){
        InvestmentWallet wallet;
        try {
            wallet = findWalletByAccountPix(pix);
            checkFundsForTransaction(wallet, funds);
            wallet.getAccount().addMoney(wallet.reduceMoney(funds), wallet.getService(), "Withdraw from investment wallet");
        } catch (WalletNotFoundException | NotEnoughFundsException e) {
            System.out.println("Operation error: " + e.getMessage());
            return null;
        }

        if (wallet.getFunds() == 0) {
            System.out.println("Wallet funds are zero. Removing wallet...");
            wallets.remove(wallet);
        }

        System.out.println("Withdraw process completed successfully.");
        return wallet;
    }

    public void updateAmount(){
        wallets.forEach(w -> w.updateAmount(w.getInvestment().tax()));
    }

    public Investment findById(final long id){
        return investments.stream()
                .filter(a -> a.id() == id)
                .findFirst()
                .orElseThrow(() -> new WalletNotFoundException("Investment not found for id: " + id));
    }

    public InvestmentWallet findWalletByAccountPix(final String pix){
        return wallets.stream()
                .filter(w -> w.getAccount().getPix().contains(pix))
                .findFirst()
                .orElseThrow(() -> new WalletNotFoundException("Investment wallet not found for pix: " + pix));
    }

    public List<InvestmentWallet> listWallets(){
        return this.wallets;
    }

    public List<Investment> list() {
        return this.investments;
    }
}
