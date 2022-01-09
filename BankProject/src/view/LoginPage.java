package view;

import javax.swing.*;
import java.awt.*;

public class LoginPage extends JFrame {
    private final JFrame frame = new JFrame();

    private final JButton loginButton = new JButton("Login");
    private final JButton resetButton = new JButton("Reset");
    private final JTextField CNPField = new JTextField();
    private final JLabel CNPLabel = new JLabel("CNP:");
    private final JLabel messageLabel = new JLabel();

    public LoginPage() {
        CNPLabel.setBounds(50,100,75,25);
        CNPField.setBounds(125,100,200,25);

        messageLabel.setBounds(125,250,250,35);
        messageLabel.setFont(new Font(null, Font.ITALIC,25));

        loginButton.setBounds(125,200,100,25);
        loginButton.setFocusable(false);

        resetButton.setBounds(225,200,100,25);
        resetButton.setFocusable(false);

        frame.add(CNPLabel);
        frame.add(messageLabel);
        frame.add(CNPField);
        frame.add(loginButton);
        frame.add(resetButton);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420,420);
        frame.setLayout(null);
        frame.setVisible(true);
    }

    public JFrame getFrame() {
        return frame;
    }

    public JButton getResetButton() {
        return resetButton;
    }

    public JTextField getCNPField() {
        return CNPField;
    }

    public JLabel getMessageLabel() {
        return messageLabel;
    }

    public JButton getLoginButton() {
        return loginButton;
    }
}