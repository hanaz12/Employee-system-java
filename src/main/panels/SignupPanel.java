package main.panels;

import main.config.ButtonCustomizer;
import main.frames.*;
import main.models.Data;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class SignupPanel extends JPanel  {

    public SignupPanel() {
        setLayout(null);
        setBackground(new Color(72, 61, 139));

        JLabel name_label = new JLabel(" Name : ");
        name_label.setBounds(40, 20, 100, 30);
        name_label.setFont(new Font("serif", Font.PLAIN, 20));
        name_label.setForeground(Color.WHITE);


        JTextField name_field = new JTextField();
        name_field.setBounds(150, 20, 150, 30);


        JLabel department_label = new JLabel(" Department : ");
        department_label.setBounds(40, 70, 130, 30);
        department_label.setFont(new Font("serif", Font.PLAIN, 20));
        department_label.setForeground(Color.WHITE);


        JTextField department_field = new JTextField();
        department_field.setBounds(170, 70, 170, 33);


        JLabel phone_label = new JLabel(" Phone : ");
        phone_label.setBounds(40, 120, 100, 30);
        phone_label.setFont(new Font("serif", Font.PLAIN, 20));
        phone_label.setForeground(Color.WHITE);


        JTextField phone_field = new JTextField();
        phone_field.setBounds(150, 120, 150, 30);


        JLabel password_label = new JLabel(" Password : ");
        password_label.setBounds(40, 170, 100, 30);
        password_label.setFont(new Font("serif", Font.PLAIN, 20));
        password_label.setForeground(Color.WHITE);


        JTextField password_field = new JTextField();
        password_field.setBounds(150, 170, 150, 30);

        JButton save_button = new JButton(" Save ");
        save_button.setBounds(200, 100, 150, 50);
        ButtonCustomizer.customizeButton(save_button);
        save_button.setLocation(230, 250);


        JButton log_in_button = new JButton(" log in ");
        log_in_button.setBounds(200, 100, 150, 50);
        ButtonCustomizer.customizeButton(log_in_button);
        log_in_button.setLocation(40, 250);

        JButton home_button = new JButton("Home");
        home_button.setBounds(40,350,55,25);
        home_button.setFont(new Font("Arial", Font.BOLD, 5));
        ButtonCustomizer.customizeButton(home_button);
        add(home_button);
        home_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new HomeFrame();
                SwingUtilities.getWindowAncestor(SignupPanel.this).dispose();
            }
        });

        save_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent a) {

                if (!name_field.getText().isEmpty() && !department_field.getText().isEmpty() && !phone_field.getText().isEmpty() && !password_field.getText().isEmpty()) {

                    try {
                        Data.phone = Integer.parseInt(phone_field.getText());
                    } catch (Exception e) {
                        new IntFrame();
                        SwingUtilities.getWindowAncestor(SignupPanel.this).dispose();
                        return;
                    }

                    Data.name = name_field.getText();
                    Data.department = department_field.getText();
                    Data.password = password_field.getText();
                    Data.id = (int) (23000 * Math.random());

                    try {
                        Connection connection = DriverManager.getConnection(
                                "jdbc:mysql://127.0.0.1:3306/employee",
                                "root",
                                "root"
                        );
                        // id name department phone password hours salary
                        String query = "INSERT INTO employee_table values (? , ? , ? , ? , ? , 0 , 0)";
                        PreparedStatement statement = connection.prepareStatement(query);
                        statement.setInt(1, Data.id);
                        statement.setString(2, Data.name);
                        statement.setString(3, Data.department);
                        statement.setLong(4, Data.phone);
                        statement.setString(5, Data.password);
                        int rowsAffected = statement.executeUpdate();


                    } catch (SQLException e) {
                        e.printStackTrace();
                    }

                    JOptionPane.showMessageDialog(null, "your id is : " + Data.id);
                    new LoginFrame();
                    SwingUtilities.getWindowAncestor(SignupPanel.this).dispose();

                } else {
                    JOptionPane.showMessageDialog(null,"Please Enter Valid Data :)");
                    new SignupFrame();
                    SwingUtilities.getWindowAncestor(SignupPanel.this).dispose();
                }
            }
        });

        log_in_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new LoginFrame();
                SwingUtilities.getWindowAncestor(SignupPanel.this).dispose();
            }
        });

        add(name_label);
        add(name_field);
        add(department_label);
        add(department_field);
        add(phone_label);
        add(phone_field);
        add(password_label);
        add(password_field);
        add(save_button);
        add(log_in_button);
    }
}
