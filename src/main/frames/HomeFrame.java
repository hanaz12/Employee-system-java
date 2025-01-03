package main.frames;

import main.config.Schema;
import main.panels.HomePanel;
import javax.swing.*;

public class HomeFrame extends Schema {
    public HomeFrame() {
        JFrame frame = new JFrame("Home Frame");
        frame.getContentPane().add(new HomePanel());
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(sizeX(),sizeY());
        frame.setLocation(getLocationX(), getLocationY());
        frame.setVisible(isVisible());
    }
}