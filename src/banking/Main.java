package banking;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank();
        Scanner imp = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n--- Welcome to the Banking System --- ");
            System.out.println("--------------------------------------");
            System.out.println("Bank Features");
            System.out.println("1. Create Account");
            System.out.println("2. List All Accounts");
            System.out.println("--------------------------------------");
            System.out.println("Account Features");
            System.out.println("3. Deposit");
            System.out.println("4. Withdraw");
            System.out.println("5. Check Balance");
            System.out.println("6. Transfer Funds");
            System.out.println("--------------------------------------");
            System.out.println("0. Exit");
            System.out.print("Choose an option: ");

            int choice = imp.nextInt();
            imp.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter account holder name: ");
                    String name = imp.nextLine();
                    Account newAccount = bank.createAccount(name);
                    System.out.println("Account created successfully! Account Number: " + newAccount.getAccountNumber());
                    break;

                case 2:
                    System.out.println("Listing all accounts:");
                    bank.listAccounts();
                    break;

                case 3:
                    System.out.print("Enter account number: ");
                    String depositAccountNumber = imp.nextLine();
                    Account depositAccount = bank.findAccount(depositAccountNumber);
                    if (depositAccount != null) {
                        System.out.print("Enter deposit amount: ");
                        double depositAmount = imp.nextDouble();
                        depositAccount.deposit(depositAmount);
                    } else {
                        System.out.println("Account not found!");
                    }
                    break;

                case 4:
                    System.out.print("Enter account number: ");
                    String withdrawAccountNumber = imp.nextLine();
                    Account withdrawAccount = bank.findAccount(withdrawAccountNumber);
                    if (withdrawAccount != null) {
                        System.out.print("Enter withdrawal amount: ");
                        double withdrawAmount = imp.nextDouble();
                        withdrawAccount.withdraw(withdrawAmount);
                    } else {
                        System.out.println("Account not found!");
                    }
                    break;

                case 5:
                    System.out.print("Enter account number: ");
                    String balanceAccountNumber = imp.nextLine();
                    Account balanceAccount = bank.findAccount(balanceAccountNumber);
                    if (balanceAccount != null) {
                        System.out.println("Current Balance: $" + balanceAccount.getBalance());
                    } else {
                        System.out.println("Account not found!");
                    }
                    break;

                case 6:
                    System.out.print("Enter your account number: ");
                    String fromAccountNumber = imp.nextLine();
                    Account fromAccount = bank.findAccount(fromAccountNumber);
                    if (fromAccount != null) {
                        System.out.print("Enter the target account number: ");
                        String toAccountNumber = imp.nextLine();
                        Account toAccount = bank.findAccount(toAccountNumber);
                        if (toAccount != null) {
                            System.out.print("Enter the amount to transfer: ");
                            double transferAmount = imp.nextDouble();
                            fromAccount.transferFunds(toAccount, transferAmount);
                        } else {
                            System.out.println("Target account not found!");
                        }
                    } else {
                        System.out.println("Your account not found!");
                    }
                    break;

                case 0:
                    running = false;
                    System.out.println("Exiting the system. Goodbye!");
                    break;

                default:
                    System.out.println("Invalid option! Please try again.");
                    break;
            }
        }
        imp.close();
    }
}
