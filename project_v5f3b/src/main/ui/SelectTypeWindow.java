package ui;

import model.EntryList;
import model.EntryType;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Allows you to select type when trying to sort entries by type
public class SelectTypeWindow implements ActionListener {

    private EntryList entryList;

    JFrame frame;
    JPanel panel;

    JLabel label;

    JButton back;

    JButton noun;
    JButton verb;
    JButton adjective;
    JButton adverb;
    JButton particle;

    // Effects: Creates new SelectTypeWindow
    public SelectTypeWindow(EntryList entryList) {

        this.entryList = entryList;
        frame = new JFrame();
        panel = new JPanel();

        label = new JLabel("Select which type of word:");

        back = new JButton("return");

        noun = new JButton("noun");
        verb = new JButton("verb");
        adjective = new JButton("adjective");
        adverb = new JButton("adverb");
        particle = new JButton("particle");

        typeAddActionListener();

        initializePanelSelectType();

        initializeFrame();

    }

    // Effect: Calls addActionListener method on all buttons
    private void typeAddActionListener() {
        noun.addActionListener(this);
        verb.addActionListener(this);
        adjective.addActionListener(this);
        adverb.addActionListener(this);
        particle.addActionListener(this);
        back.addActionListener(this);
    }

    // Modifies: This
    // Effects: initializes panel setup
    private void initializePanelSelectType() {
        panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
        panel.setLayout(new GridLayout(0, 1));
        panel.setBackground(new Color(191, 198, 203));
        panel.add(label);
        panel.add(noun);
        panel.add(verb);
        panel.add(adjective);
        panel.add(adverb);
        panel.add(particle);
        panel.add(back);
    }

    // Effects: calls method corresponding to each action event
    @Override
    public void actionPerformed(ActionEvent e) {
        EntryType type = getTypeForSelectType(e);
        if (e.getSource() == back) {
            frame.dispose();
            new PracticeEntriesWindow(entryList);
        } else {
            new DisplayEntriesByType(entryList, type).displayEntriesByType(entryList, type);
        }
    }

    // Effect: returns correct type with corresponding button
    private EntryType getTypeForSelectType(ActionEvent e) {
        EntryType type = null;
        if (e.getSource() == noun) {
            return EntryType.NOUN;
        } else if (e.getSource() == verb) {
            return EntryType.VERB;
        } else if (e.getSource() == adjective) {
            return EntryType.ADJECTIVE;
        } else if (e.getSource() == adverb) {
            return EntryType.ADVERB;
        } else  {
            return EntryType.PARTICLE;
        }
    }

    // Effect: Initializes frame setup
    public void initializeFrame() {
        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Practice time!");
        frame.setSize(700, 500);
//        frame.pack();
        frame.setVisible(true);
    }
}

