package main.panels;

import main.config.ButtonCustomizer;
import main.frames.*;
import main.models.Data;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class HoursPanel extends JPanel {
    private JTextField hours_field;

    public HoursPanel() {
        setLayout(null);
        setBackground(new Color(72, 61, 139));


        JLabel insert_label = new JLabel("Insert number of your hours");
        insert_label.setBounds(120, 40, 1000, 60);
        insert_label.setFont(new Font("serif", Font.BOLD, 30));
        insert_label.setForeground(Color.WHITE);


        JLabel hours_label = new JLabel("Hours :");
        hours_label.setBounds(120, 150, 200, 60);
        hours_label.setFont(new Font("serif", Font.BOLD, 30));
        hours_label.setForeground(Color.WHITE);


        hours_field = new JTextField();
        hours_field.setBounds(250, 170, 150, 30);

        JButton showDetails_button = new JButton("OK");
        showDetails_button.setBounds(500, 400, 120, 40);
        ButtonCustomizer.customizeButton(showDetails_button);
        showDetails_button.setActionCommand("OK");

        JButton home_button = new JButton("Home");
        home_button.setBounds(25,20,55,25);
        home_button.setFont(new Font("Arial", Font.BOLD, 5));
        ButtonCustomizer.customizeButton(home_button);
        add(home_button);
        home_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new HomeFrame();
                SwingUtilities.getWindowAncestor(HoursPanel.this).dispose();
            }
        });

        showDetails_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                checkHours();
                /* go to details frame */
                DetailsFrame controlFrame = new DetailsFrame();
                SwingUtilities.getWindowAncestor(HoursPanel.this).dispose();
            }
        });
        add(insert_label);
        add(hours_label);
        add(hours_field);
        add(showDetails_button);
    }

    private boolean validateInput(String hours) {
        if (hours.isEmpty()) return false;
        int u = hours.length();
        for (int i = 0; i < u; i++) {
            if (hours.charAt(i) < '0' || hours.charAt(i) > '9') return false;
        }
        return true;
    }

    private void checkHours() {
        String url = "jdbc:mysql://127.0.0.1:3306/employee";
        String username = "root";
        String password = "root";

        try {

            String hours = hours_field.getText();
            if (!validateInput(hours)) {
                JOptionPane.showMessageDialog(null, "Invalid format, try again");
                HoursFrame frame = new HoursFrame();
                SwingUtilities.getWindowAncestor(HoursPanel.this).dispose();
                return;
            }
            Data.hours = Integer.parseInt(hours);
            Connection connection = DriverManager.getConnection(url, username, password);
            PreparedStatement stat = connection.prepareStatement("UPDATE employee_table SET hours = ?, salary = ? WHERE id = ?");
            stat.setInt(1, Data.hours);
            stat.setInt(2, Data.hours * 40);
            Data.salary=Data.hours * 40;
            stat.setInt(3, Data.id);
            int rowsAffected = stat.executeUpdate();

            if (rowsAffected > 0) {
                JOptionPane.showMessageDialog(null, "Employee record updated successfully!");
            } else {
                JOptionPane.showMessageDialog(null, "No records updated!");
            }

            connection.close();
        } catch (SQLException ex) {
            System.err.println("Error connecting to the database: " + ex.getMessage());
        }
    }
}
