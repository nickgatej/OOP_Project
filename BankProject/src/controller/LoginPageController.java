package controller;

import model.Account;
import view.CheckingAccCredentials;
import view.LoginPage;
import view.SavingsAccCredentials;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public class LoginPageController implements ActionListener {
    private LoginPage loginPage;
    private HashMap<String, Account> accounts;

    public LoginPageController(LoginPage loginPageOriginal, HashMap<String, Account> accountsOriginal) {
        loginPage = loginPageOriginal;
        accounts = accountsOriginal;
        loginPage.getLoginButton().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == loginPage.getResetButton()) {
            loginPage.getCNPField().setText("");
        }

        if(e.getSource() == loginPage.getLoginButton()) {
            String CNP = loginPage.getCNPField().getText();

            if(accounts.containsKey(CNP) == false) {
                loginPage.getMessageLabel().setForeground(Color.red);
                loginPage.getMessageLabel().setText("CNP not found");
                return;
            }

            String accType = accounts.get(CNP).getAccType();

            if(accounts.containsKey(CNP) && accType == "Savings") {
                loginPage.getMessageLabel().setForeground(Color.green);
                loginPage.getMessageLabel().setText("Login successful");
                loginPage.getFrame().dispose();
                SavingsAccCredentials savingsAccCredentials = new SavingsAccCredentials();
                SavingAccCredentialsController savingsAccCredentialsController = new SavingAccCredentialsController(accounts, CNP, savingsAccCredentials);
            }
            else if(accounts.containsKey(CNP) && accType == "Checking") {
                loginPage.getMessageLabel().setForeground(Color.green);
                loginPage.getMessageLabel().setText("Login successful");
                loginPage.getFrame().dispose();
                CheckingAccCredentials checkingAccCredentials = new CheckingAccCredentials();
                CheckingAccCredentialsController checkingAccCredentialsController = new CheckingAccCredentialsController(accounts, CNP, checkingAccCredentials);
            }
        }
    }
}
