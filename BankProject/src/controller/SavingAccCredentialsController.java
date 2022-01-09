package controller;

import model.Account;
import view.SavingsAccCredentials;
import view.WelcomePage;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public class SavingAccCredentialsController implements ActionListener {
    private HashMap<String, Account> accounts;
    private String CNP;
    private SavingsAccCredentials savingsAccCredentials;

    public SavingAccCredentialsController(HashMap<String, Account> accountsOriginal, String CNPOriginal, SavingsAccCredentials savingsAccCredentialsOriginal) {
        accounts = accountsOriginal;
        CNP = CNPOriginal;
        savingsAccCredentials = savingsAccCredentialsOriginal;
        savingsAccCredentials.getLoginButton().addActionListener(this);
        savingsAccCredentials.getResetButton().addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == savingsAccCredentials.getResetButton()) {
            savingsAccCredentials.getCNPField().setText("");
            savingsAccCredentials.getUserPasswordField().setText("");
        }

        if (e.getSource() == savingsAccCredentials.getLoginButton()) {
            String safetyDepositId = savingsAccCredentials.getCNPField().getText();
            String safetyDepositKey = String.valueOf(savingsAccCredentials.getUserPasswordField().getPassword());

            String[] array = accounts.get(CNP).getSavingsCredentials();

            if (array[0].equals(safetyDepositId) && array[1].equals(safetyDepositKey)) {
                savingsAccCredentials.getMessageLabel().setForeground(Color.green);
                savingsAccCredentials.getMessageLabel().setText("Login successful");
                savingsAccCredentials.getFrame().dispose();
                WelcomePage welcomePage = new WelcomePage(accounts.get(CNP));
                WelcomePageController welcomePageController = new WelcomePageController(welcomePage, accounts, accounts.get(CNP));
            } else {
                savingsAccCredentials.getMessageLabel().setForeground(Color.red);
                savingsAccCredentials.getMessageLabel().setText("Invalid Savings Credentials");
            }
        }
    }
}
