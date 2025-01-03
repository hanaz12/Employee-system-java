package main.panels;

import main.frames.SignupFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class IntPanel extends JPanel {
    public IntPanel() {
        setLayout(new FlowLayout());

        JLabel id_label = new JLabel("Please Enter Valid Data :)");

        JButton save_button = new JButton(" OK ");
        save_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new SignupFrame();
                SwingUtilities.getWindowAncestor(IntPanel.this).dispose();
            }
        });

        add(id_label);
        add(save_button);
    }
}
