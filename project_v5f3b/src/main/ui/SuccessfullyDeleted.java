//package ui;
//
//import model.EntryList;
//
//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//
//public class SuccessfullyDeleted implements ActionListener {
//
//    JTextArea allEntries;
//
//    JFrame frame;
//    JPanel panel;
//
//    JLabel label;
//
//    JButton back;
//
//    private EntryList entryList;
//
//    // Effects: Creates new PracticeEntriesWindow
//    public SuccessfullyDeleted(EntryList entrylist) {
//        this.entryList = entrylist;
//        frame = new JFrame();
//        panel = new JPanel();
//
//        label = new JLabel("Successfully deleted!");
//
//        initializePanelPracticeEntries();
//
//        initializeFrame();
//    }
//
//    // Modifies: This
//    // Effects: Sets up all panel settings
//    private void initializePanelPracticeEntries() {
//        panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
//        panel.setLayout(new FlowLayout());
//        panel.setBackground(new Color(191, 198, 203));
//        panel.add(label);
//
//        back = new JButton("return");
//
//
//        back.addActionListener(this);
//
//        panel.add(back);
//    }
//
//    // Effects: Calls correct method with corresponding action listener input
//    @Override
//    public void actionPerformed(ActionEvent e) {
//        if (e.getSource() == back) {
//            frame.dispose();
//            new MyNoteAppGUI(entryList);
//        }
//    }
//
//    // Effects: initializes frame settings
//    public void initializeFrame() {
//        frame.add(panel, BorderLayout.CENTER);
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.setTitle("Practice time!");
//        frame.setSize(700, 500);
////        frame.pack();
//        frame.setVisible(true);
//    }
//}
