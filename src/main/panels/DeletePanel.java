package main.panels;

import main.config.ButtonCustomizer;
import main.frames.DeleteFrame;
import main.frames.HomeFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class DeletePanel extends JPanel {
    public DeletePanel() {
        setLayout(null);
        setBackground(new Color(72, 61, 139));

        JLabel labelempId = new JLabel("Employee Id:");
        labelempId.setBounds(50, 50, 100, 30);
        add(labelempId);

        JButton d = new JButton("Delete");
        d.setBounds(150, 140, 100, 30);
        ButtonCustomizer.customizeButton(d);
        add(d);

        JTextField textFieldEmpId = new JTextField();
        textFieldEmpId.setBounds(150, 50, 150, 30);
        add(textFieldEmpId);

        setSize(400, 300);

        JButton home_button = new JButton("Home");
        home_button.setBounds(25,20,55,25);
        home_button.setFont(new Font("Arial", Font.BOLD, 5));
        ButtonCustomizer.customizeButton(home_button);
        add(home_button);
        home_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new HomeFrame();
                SwingUtilities.getWindowAncestor(DeletePanel.this).dispose();
            }
        });

        d.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String idText = textFieldEmpId.getText();
                if (!idText.isEmpty()) {
                    int id;

                    try {
                        id = Integer.parseInt(idText);
                    } catch (Exception d) {
                        JOptionPane.showMessageDialog(null, "enter valid input");
                        DeleteFrame frame = new DeleteFrame();
                        SwingUtilities.getWindowAncestor(DeletePanel.this).dispose();
                        return;
                    }

                    try {
                        Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/employee", "root", "root");
                        PreparedStatement stat = con.prepareStatement("SELECT * FROM employee_table WHERE id = ?");
                        stat.setInt(1, id);
                        ResultSet re = stat.executeQuery();

                        stat = con.prepareStatement("DELETE FROM employee_table WHERE id = ?");
                        stat.setInt(1, id);
                        int rowsAffected = stat.executeUpdate();


                        if (re.next()) {
                            String name = re.getString("name");
                            JOptionPane.showMessageDialog(null, "employee " + name + " has deleted");
                            SwingUtilities.getWindowAncestor(DeletePanel.this).dispose();
                        } else {
                            JOptionPane.showMessageDialog(null, "employee not exist try again");
                        }


                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }

                } else {
                    JOptionPane.showMessageDialog(null, "enter valid input");
                    DeleteFrame frame = new DeleteFrame();
                    SwingUtilities.getWindowAncestor(DeletePanel.this).dispose();
                }
            }
        });

    }
}
