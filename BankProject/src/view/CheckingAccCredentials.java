package view;

import javax.swing.*;
import java.awt.*;

public class CheckingAccCredentials extends JFrame {
    private final JFrame frame = new JFrame();

    private final JButton loginButton = new JButton("Login");
    private final JButton resetButton = new JButton("Reset");
    private final JTextField CNPField = new JTextField();
    private final JPasswordField userPasswordField = new JPasswordField();
    private final JLabel CNPLabel = new JLabel("Debit Card Number:");
    private final JLabel userPasswordLabel = new JLabel("PIN:");
    private final JLabel messageLabel = new JLabel();

    public JFrame getFrame() {
        return frame;
    }

    public JButton getLoginButton() {
        return loginButton;
    }

    public JButton getResetButton() {
        return resetButton;
    }

    public JTextField getCNPField() {
        return CNPField;
    }

    public JPasswordField getUserPasswordField() {
        return userPasswordField;
    }

    public JLabel getCNPLabel() {
        return CNPLabel;
    }

    public JLabel getUserPasswordLabel() {
        return userPasswordLabel;
    }

    public JLabel getMessageLabel() {
        return messageLabel;
    }

    public CheckingAccCredentials() {

        CNPLabel.setBounds(20,100,200,25);
        userPasswordLabel.setBounds(50,150,75,25);

        messageLabel.setBounds(125,250,250,35);
        messageLabel.setFont(new Font(null,Font.ITALIC,25));

        CNPField.setBounds(140,100,200,25);
        userPasswordField.setBounds(140,150,200,25);

        loginButton.setBounds(125,200,100,25);
        loginButton.setFocusable(false);

        resetButton.setBounds(225,200,100,25);
        resetButton.setFocusable(false);

        frame.add(CNPLabel);
        frame.add(userPasswordLabel);
        frame.add(messageLabel);
        frame.add(CNPField);
        frame.add(userPasswordField);
        frame.add(loginButton);
        frame.add(resetButton);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420,420);
        frame.setLayout(null);
        frame.setVisible(true);
    }
}