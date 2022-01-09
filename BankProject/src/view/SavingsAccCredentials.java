package view;

import javax.swing.*;
import java.awt.*;

public class SavingsAccCredentials extends JFrame {
    private final JFrame frame = new JFrame();

    private final JButton loginButton = new JButton("Login");
    private final JButton resetButton = new JButton("Reset");
    private final JTextField CNPField = new JTextField();
    private final JPasswordField userPasswordField = new JPasswordField();
    private final JLabel CNPLabel = new JLabel("Safety Deposit ID:");
    private final JLabel userPasswordLabel = new JLabel("Safety Deposit Key:");
    private final JLabel messageLabel = new JLabel();

    public SavingsAccCredentials() {

        CNPLabel.setBounds(55, 100, 200, 25);
        userPasswordLabel.setBounds(50, 150, 200, 25);

        messageLabel.setBounds(60, 250, 300, 35);
        messageLabel.setFont(new Font(null, Font.ITALIC, 25));

        CNPField.setBounds(165, 100, 200, 25);
        userPasswordField.setBounds(165, 150, 200, 25);

        loginButton.setBounds(125, 200, 100, 25);
        loginButton.setFocusable(false);

        resetButton.setBounds(225, 200, 100, 25);
        resetButton.setFocusable(false);

        frame.add(CNPLabel);
        frame.add(userPasswordLabel);
        frame.add(messageLabel);
        frame.add(CNPField);
        frame.add(userPasswordField);
        frame.add(loginButton);
        frame.add(resetButton);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420, 420);
        frame.setLayout(null);
        frame.setVisible(true);
    }

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

    public JLabel getMessageLabel() {
        return messageLabel;
    }
}