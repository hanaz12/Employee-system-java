package main.panels;

import main.config.ButtonCustomizer;
import main.frames.HomeFrame;
import main.frames.UpdateFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class UpdatePanel extends JPanel {
    public UpdatePanel() {
        setBackground(new Color(72, 61, 139));
        setLayout(null);


        JLabel lbID = new JLabel("ID");
        lbID.setBounds(40, 20, 100, 30);
        lbID.setFont(new Font("serif", Font.PLAIN, 20));
        lbID.setForeground(Color.WHITE);
        add(lbID);

        JTextField tfID = new JTextField();
        tfID.setBounds(150, 20, 150, 30);
        add(tfID);

        JLabel lbdep = new JLabel("Departement");
        lbdep.setBounds(40, 70, 130, 30);
        lbdep.setFont(new Font("serif", Font.PLAIN, 20));
        lbdep.setForeground(Color.WHITE);
        add(lbdep);

        JTextField tfdep = new JTextField();
        tfdep.setBounds(170, 70, 170, 33);
        add(tfdep);

        JLabel lbpass = new JLabel("Password");
        lbpass.setBounds(40, 120, 100, 30);
        lbpass.setFont(new Font("serif", Font.PLAIN, 20));
        lbpass.setForeground(Color.WHITE);
        add(lbpass);

        JTextField tfpass = new JTextField();
        tfpass.setBounds(150, 120, 150, 30);
        add(tfpass);

        JLabel lbhours = new JLabel("Hours");
        lbhours.setBounds(40, 170, 100, 30);
        lbhours.setFont(new Font("serif", Font.PLAIN, 20));
        lbhours.setForeground(Color.WHITE);
        add(lbhours);

        JTextField tfhours = new JTextField();
        tfhours.setBounds(150, 170, 150, 30);
        add(tfhours);

        JButton clickhere = new JButton("OK");
        clickhere.setBounds(200, 100, 150, 50);
        ButtonCustomizer.customizeButton(clickhere);
        clickhere.setLocation(130, 250);
        add(clickhere);

        JButton home_button = new JButton("Home");
        home_button.setBounds(25,20,55,25);
        home_button.setFont(new Font("Arial", Font.BOLD, 5));
        ButtonCustomizer.customizeButton(home_button);
        add(home_button);
        home_button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new HomeFrame();
                SwingUtilities.getWindowAncestor(UpdatePanel.this).dispose();
            }
        });

        setSize(400, 300);

        clickhere.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!tfID.getText().isEmpty()&&!tfdep.getText().isEmpty()&&!tfpass.getText().isEmpty()&&!tfhours.getText().isEmpty()){
                    try {
                        String id = tfID.getText();
                        String dep = tfdep.getText();
                        String pass = tfpass.getText();
                        String hours = tfhours.getText();

                        try{
                            Integer.parseInt(id);
                            Integer.parseInt(hours);
                        }catch (Exception d){
                            JOptionPane.showMessageDialog(null,"pleas enter valid data.");
                            new UpdateFrame();
                            SwingUtilities.getWindowAncestor(UpdatePanel.this).dispose();
                            return;
                        }


                        Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/employee", "root", "root");
                        PreparedStatement stmt = con.prepareStatement("UPDATE employee_table SET department = ? , password=? , hours=? WHERE id=? ");
                        stmt.setString(1, dep);
                        stmt.setString(2, pass);
                        stmt.setInt(3, Integer.parseInt(hours));
                        stmt.setInt(4, Integer.parseInt(id));

                        int rowsAffected = stmt.executeUpdate();

                        if (rowsAffected > 0) {
                            JOptionPane.showMessageDialog(null, "Employee record updated successfully!");
                        } else {
                            JOptionPane.showMessageDialog(null, "No records updated!");
                        }

                    } catch (Exception c) {
                        JOptionPane.showMessageDialog(null,"pleas enter valid data.");
                        new UpdateFrame();
                        SwingUtilities.getWindowAncestor(UpdatePanel.this).dispose();
                    }
                }else{
                    JOptionPane.showMessageDialog(null,"pleas enter data.");
                    new UpdateFrame();
                    SwingUtilities.getWindowAncestor(UpdatePanel.this).dispose();
                }

            }
        });

    }
}

