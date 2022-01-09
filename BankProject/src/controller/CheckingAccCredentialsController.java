package controller;

import model.Account;
import view.CheckingAccCredentials;
import view.WelcomePage;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public class CheckingAccCredentialsController implements ActionListener {
    private HashMap<String, Account> accounts;
    private String CNP;
    private CheckingAccCredentials checkingAccCredentials;

    public CheckingAccCredentialsController(HashMap<String, Account> accountsOriginal, String CNPOriginal, CheckingAccCredentials checkingAccCredentialsOriginal){
        accounts = accountsOriginal;
        CNP = CNPOriginal;
        checkingAccCredentials = checkingAccCredentialsOriginal;

        checkingAccCredentials.getLoginButton().addActionListener(this);
        checkingAccCredentials.getResetButton().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == checkingAccCredentials.getResetButton()) {
            checkingAccCredentials.getCNPField().setText("");
            checkingAccCredentials.getUserPasswordField().setText("");
        }

        if(e.getSource() == checkingAccCredentials.getLoginButton()) {
            String debitCardId = checkingAccCredentials.getCNPField().getText();
            String debitCardPIN = String.valueOf(checkingAccCredentials.getUserPasswordField().getPassword());

            String[] array = accounts.get(CNP).getSavingsCredentials();

            if(array[0].equals(debitCardId) && array[1].equals(debitCardPIN)) {
                checkingAccCredentials.getMessageLabel().setForeground(Color.green);
                checkingAccCredentials.getMessageLabel().setText("Login successful");
                checkingAccCredentials.getFrame().dispose();
                WelcomePage welcomePage = new WelcomePage(accounts.get(CNP));
                WelcomePageController welcomePageController = new WelcomePageController(welcomePage, accounts, accounts.get(CNP));
            }
            else {
                checkingAccCredentials.getMessageLabel().setForeground(Color.red);
                checkingAccCredentials.getMessageLabel().setText("Invalid Credentials");
            }
        }
    }
}
