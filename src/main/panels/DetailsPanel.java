package main.panels;

import main.config.ButtonCustomizer;
import main.frames.HomeFrame;
import main.models.Data;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class DetailsPanel extends JPanel {

    public DetailsPanel() {
        setBackground(new Color(72, 61, 139));
        setLayout(new BorderLayout(15,15));
        JPanel dataPnl=new JPanel( new GridLayout(5,2));
        dataPnl.setBackground(new Color(72, 61, 139));
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/employee", "root", "root");
            PreparedStatement stat = con.prepareStatement("SELECT * FROM employee_table WHERE id = ?");
            stat.setInt(1, Data.id);
            ResultSet re = stat.executeQuery();
            if (re.next()) {
                int id = re.getInt("id");
                JLabel lbID = new JLabel("ID");
                lbID.setSize(100, 30);
                lbID.setFont(new Font("serif", Font.PLAIN, 20));
                lbID.setForeground(Color.WHITE);
                dataPnl.add(lbID);
                //////////////
                String idField = String.valueOf(id);
                JLabel lbIDField = new JLabel(idField);
                lbIDField.setSize(100, 30);
                lbIDField.setFont(new Font("serif", Font.PLAIN, 20));
                lbIDField.setForeground(Color.WHITE);
                dataPnl.add(lbIDField);
                ///////////////
                JLabel name = new JLabel("Name:");
                name.setSize(100, 30);
                name.setFont(new Font("serif", Font.PLAIN, 20));
                name.setForeground(Color.WHITE);
                dataPnl.add(name);
                /////////////////
                String nameD = re.getString("name");
                JLabel nameField = new JLabel(nameD);
                nameField.setSize(100, 30);
                nameField.setFont(new Font("serif", Font.PLAIN, 20));
                nameField.setForeground(Color.WHITE);
                dataPnl.add(nameField);
                /////////////////////
                JLabel Department = new JLabel("Department:");
                Department.setSize(100, 30);
                Department.setFont(new Font("serif", Font.PLAIN, 20));
                Department.setForeground(Color.WHITE);
                dataPnl.add(Department);
                ///////////////////////
                String dep = re.getString("department");
                JLabel depF = new JLabel(dep);
                depF.setSize(100, 30);
                depF.setFont(new Font("serif", Font.PLAIN, 20));
                depF.setForeground(Color.WHITE);
                dataPnl.add(depF);
                //////////////////////////
                JLabel hrs = new JLabel("Hours:");
                hrs.setSize(100, 30);
                hrs.setFont(new Font("serif", Font.PLAIN, 20));
                hrs.setForeground(Color.WHITE);
                dataPnl.add(hrs);
                ///////////////////////////
                String hours = String.valueOf(Data.hours);
                JLabel hor = new JLabel(hours);
                hor.setSize(100, 30);
                hor.setFont(new Font("serif", Font.PLAIN, 20));
                hor.setForeground(Color.WHITE);
                dataPnl.add(hor);
                ///////////////////////////////
                JLabel sal = new JLabel("Salary:");
                sal.setSize(100, 30);
                sal.setFont(new Font("serif", Font.PLAIN, 20));
                sal.setForeground(Color.WHITE);
                dataPnl.add(sal);
                ////////////////////////////////
                JLabel Salary = new JLabel(String.valueOf(Data.salary));
                Salary.setSize(100, 30);
                Salary.setFont(new Font("serif", Font.PLAIN, 20));
                Salary.setForeground(Color.WHITE);
                dataPnl.add(Salary);
            } else {
                JOptionPane.showMessageDialog(null, "employee not exist try again");
            }
        }
        catch (SQLException ex) {
            ex.printStackTrace();
        }
        JPanel button=new JPanel();
        button.setBackground(new Color(72, 61, 139));
        JButton btn=new JButton("EXIT");
        btn.setBounds(700, 400, 120, 60);
        ButtonCustomizer.customizeButton(btn);

        JButton login=new JButton("HOME PAGE");
        login.setBounds(700, 400, 120, 60);
        ButtonCustomizer.customizeButton(login);

        button.add(login);
        button.add(btn);

        add(dataPnl,BorderLayout.CENTER);
        add(button,BorderLayout.SOUTH);
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SwingUtilities.getWindowAncestor(DetailsPanel.this).dispose();
            }
        });
        login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new HomeFrame();
                SwingUtilities.getWindowAncestor(DetailsPanel.this).dispose();
            }}); }}

