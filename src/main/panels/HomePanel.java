package main.panels;

import main.config.ButtonCustomizer;
import main.frames.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HomePanel extends JPanel {
    public HomePanel() {
        setLayout(null);
        setBackground(new Color(72, 61, 139));

        JLabel headingLabel = new JLabel("Welcome To Our System");
        headingLabel.setBounds(120, 40, 1000, 60);
        headingLabel.setFont(new Font("Serif", Font.ITALIC, 30));
        headingLabel.setForeground(Color.WHITE);

        JButton adminButton = new JButton("Admin");
        adminButton.setBounds(700, 400, 120, 40);
        ButtonCustomizer.customizeButton(adminButton);

        JButton employeeButton = new JButton("Employee");
        employeeButton.setBounds(900, 400, 120, 40);
        ButtonCustomizer.customizeButton(employeeButton);

        adminButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ControlFrame();
                SwingUtilities.getWindowAncestor(HomePanel.this).dispose();
            }
        });

        employeeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new LoginFrame();
                SwingUtilities.getWindowAncestor(HomePanel.this).dispose();
            }
        });

        add(headingLabel);
        add(adminButton);
        add(employeeButton);
    }
}