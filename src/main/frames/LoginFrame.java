package main.frames;

import main.config.Schema;
import main.panels.LoginPanel;
import javax.swing.*;

public class LoginFrame extends Schema {
    public LoginFrame() {
        JFrame frame = new JFrame("Log In");
        frame.getContentPane().add(new LoginPanel());
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(sizeX(),sizeY());
        frame.setLocation(getLocationX(), getLocationY());
        frame.setVisible(isVisible());
    }
}
