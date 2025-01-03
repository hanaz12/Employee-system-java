package main.frames;

import main.config.Schema;
import main.panels.ControlPanel;
import javax.swing.*;

public class ControlFrame extends Schema {
    public ControlFrame() {
        JFrame frame = new JFrame("Control Panel");
        frame.getContentPane().add(new ControlPanel());
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(sizeX(), sizeY());
        frame.setLocation(getLocationX(), getLocationY());
        frame.setVisible(isVisible());
    }
}