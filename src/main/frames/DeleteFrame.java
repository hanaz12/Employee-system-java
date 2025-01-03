package main.frames;

import main.config.Schema;
import main.panels.DeletePanel;
import javax.swing.*;
import java.awt.*;

public class DeleteFrame extends Schema {
    public DeleteFrame() {
        JFrame frame = new JFrame("Delete Users");
        frame.getContentPane().setBackground(new Color(72, 61, 139));
        frame.getContentPane().add(new DeletePanel());
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(sizeX(), sizeY());
        frame.setLocation(getLocationX(), getLocationY());
        frame.setVisible(isVisible());
    }
}
