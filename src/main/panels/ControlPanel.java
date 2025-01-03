package main.panels;

import main.config.ButtonCustomizer;
import main.frames.DeleteFrame;
import main.frames.HomeFrame;
import main.frames.UpdateFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ControlPanel extends JFrame {
    public ControlPanel() {
        setLayout(null);
        setBackground(new Color(72, 61, 139));
        JLabel labelempId = new JLabel("Delete or Update Users:");
        labelempId.setFont(new Font("serif", Font.PLAIN, 30));
        labelempId.setBounds(40, 40, 1000, 60);
        add(labelempId);

        JButton delete = new JButton("Delete");
        delete.setBounds(80, 200, 100, 30);
        ButtonCustomizer.customizeButton(delete);
        delete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Open a new frame when the "Delete" button is clicked
                new DeleteFrame();
                SwingUtilities.getWindowAncestor(ControlPanel.this).dispose();
            }
        });
        add(delete);

        JButton update = new JButton("Update");
        update.setBounds(220, 200, 100, 30);
        ButtonCustomizer.customizeButton(update);
        update.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Open a new frame when the "Update" button is clicked
                new UpdateFrame();
                SwingUtilities.getWindowAncestor(ControlPanel.this).dispose();
            }
        });
        JButton home_button = new JButton("Home");
        home_button.setBounds(25,20,55,25);
        home_button.setFont(new Font("Arial", Font.BOLD, 5));
        ButtonCustomizer.customizeButton(home_button);
        add(home_button);
        home_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new HomeFrame();
                SwingUtilities.getWindowAncestor(ControlPanel.this).dispose();
            }
        });
        add(update);


    }
}
