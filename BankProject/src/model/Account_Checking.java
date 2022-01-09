package model;

import java.util.Random;

public class Account_Checking extends Account {
    /** Properties Specific to Checking model.Account */
    private long debitCardNumber;
    private int debitCardPIN;

    // static long num = 1000000000000000L;
    /** Constructor to initialize checking account */
    protected Account_Checking(String name, String CNP, double initDeposit) {
        super(name, CNP, initDeposit); // call the parent class
        accountNumber = "2" + accountNumber;
        setDebitCard();
    }

    public void setRate() {
        rate = getBaseRate() * .15;
    }

    private void setDebitCard() {
        int leftLimit = 48; // numeral '0'
        int rightLimit = 57; // numeral '9'
        int targetStringLength = 10;
        Random random = new Random();

        String generatedString = random.ints(leftLimit, rightLimit + 1)
                .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();

        debitCardNumber = Long.parseLong(generatedString);
        debitCardPIN = (int)(Math.random() * Math.pow(10, 4));
    }

    /** Methods Specific to checking account */
    public String showInfo() {
        String part = "Account Type: Checking";
        String partialRes;

        partialRes = super.showInfo();
        part = part + partialRes;

        part += "Debit Card Number: " + SecretCrypt.hashpw(String.valueOf(debitCardNumber), SecretCrypt.gensalt()) + "\nDebit Card PIN: " +
                SecretCrypt.hashpw(String.valueOf(debitCardPIN), SecretCrypt.gensalt());
        return part;
    }

    protected String printInfo() {
        String part = "Account Type: Checking";
        String partialRes;

        partialRes = super.printInfo();
        part = part + partialRes;
        part += "Debit Card Number: " + debitCardNumber + "\nDebit Card PIN: " + debitCardPIN;

        return part;
    }

    public String getAccType() {
        String str = super.getAccType();
        str = "Checking";
        return str;
    }

    public String[] getSavingsCredentials() {
        String[] array = super.getSavingsCredentials();
        array[0] = String.valueOf(debitCardNumber);
        array[1] = String.valueOf(debitCardPIN);
        return array;
    }
}
