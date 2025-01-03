package main.panels;

import main.config.ButtonCustomizer;
import main.frames.LoginFrame;
import main.frames.SignupFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CheckPanel extends JPanel {
    public CheckPanel() {
        setLayout(null);
        setBackground(new Color(72, 61, 139));

        JLabel label = new JLabel("Invalid username or ID. Please try again...");
        label.setBounds(120, 40, 800, 60);
        label.setFont(new Font("Monospaced", Font.BOLD, 30));
        label.setForeground(Color.white);

        JButton loginButton = new JButton("Login");
        loginButton.setBounds(100, 400, 100, 35);
        ButtonCustomizer.customizeButton(loginButton);

        JButton signUpButton = new JButton("Sign up");
        signUpButton.setBounds(250, 400, 100, 35);
        ButtonCustomizer.customizeButton(signUpButton);

        signUpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new SignupFrame();
                SwingUtilities.getWindowAncestor(CheckPanel.this).dispose();
            }
        });

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new LoginFrame();
                SwingUtilities.getWindowAncestor(CheckPanel.this).dispose();
            }
        });
        add(label);
        add(loginButton);
        add(signUpButton);
    }
}
