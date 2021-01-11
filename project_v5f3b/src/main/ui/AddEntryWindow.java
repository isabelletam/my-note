package ui;

import model.Entry;
import model.EntryList;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Enumeration;


// Makes new window to add a new Entry to EntryList
public class AddEntryWindow implements ActionListener {

    private JFrame frame;

    private JLabel label = new JLabel("Add Entry");

    private JLabel word;
    private JTextField newWord;

    private JLabel definition;
    private JTextField newDefinition;

    private JLabel phonetics;
    private JTextField newPhonetics;

    private JLabel language;
    private JTextField newLanguage;

    private JLabel type;
    private JRadioButton noun;
    private JRadioButton verb;
    private JRadioButton adjective;
    private JRadioButton adverb;
    private JRadioButton particle;

    private JButton button;
    private JButton back;
    private JPanel panel;

    ButtonGroup group;

    private EntryList entryList;

    // EFFECTS: Constructs new EntryWindow
    public AddEntryWindow(EntryList entrylist) {
        frame = new JFrame();
        panel = new JPanel();

        this.entryList = entrylist;

        panelInitializeAddEntry();

        initializeFrameAddEntry();

    }

    // Modifies: This
    // Effects: Initializes all frame settings for window
    private void initializeFrameAddEntry() {
        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Add Entry");
        frame.setSize(700, 500);
//        frame.pack();
        frame.setVisible(true);
    }


    // Effects: Makes all the radial buttons
    private void makeButtonGroup() {
        group = new ButtonGroup();

        noun = new JRadioButton("Noun");
        verb = new JRadioButton("Verb");
        adjective = new JRadioButton("Adjective");
        adverb = new JRadioButton("Adverb");
        particle = new JRadioButton("Particle");

        group.add(noun);
        group.add(verb);
        group.add(adjective);
        group.add(adverb);
        group.add(particle);

        noun.addActionListener(this);
        verb.addActionListener(this);
        adjective.addActionListener(this);
        adverb.addActionListener(this);
        particle.addActionListener(this);
    }

    // Modifies: This
    // Effects: Initializes all panel settings for window
    private void panelInitializeAddEntry() {
        panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
        panel.setLayout(new GridLayout(0, 1));
        addPanelElements();
        panel.setBackground(new Color(191, 198, 203));

    }

    // Modifies: This
    // Effects: adds all panel elements
    private void addPanelElements() {

        makeButtonGroup();

        makePanelElements();

        panel.add(back);
        panel.add(label);
        panel.add(label, "push, align center");
        panel.add(word);
        panel.add(newWord);
        panel.add(definition);
        panel.add(newDefinition);
        panel.add(language);
        panel.add(newLanguage);
        panel.add(phonetics);
        panel.add(newPhonetics);
        panel.add(type);
        panel.add(noun);
        panel.add(verb);
        panel.add(adjective);
        panel.add(adverb);
        panel.add(particle);
        panel.add(button);

    }

    // Effects: makes all panel elements
    private void makePanelElements() {
        back = new JButton("return");
        word = new JLabel("Type in word:");
        newWord = new JTextField(20);
        definition = new JLabel("Add definition:");
        newDefinition = new JTextField(20);
        language = new JLabel("Add language:");
        newLanguage = new JTextField(20);
        phonetics = new JLabel("Add phonetics:");
        newPhonetics = new JTextField(20);
        type = new JLabel("Select type:");
        button = new JButton("Submit");
        button.addActionListener(this);
        back.addActionListener(this);

        label = new JLabel("Add Entry");
        label.setFont(new Font("HelveticaNeue-UltraLight", Font.BOLD, 18));
    }


    // Effects: takes in action performed and calls the correct method
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button) {
            makeNewEntry(e);
            frame.dispose();
            new MyNoteAppGUI(entryList);
        } else if (e.getSource() == back) {
            frame.dispose();
            new MyNoteAppGUI(entryList);
        }
    }


    // Effects: Makes a new entry
    private void makeNewEntry(ActionEvent e) {
        Entry entry = new Entry("", "");
        entry.setWord(newWord.getText());
        entry.setDefinition(newDefinition.getText());
        entry.setLanguage(newLanguage.getText());
        entry.setPhonetics(newPhonetics.getText());
        setType(e, entry);
        entryList.addEntry(entry);
//        System.out.println(entryList);
//        System.out.println(entryList.getSize());
    }

    // Effects: Sets type for new entry
    private void setType(ActionEvent e, Entry entry) {

        Enumeration<AbstractButton> buttons = group.getElements();

        while (buttons.hasMoreElements()) {
            AbstractButton button = buttons.nextElement();
            if (button.isSelected()) {
                if (button == noun) {
                    System.out.println("noun");
                    entry.setType("NOUN");
                } else if (button == verb) {
                    System.out.println("verb");
                    entry.setType("VERB");
                } else if (button == adjective) {
                    System.out.println("adjective");
                    entry.setType("ADJECTIVE");
                } else if (button == adverb) {
                    System.out.println("adverb");
                    entry.setType("ADVERB");
                } else if (button == particle) {
                    System.out.println("particle");
                    entry.setType("PARTICLE");
                }
            }
        }

    }
}
