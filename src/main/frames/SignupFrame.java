package main.frames;

import main.config.Schema;
import main.panels.SignupPanel;
import javax.swing.*;

public class SignupFrame extends Schema {
    public SignupFrame() {
        JFrame frame = new JFrame("Sign Up");
        frame.getContentPane().add(new SignupPanel());
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(sizeX(), sizeY());
        frame.setLocation(getLocationX(), getLocationY());
        frame.setVisible(isVisible());
    }
}
