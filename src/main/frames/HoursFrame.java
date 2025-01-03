package main.frames;

import main.config.Schema;
import main.panels.HoursPanel;
import javax.swing.*;

public class HoursFrame extends Schema {
    public HoursFrame() {
        JFrame frame = new JFrame("Insert Hours");
        frame.getContentPane().add(new HoursPanel());
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(sizeX(), sizeY());
        frame.setLocation(getLocationX(), getLocationY());
        frame.setVisible(isVisible());
    }
}