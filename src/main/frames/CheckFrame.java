package main.frames;

import main.config.Schema;
import main.panels.CheckPanel;
import javax.swing.*;

public class CheckFrame extends Schema {
    public CheckFrame() {
        JFrame frame = new JFrame("Check");
        frame.getContentPane().add(new CheckPanel());
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(sizeX(), sizeY());
        frame.setLocation(getLocationX(), getLocationY());
        frame.setVisible(isVisible());
    }
}