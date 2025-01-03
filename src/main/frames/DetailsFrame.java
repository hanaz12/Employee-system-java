package main.frames;

import main.config.Schema;
import main.panels.DetailsPanel;
import javax.swing.*;

public class DetailsFrame extends Schema {
    public DetailsFrame() {
        JFrame frame = new JFrame("Employee Details");
        frame.getContentPane().add(new DetailsPanel());
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(sizeX(), sizeY());
        frame.setLocation(getLocationX(), getLocationY());
        frame.setVisible(isVisible());
    }
}
