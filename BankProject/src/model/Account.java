package model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.HashMap;

// account is the parent class of account_checking and account_savings
public abstract class Account implements BaseRate {
    /** Common Properties for the accounts: */
    private String name;
    private String CNP;
    private double balance;

    protected String accountNumber;
    protected double rate;
    static int idx = 10000; // unique because is static

    /** Constructor to set base properties and initialise the account */
    public Account(String name, String CNP, double initDeposit) {
        this.name = name;
        this.CNP = CNP;
        this.balance = initDeposit;

        // Set model.Account Number
        ++idx;
        this.accountNumber = setAccountNumber();
        setRate();
    }

    public abstract void setRate();

    private String setAccountNumber() {
        String lastTwoDigitsCNP = CNP.substring(CNP.length() - 2, CNP.length());
        int uniqueIdx = idx;
        int randomNum = (int)(Math.random() * Math.pow(10, 3)); //Random Num of 3 digits
        return lastTwoDigitsCNP + uniqueIdx + randomNum;
    }

    private void compound() {
        double accruedInterest = balance * (rate / 100);
        System.out.println("Accrued Interest: $" + accruedInterest);
        balance += accruedInterest;
    }

    /** Common Methods */
    public void deposit(HashMap<String, Account> logininfo, double amount) throws FileNotFoundException {
        balance += amount;
        updateFile(logininfo);
    }

    public void withdraw(HashMap<String, Account> logininfo, double amount) throws FileNotFoundException {
        if(balance - amount >= 0) {
            balance -= amount;
            System.out.println("Withdrawing $" + amount);
            updateFile(logininfo);
        }
        else {
            System.out.println("Can't transfer, not enough money");
        }
    }

    public boolean transfer(HashMap<String, Account> logininfo, String toWhere, double amount) throws FileNotFoundException {
        if(balance - amount >= 0 && logininfo.containsKey(toWhere)) {
            balance -= amount;
            System.out.println("Transfering $ " + amount + " to " + toWhere);
            updateFile(logininfo);
            logininfo.get(toWhere).deposit(logininfo, amount);
            return true;
        }
        return false;
    }

    public String showInfo() {
        String output = "\nName: " + name + "\nCNP: " + CNP + "\nBalance: " + balance + "\nAccount Number: " + accountNumber + "\nRate: " + rate + "\n";
        return output;
    }

    protected String printInfo() {
        String output = "\nName: " + name + "\nCNP: " + CNP + "\nBalance: " + balance + "\nAccount Number: " + accountNumber + "\nRate: " + rate + "\n";
        return output;
    }

    public String getAccType() {
        String str = "";
        return str;
    }

    public String[] getSavingsCredentials() {
        String[] array = new String[2];
        return array;
    }

    private void updateFile(HashMap<String, Account> accounts) throws FileNotFoundException {
        File file = new File("C:\\Users\\Daniel G\\Desktop\\bankAccounts.txt");

        // Instantiating the Print Stream Class
        PrintStream oldStream = System.out;
        PrintStream stream = new PrintStream(file);
        System.setOut(stream);

        accounts.entrySet().stream().forEach(i -> System.out.println(i.getValue().showInfo() + "\n"));
        System.setOut(oldStream);
    }
}