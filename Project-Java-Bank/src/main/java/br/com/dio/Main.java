package br.com.dio;

import br.com.dio.exception.AccountNotFoundException;
import br.com.dio.exception.NotEnoughFundsException;
import br.com.dio.repository.AccountRepository;
import br.com.dio.repository.InvestmentRepository;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    private final static AccountRepository accountRepository = new AccountRepository();
    private final static InvestmentRepository investmentRepository = new InvestmentRepository();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // Menu
        System.out.println("Welcome to the Digital Bank!");
        while (true) {
            System.out.println("Please select an option:");
            System.out.println("1 - Create Account");
            System.out.println("2 - Create Investment");
            System.out.println("3 - Make an Investment");
            System.out.println("4 - Deposit at account");
            System.out.println("5 - Withdraw from account");
            System.out.println("6 - Transfer between accounts");
            System.out.println("7 - Investment");
            System.out.println("8 - Withdraw from Investment");
            System.out.println("9 - List Accounts");
            System.out.println("10 - List Investments");
            System.out.println("11 - List investment wallets");
            System.out.println("12 - Update Investments");
            System.out.println("13 - Account history");
            System.out.println("0 - Exit");
            var option = scanner.nextInt();
            switch (option) {
                case 0 -> {
                    System.out.println("Thank you for using the Digital Bank. Goodbye!");
                    System.exit(0);
                }
                case 1: createAccount();
                case 2: createInvestment();
                case 3: makeInvestment();
                case 4: depositAtAccount();
                case 5: withdrawFromAccount();
                case 6: transferBetweenAccounts();
                case 7: invest();
                case 8: withdrawFromInvestment();
                case 9: accountRepository.list().forEach(System.out::println);
                case 10: investmentRepository.list().forEach(System.out::println);
                case 11: investmentRepository.listWallets().forEach(System.out::println);
                case 12: {
                    investmentRepository.updateAmount();
                    System.out.println("Investments updated successfully.");
                }
                case 13:
                default -> System.out.println("Invalid option. Please try again.");
            }
        }
        System.out.println();
    }

    private static void withdrawFromAccount() {
        System.out.println("Enter pix key to withdraw from: ");
        var pix = scanner.next();
        System.out.println("Enter amount to withdraw: ");
        var amount = scanner.nextLong();
        try {
            accountRepository.withdraw(pix, amount);
            System.out.println("Withdraw successful.");
        } catch (NotEnoughFundsException | AccountNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void depositAtAccount() {
        System.out.println("Enter pix key to deposit: ");
        var pix = scanner.next();
        System.out.println("Enter amount to deposit: ");
        var amount = scanner.nextLong();
        try {
            accountRepository.deposit(pix, amount);
            System.out.println("Deposit successful.");
        } catch (AccountNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void createInvestment() {
        System.out.println("Enter investment tax: ");
        var tax = scanner.nextInt();
        System.out.println("Enter initial funds: ");
        var initialFunds = scanner.nextLong();
        var investment = investmentRepository.create(tax, initialFunds);
        System.out.println("Investment created successfully: " + investment);
    }

    private static void createAccount() {
        System.out.println("Enter pix keys separated by ',': ");
        var pix = Arrays.stream(scanner.next().split(",")).toList();
        System.out.println("Enter initial funds: ");
        var initialFunds = scanner.nextLong();
        var wallet = accountRepository.create(pix, initialFunds);
        System.out.println("Account created successfully: " + wallet);
    }
}