package main.config;

import javax.swing.*;
import java.awt.*;

public class ButtonCustomizer {
    public static void customizeButton(JButton button) {
        button.setBackground(new Color(255, 255, 255));
        button.setForeground(new Color(72, 61, 139));
        button.setFont(new Font("Arial", Font.BOLD, 16));
        button.setBorder(BorderFactory.createRaisedBevelBorder());
    }
}