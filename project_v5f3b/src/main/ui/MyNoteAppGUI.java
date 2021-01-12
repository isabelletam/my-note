package ui;

import model.Entry;
import model.EntryList;
import persistence.JsonReader;
import persistence.JsonWriter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;

// watched Alex Lee's videos on youtube
// bless bro code on youtube too
// The GUI for my app!!
public class MyNoteAppGUI implements ActionListener {

    private static final String JSON_STORE = "./data/entries.json";
    private JsonWriter jsonWriter;
    private JsonReader jsonReader;

    private EntryList entrylist;

    private JFrame frame;
    private JLabel label;
    private JPanel panel;

    private JLabel word;
    private JButton button;
    private JLabel success;

    JButton addEntry = new JButton("add entry");
    JButton editEntry = new JButton("edit previous entry");
    JButton practice = new JButton("practice");
    JButton save = new JButton("save data");
    JButton load = new JButton("load data");
    JButton quit = new JButton("exit");
    JButton dontclick = new JButton("SURPRISE!!");
    JButton removeEntry = new JButton("remove entry");


    // Effects: Constructor for GUI
    public MyNoteAppGUI() {
        frame = new JFrame();
        label = new JLabel("Welcome to myNote!");
        setLabel();
        panel = new JPanel();
        entrylist = new EntryList();
        jsonWriter = new JsonWriter(JSON_STORE);
        jsonReader = new JsonReader(JSON_STORE);
        displayMenu();
    }

    // Effects: Constructor for GUI - sets entrylist
    public MyNoteAppGUI(EntryList entrylist) {
        this();
        this.entrylist = entrylist;
    }

    // Modifies: This
    // Effects: Sets label settings
    private void setLabel() {
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setVerticalAlignment(JLabel.TOP);
        label.setFont(new Font("HelveticaNeue-UltraLight", Font.PLAIN, 25));
        label.setBackground(new Color(191, 198, 203));
//        label.setBounds(350, 50, 300, 100);
        label.setOpaque(true);
    }

    // Effects: Displays all "main menu" components
    public void displayMenu() {

        addEntry.addActionListener(this);
        editEntry.addActionListener(this);
        practice.addActionListener(this);
        removeEntry.addActionListener(this);
        quit.addActionListener(this);
        save.addActionListener(this);
        load.addActionListener(this);
        dontclick.addActionListener(this);
        panelInitialize(addEntry, editEntry, practice, save, load, quit, dontclick);

        frameInitialize();

    }

    // Modifies: This
    // Effects: Initialize panel settings
    private void panelInitialize(JButton addEntry, JButton editEntry, JButton practice, JButton save,
                                 JButton load, JButton quit, JButton dontclick) {
        panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
        panel.setLayout(new GridLayout(0, 1));
        panel.add(label);
        panel.add(label, "push, align center");
        panel.add(addEntry);
//        panel.add(removeEntry);
//        panel.add(editEntry);
        panel.add(practice);
        panel.setBackground(new Color(191, 198, 203));
        panel.add(save);
        panel.add(load);
        panel.add(quit);
        panel.add(dontclick);
    }

    // Modifies: This
    // Effects: Initialize frame settings
    private void frameInitialize() {
        frame.add(panel, BorderLayout.CENTER);
        frame.setSize(700, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("MyNoteApp");
//        frame.getContentPane().setBackground(new Color(137, 207, 240));
//        frame.pack();
//        frame.setLayout(null);
        frame.setVisible(true);
    }

    // EFFECTS: saves the workroom to file
    private void saveEntryList() {
        try {
//            System.out.println(entrylist);
//            System.out.println(entrylist.getSize());
            jsonWriter.open();
            jsonWriter.write(entrylist);
            jsonWriter.close();
            System.out.println("Saved "  + " to " + JSON_STORE);
        } catch (FileNotFoundException e) {
            System.out.println("Unable to write to file: " + JSON_STORE);
        }
    }

    // MODIFIES: this
    // EFFECTS: loads workroom from file
    private void loadEntryList() {
        try {
            entrylist = jsonReader.read();
            for (Entry e : entrylist.returnAllEntries()) {
                System.out.println(e.getType());
            }
//            System.out.println(entrylist.returnAllEntries());
            System.out.println("Loaded " + " from " + JSON_STORE);
        } catch (IOException e) {
            System.out.println("Unable to read from file: " + JSON_STORE);
        }
    }


    // Effects: Calls the correct method depending on input from action listener - Creates new window depending
    // on which button and whether or not the frame needs to be disposed of
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addEntry) {
            frame.dispose();
//            System.out.println(entrylist.getSize());
//            System.out.println(entrylist);
            AddEntryWindow entryWindow = new AddEntryWindow(entrylist);
        } else if (e.getSource() == practice) {
            frame.dispose();
            PracticeEntriesWindow practiceEntries = new PracticeEntriesWindow(entrylist);
        } else if (e.getSource() == editEntry) {
            frame.dispose();
            EditEntryWindow editEntryWindow = new EditEntryWindow();
        } else if (e.getSource() == quit) {
            System.exit(0);
//        } else if (e.getSource() == removeEntry) {
//            frame.dispose();
//            RemoveEntryWindow removeEntryWindow = new RemoveEntryWindow(entrylist);
        } else if (e.getSource() == save) {
            saveEntryList();
        } else if (e.getSource() == load) {
            loadEntryList();
        } else if (e.getSource() == dontclick) {
            new DontClick();
        }
    }
}
