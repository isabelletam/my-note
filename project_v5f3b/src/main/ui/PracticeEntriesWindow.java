package ui;

import model.EntryList;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Displays all entries in entrylist!
public class PracticeEntriesWindow implements ActionListener {

    JTextArea allEntries;

    JFrame frame;
    JPanel panel;

    JLabel label;

    JButton back;

    JButton all;
    JButton byType;

    private EntryList entryList;

    // Effects: Creates new PracticeEntriesWindow
    public PracticeEntriesWindow(EntryList entrylist) {

        this.entryList = entrylist;
        frame = new JFrame();
        panel = new JPanel();

        label = new JLabel("How would you like to pracice today?");

        initializePanelPracticeEntries();

        initializeFrame();
    }

    // Modifies: This
    // Effects: Sets up all panel settings
    private void initializePanelPracticeEntries() {
        panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
        panel.setLayout(new GridLayout(0, 1));
        panel.setBackground(new Color(191, 198, 203));
        panel.add(label);

        back = new JButton("return");

        all = new JButton("See all Entries");
        byType = new JButton("Sort by type");

        back.addActionListener(this);
        all.addActionListener(this);
        byType.addActionListener(this);

        panel.add(all);
        panel.add(byType);
        panel.add(back);
    }

    // Effects: Calls correct method with corresponding action listener input
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == all) {
            allEntries = new JTextArea();
            new DisplayAllEntries(entryList).displayAllEntries(entryList);
            System.out.println("all");
        } else if (e.getSource() == byType) {
            System.out.println("by type");
            SelectTypeWindow selectTypeWindow = new SelectTypeWindow(entryList);
        } else if (e.getSource() == back) {
            frame.dispose();
            new MyNoteAppGUI();
        }
    }

    // Effects: initializes frame settings
    public void initializeFrame() {
        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Practice time!");
        frame.setSize(700, 500);
//        frame.pack();
        frame.setVisible(true);
    }
}
