package controller;

import model.Account;
import view.WelcomePage;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.util.HashMap;

public class WelcomePageController implements ActionListener {
    private WelcomePage welcomePage;
    private HashMap<String, Account> accounts;
    private Account currentAccount;

    public WelcomePageController(WelcomePage welcomePageOriginal, HashMap<String, Account> accountsOriginal, Account currentAccountOriginal) {
        accounts = accountsOriginal;
        welcomePage = welcomePageOriginal;
        currentAccount = currentAccountOriginal;

        welcomePage.getDepositButton().addActionListener(this);
        welcomePage.getTransferButton().addActionListener(this);
        welcomePage.getWithDrawButton().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == welcomePage.getDepositButton()) {
            String amountStr = welcomePage.getAmountField().getText();
            double amount = Double.parseDouble(amountStr);
            try {
                currentAccount.deposit(accounts, amount);
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            }

            welcomePage.getFrame().dispose();
            WelcomePage welcomePageNew = new WelcomePage(currentAccount);
            WelcomePageController welcomePageController = new WelcomePageController(welcomePageNew, accounts, currentAccount);
        }

        if(e.getSource() == welcomePage.getWithDrawButton()) {
            String amountStr = welcomePage.getAmountField().getText();
            double amount = Double.parseDouble(amountStr);
            try {
                currentAccount.withdraw(accounts, amount);
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            }

            welcomePage.getFrame().dispose();
            WelcomePage welcomePageNew = new WelcomePage(currentAccount);
            WelcomePageController welcomePageController = new WelcomePageController(welcomePageNew, accounts, currentAccount);
        }

        if(e.getSource() == welcomePage.getTransferButton()) {
            welcomePage.getToWhereField().setBounds(235, 430, 200, 25);
            welcomePage.getToWhereField().setFont(new Font(null, Font.PLAIN,20));

            welcomePage.getToWhereLabel().setBounds(180, 430, 40, 25);
            welcomePage.getToWhereLabel().setFont(new Font(null, Font.PLAIN,20));

            welcomePage.getFrame().add(welcomePage.getToWhereField());
            welcomePage.getFrame().add(welcomePage.getToWhereLabel());

            String toWhereCNP = welcomePage.getToWhereField().getText();
            String amountStr = welcomePage.getAmountField().getText();
            double amount = Double.parseDouble(amountStr);

            boolean transferMade = false;
            try {
                transferMade = currentAccount.transfer(accounts, toWhereCNP, amount);
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            }

            if(transferMade) {
                welcomePage.getFrame().dispose();
                WelcomePage welcomePageNew = new WelcomePage(currentAccount);
                WelcomePageController welcomePageController = new WelcomePageController(welcomePageNew, accounts, currentAccount);
            }
        }
    }
}
