package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


// !!! how can i retrieve my entry? and then fill out its current fields.
// Creates new EditEntryWindow (but its not like it works I gave up cause we dont need to implement our old
// user stories LOL
public class EditEntryWindow implements ActionListener {

    JFrame frame;
    JPanel panel;

    JLabel label;

    JLabel word;
    JTextField wordField;
    JLabel definition;
    JTextField definitionField;

    JButton back;
    JButton success;

    JLabel type;

    JRadioButton noun;
    JRadioButton verb;
    JRadioButton adjective;
    JRadioButton adverb;
    JRadioButton particle;


    public EditEntryWindow() {
        frame = new JFrame();
        panel = new JPanel();

        makeRadioButtonGroup();
        initializePanelElementsEditEntry();
        addActionListenerEditEntry();
        initializeFrame();

    }

    // Effects: Instantiates all my radial buttons
    private void makeRadioButtonGroup() {
        ButtonGroup group = new ButtonGroup();

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
    }

    // Modifies: this
    // Effects: Sets up all panel elements
    private void initializePanelElementsEditEntry() {
        panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
        panel.setLayout(new GridLayout(0, 1));
        panel.setBackground(new Color(191, 198, 203));

        label = new JLabel("Edit entry:");
        label.setFont(new Font("HelveticaNeue-UltraLight", Font.BOLD, 18));

        word = new JLabel("Word:");
        wordField = new JTextField(20);
        definition = new JLabel("Definition:");
        definitionField = new JTextField(20);
        type = new JLabel();
        back = new JButton("return");
        success = new JButton("submit");

        addPanelElementsEditEntry();


    }

    // Effects: adds panel elements to panel
    private void addPanelElementsEditEntry() {
        panel.add(back);
        panel.add(label);
        panel.add(word);
        panel.add(wordField);
        panel.add(definition);
        panel.add(definitionField);
        panel.add(type);
        panel.add(noun);
        panel.add(adjective);
        panel.add(adverb);
        panel.add(particle);
        panel.add(success);
    }

    // Effects: helping to add action listener method to buttons
    private void addActionListenerEditEntry() {
        noun.addActionListener(this);
        verb.addActionListener(this);
        adjective.addActionListener(this);
        adverb.addActionListener(this);
        particle.addActionListener(this);
        back.addActionListener(this);
        success.addActionListener(this);
    }

    // Effects: takes in action performed and calls the correct method
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == back) {
            MyNoteAppGUI myNoteAppGUI = new MyNoteAppGUI();
        } else if (e.getSource() == success) {
            // somehow update the word
            MyNoteAppGUI myNoteAppGUI2 = new MyNoteAppGUI();
        }
    }

    // Modifies: this
    // Effects: initializes frame settings
    public void initializeFrame() {
        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Edit Entry");
//        frame.setLayout(new FlowLayout());
        frame.setSize(700, 500);
//        frame.pack();
        frame.setVisible(true);
    }
}
