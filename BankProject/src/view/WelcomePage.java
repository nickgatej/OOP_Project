package view;

import model.Account;
import javax.swing.*;
import java.awt.*;
import java.util.HashMap;

public class WelcomePage extends JFrame {
    private String CNP;
    private Account currentAccount;

    private final JFrame frame = new JFrame();
    private final JLabel accTypeLabel = new JLabel();
    private final JLabel nameLabel = new JLabel();
    private final JLabel cnpLabel = new JLabel();
    private final JLabel depositLabel = new JLabel();
    private final JLabel accNumLabel = new JLabel();
    private final JLabel rateLabel = new JLabel();
    private final JLabel safetyOrDebitCardLabel = new JLabel();
    private final JLabel safetyOrCardPINLabel = new JLabel();
    private final JLabel messageLabel = new JLabel();

    private final JButton depositButton = new JButton("Deposit");
    private final JButton withDrawButton = new JButton("Withdraw");
    private final JButton transferButton = new JButton("Transfer");

    private final JTextField amountField = new JTextField();
    private final JLabel amountLabel = new JLabel("Amount");

    private final JTextField toWhereField = new JTextField();
    private final JLabel toWhereLabel = new JLabel("To: ");

    private HashMap<String, Account> accounts;

    public WelcomePage(Account correspondingAccount) {
        String ss = correspondingAccount.showInfo();

        String[] parts = ss.split("\n");

        accTypeLabel.setBounds(0,0,1000,35);
        accTypeLabel.setFont(new Font(null, Font.PLAIN,20));
        accTypeLabel.setText(parts[0]);
        frame.add(accTypeLabel);

        nameLabel.setBounds(0, 40, 1000, 35);
        nameLabel.setFont(new Font(null, Font.PLAIN,20));
        nameLabel.setText(parts[1]);
        frame.add(nameLabel);

        cnpLabel.setBounds(0, 80, 1000, 35);
        cnpLabel.setFont(new Font(null, Font.PLAIN,20));
        cnpLabel.setText(parts[2]);
        frame.add(cnpLabel);

        depositLabel.setBounds(0, 120, 1000, 35);
        depositLabel.setFont(new Font(null, Font.PLAIN,20));
        depositLabel.setText(parts[3]);
        frame.add(depositLabel);

        accNumLabel.setBounds(0, 160, 1000, 35);
        accNumLabel.setFont(new Font(null, Font.PLAIN,20));
        accNumLabel.setText(parts[4]);
        frame.add(accNumLabel);

        rateLabel.setBounds(0, 200, 1000, 35);
        rateLabel.setFont(new Font(null, Font.PLAIN,20));
        rateLabel.setText(parts[5]);
        frame.add(rateLabel);

//        safetyOrDebitCardLabel.setBounds(0, 240, 1000, 35);
//        safetyOrDebitCardLabel.setFont(new Font(null, Font.PLAIN,20));
//        safetyOrDebitCardLabel.setText(parts[6]);
//        frame.add(safetyOrDebitCardLabel);
//
//        safetyOrCardPINLabel.setBounds(0, 280, 1000, 35);
//        safetyOrCardPINLabel.setFont(new Font(null, Font.PLAIN,20));
//        safetyOrCardPINLabel.setText(parts[7]);
//        frame.add(safetyOrCardPINLabel);

        depositButton.setBounds(100,350,100,25);
        depositButton.setFocusable(false);
        frame.add(depositButton);

        withDrawButton.setBounds(210,350,100,25);
        withDrawButton.setFocusable(false);
        frame.add(withDrawButton);

        transferButton.setBounds(320,350,100,25);
        transferButton.setFocusable(false);
        frame.add(transferButton);

        currentAccount = correspondingAccount;

        amountLabel.setBounds(180, 400, 50, 25);
        amountField.setBounds(235, 400, 40, 25);
        frame.add(amountField);
        frame.add(amountLabel);

        /**
         ByteArrayOutputStream baos = new ByteArrayOutputStream();
         PrintStream ps = new PrintStream(baos);
         // Save the old sys.out
         PrintStream old = System.out;
         System.setOut(ps);
         correspondingAccount.showInfo();
         System.out.flush();
         System.setOut(old);
         System.out.println(baos.toString());
         // welcomeLabel.setText(baos.toString()); */

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 600);
        frame.setLayout(null);
        frame.setVisible(true);
    }

    public String getCNP() {
        return CNP;
    }

    public Account getCurrentAccount() {
        return currentAccount;
    }

    public JFrame getFrame() {
        return frame;
    }

    public JLabel getAccTypeLabel() {
        return accTypeLabel;
    }

    public JLabel getNameLabel() {
        return nameLabel;
    }

    public JLabel getCnpLabel() {
        return cnpLabel;
    }

    public JLabel getDepositLabel() {
        return depositLabel;
    }

    public JLabel getAccNumLabel() {
        return accNumLabel;
    }

    public JLabel getRateLabel() {
        return rateLabel;
    }

    public JLabel getSafetyOrDebitCardLabel() {
        return safetyOrDebitCardLabel;
    }

    public JLabel getSafetyOrCardPINLabel() {
        return safetyOrCardPINLabel;
    }

    public JLabel getMessageLabel() {
        return messageLabel;
    }

    public JButton getDepositButton() {
        return depositButton;
    }

    public JButton getWithDrawButton() {
        return withDrawButton;
    }

    public JButton getTransferButton() {
        return transferButton;
    }

    public JTextField getAmountField() {
        return amountField;
    }

    public JLabel getAmountLabel() {
        return amountLabel;
    }

    public JTextField getToWhereField() {
        return toWhereField;
    }

    public JLabel getToWhereLabel() {
        return toWhereLabel;
    }

    public HashMap<String, Account> getAccounts() {
        return accounts;
    }
}
