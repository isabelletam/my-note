package ui;

import javax.swing.*;

// Displays dog photo for phase 3 requirement
public class DontClick {

    public DontClick() {
        JFrame frame = new JFrame();
        ImageIcon icon = new ImageIcon(getClass().getResource("tobs.jpg"));
        JLabel label = new JLabel(icon);
        frame.add(label);
        frame.pack();
        frame.setVisible(true);
    }
}
