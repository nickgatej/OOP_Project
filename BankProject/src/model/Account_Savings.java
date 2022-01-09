package model;

public class Account_Savings extends Account {
    /** Properties Specific to Checking Account */
    private int safetyDepositBoxID;
    private int safetyDepositBoxKey;

    /** Constructor to initialise Savings Account */
    protected Account_Savings(String name, String CNP, double initDeposit) {
        super(name, CNP, initDeposit);
        accountNumber = "1" + accountNumber;
        setSafetyDepositBox();
    }

    public void setRate() {
        rate = getBaseRate()  - .25;
    }

    private void setSafetyDepositBox() {
        safetyDepositBoxID = (int)(Math.random() * Math.pow(10, 3));
        safetyDepositBoxKey = (int)(Math.random() * Math.pow(10, 4));
    }

    /** Specific Methods of Savings model.Account */
    public String showInfo() {
        String part = "Account Type: Savings";
        String partialRes = super.showInfo();
        part += partialRes;
        part += "Debit Card Number: " + SecretCrypt.hashpw(String.valueOf(safetyDepositBoxID), SecretCrypt.gensalt()) + "\nDebit Card PIN: " +
                SecretCrypt.hashpw(String.valueOf(safetyDepositBoxKey), SecretCrypt.gensalt());

        return part;
    }

    protected String printInfo(){
        String part = "Account Type: Savings";
        String partialRes = super.printInfo();

        part += partialRes;
        part += "Safety Deposit ID: " + safetyDepositBoxID + "\nSafetyDeposit Key: " + safetyDepositBoxKey + "\n";
        return part;
    }

    public String[] getSavingsCredentials() {
        String[] array = super.getSavingsCredentials();
        array[0] = String.valueOf(safetyDepositBoxID);
        array[1] = String.valueOf(safetyDepositBoxKey);
        return array;
    }

    public String getAccType() {
        String str = super.getAccType();
        str = "Savings";
        return str;
    }
}