package banking;

import java.util.ArrayList;

public class Bank {
    private ArrayList<Account> accounts;

    public Bank() {
        accounts = new ArrayList<>();
    }

    public Account createAccount(String accountHolderName) {
        String accountNumber = "ACC" + (accounts.size() + 1);
        Account newAccount = new Account(accountNumber, accountHolderName, 0);
        accounts.add(newAccount);
        return newAccount;
    }

    public Account findAccount(String accountNumber) {
        for (Account account : accounts) {
            if (account.getAccountNumber().equals(accountNumber)) {
                return account;
            }
        }
        return null;
    }

    public void listAccounts() {
        for (Account account : accounts) {
            System.out.println(account.getAccountNumber() + " - " + account.getAccountHolderName() + " - $" + account.getBalance());
        }
    }
}

