package ui;

import model.Entry;
import model.EntryList;
import model.EntryType;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

// Displays current entries by type
public class DisplayEntriesByType extends JFrame implements ActionListener {

    JButton back;

    JFrame frame;
    JPanel panel;

    JTable entryTable;
    //
    EntryList entrylist;
    DefaultTableModel tableModel;

    String[] columnNames = {"Word", "Phonetics", "Type", "Definition", "Language"};

    String[][] data;

    // Effects: Constructor for DisplayEntriesByType
    public DisplayEntriesByType(EntryList entrylist, EntryType type) {
        frame = new JFrame();
        panel = new JPanel();
//        back = new JButton("return");
//        back.setSize(20, 10);

        initializeFrame();

        panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
        panel.setLayout(new GridLayout(0, 1));
        panel.setBackground(new Color(191, 198, 203));
//        panel.add(back);

//        back.addActionListener(this);

        List<Entry> e = entrylist.returnAllEntries();
        entryTable = new JTable(data, columnNames);
        tableModel = new DefaultTableModel(5, e.size());
        entryTable = new JTable(tableModel);
    }

    // Effects: Constructs new JTable with all entries of selected type
    public JTable displayEntriesByType(EntryList entrylist, EntryType type) {

        List<Entry> e = entrylist.returnAllOfType(type);
        String[][] tableData = new String[e.size()][5];

        for (int i = 0; i < e.size(); i++) {
            String word = e.get(i).getWord();
            String phonetics = e.get(i).getPhonetics();
            String entryType = e.get(i).getType().toString(); // !!!
            String definition = e.get(i).getDefinition();
            String language = e.get(i).getLanguage();

            String[] data = {word, phonetics, entryType, definition, language};

            tableData[i] = data;
            tableModel.addRow(tableData);
        }

        JTable table = new JTable(tableData, columnNames);
        panel.add(new JScrollPane(table));
        return table;
    }

    // Effects: Returns user to PracticeEntriesWindow if "back" button is clicked
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == back) {
            frame.dispose();
            new SelectTypeWindow(entrylist);
        }
    }

    // Modifies: this
    // Effects: initializes frame settings
    public void initializeFrame() {
        frame.add(panel, BorderLayout.CENTER);
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Entries:");
        frame.setSize(700, 500);
//        frame.pack();
        frame.setVisible(true);
    }
}
