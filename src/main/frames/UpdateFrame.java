package main.frames;

import main.config.Schema;
import main.panels.UpdatePanel;
import javax.swing.*;

public class UpdateFrame extends Schema {
    public UpdateFrame() {
        JFrame frame = new JFrame("Update Employee");
        frame.getContentPane().add(new UpdatePanel());
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(sizeX(), sizeY());
        frame.setLocation(getLocationX(), getLocationY());
        frame.setVisible(isVisible());
    }
}
