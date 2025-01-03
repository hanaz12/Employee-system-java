package main.frames;
import main.panels.IntPanel;
import javax.swing.*;

public class IntFrame {
    public IntFrame() {
        JFrame frame = new JFrame("Get Salary ");
        frame.getContentPane().add(new IntPanel());
        frame.setSize(250, 250);

        frame.setLocationRelativeTo(null);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}