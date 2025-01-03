package main.panels;
import main.config.ButtonCustomizer;
import main.frames.*;
import main.models.Data;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class LoginPanel extends JPanel {
    private JTextField foruserid;
    private JPasswordField foruserpassword;

    public LoginPanel() {
        setBackground(Color.WHITE);
        setLayout(null);
        setBackground(new Color(72, 61, 139));

        JLabel label = new JLabel("Please enter your data if you are an existing employee or sign-up.");
        label.setBounds(20, 40, 2000, 60);
        label.setFont(new Font("Monospaced", Font.BOLD, 30));
        label.setForeground(Color.white);

        // label for ID
        JLabel ID = new JLabel("ID:");
        ID.setBounds(150, 200, 200, 30);
        ID.setForeground(Color.white);
        // text field for ID
        foruserid = new JTextField();
        foruserid.setBounds(250, 200, 200, 30);

        // label for password textfield
        JLabel password = new JLabel("Password:");
        password.setBounds(150, 250, 200, 30);
        password.setForeground(Color.white);
        // password textfield
        foruserpassword = new JPasswordField();
        foruserpassword.setBounds(250, 250, 200, 30);

        // log in button
        JButton loginButton = new JButton("Login");
        loginButton.setBounds(200, 320, 100, 35);
        ButtonCustomizer.customizeButton(loginButton);

        // sign up button
        JButton signUpButton = new JButton("Sign up");
        signUpButton.setBounds(350, 320, 100, 35);
        ButtonCustomizer.customizeButton(signUpButton);

        JButton home_button = new JButton("Home");
        home_button.setBounds(25,20,55,25);
        home_button.setFont(new Font("Arial", Font.BOLD, 5));
        ButtonCustomizer.customizeButton(home_button);
        add(home_button);
        home_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new HomeFrame();
                SwingUtilities.getWindowAncestor(LoginPanel.this).dispose();
            }
        });


        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SwingUtilities.getWindowAncestor(LoginPanel.this).dispose();
                checkLogin();
            }
        });

        signUpButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new SignupFrame();
                SwingUtilities.getWindowAncestor(LoginPanel.this).dispose();
            }
        });

        add(label);
        add(foruserid);
        add(ID);
        add(password);
        add(foruserpassword);
        add(loginButton);
        add(signUpButton);

    }

    private boolean validateInput(String id, String password) {
        if (id.isEmpty() || password.isEmpty()) return false;
        int u = id.length();
        for (int i = 0; i < u; i++) {
            if (id.charAt(i) < '0' || id.charAt(i) > '9') return false;
        }
        return true;
    }

    private void checkLogin() {
        String url = "jdbc:mysql://127.0.0.1:3306/employee";
        String username = "root";
        String password = "root";

        try {
            String userid = foruserid.getText();
            String userpassword = String.valueOf(foruserpassword.getPassword());
            if (!validateInput(userid, userpassword)) {
                JOptionPane.showMessageDialog(null, "Invalid format, try again");
                new LoginFrame();
                SwingUtilities.getWindowAncestor(LoginPanel.this).dispose();
                return;
            }

            Connection connection = DriverManager.getConnection(url, username, password);
            int ID = Integer.parseInt(userid);
            Data.id=ID;
            String sql = "select * from employee_table where id= ? AND  password = ? ";
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, ID);
            statement.setString(2, userpassword);
            ResultSet result = statement.executeQuery();
            if (result.next()) {
                new HoursFrame();
                SwingUtilities.getWindowAncestor(LoginPanel.this).dispose();

            } else {
                // الداتا بتاعته كده مش تمام والمفروض اظهرله ال check frame
                new CheckFrame();
            }
            connection.close();
        } catch (SQLException ex) {
            System.err.println("Error connecting to the database: " + ex.getMessage());
        }
    }
}
