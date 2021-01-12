//package ui;
//
//import model.Entry;
//import model.EntryList;
//
//import javax.swing.*;
//import java.awt.*;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//
//public class RemoveEntryWindow implements ActionListener {
//
////    JTextArea allEntries;
//
//    JFrame frame;
//    JPanel panel;
//
//    JLabel word;
//    JTextField wordRemoved;
//
//    JButton back;
//
//    JButton submit;
//
////    JButton all;
////    JButton byType;
//
//    private EntryList entryList;
//
//    // Effects: Creates new PracticeEntriesWindow
//    public RemoveEntryWindow(EntryList entrylist) {
//
//        this.entryList = entrylist;
//        frame = new JFrame();
//        panel = new JPanel();
//
////        label = new JLabel("Which entry would you like to remove?");
//
//        initializePanelRemoveEntries();
//
//        initializeFrame();
//    }
//
//    // Modifies: This
//    // Effects: Sets up all panel settings
//    private void initializePanelRemoveEntries() {
//        panel.setBorder(BorderFactory.createEmptyBorder(30, 30, 10, 30));
//        panel.setLayout(new FlowLayout());
//        panel.setBackground(new Color(191, 198, 203));
////        panel.add(label);
//
//        back = new JButton("return");
//        back.setPreferredSize(new Dimension(60, 20));
//
//        word = new JLabel("word you want to remove:");
//        wordRemoved = new JTextField(20);
//
//        wordRemoved.setBounds(140, 70, 200,30);
//                //setPreferredSize(new Dimension(20, 5));
//
//        submit = new JButton("submit");
//        submit.setPreferredSize(new Dimension(60, 20));
//
////        all = new JButton("See all Entries");
////        byType = new JButton("Sort by type");
//
//        back.addActionListener(this);
//        submit.addActionListener(this);
////        all.addActionListener(this);
////        byType.addActionListener(this);
//
////        panel.add(all);
////        panel.add(byType);
//        panel.add(word);
//        panel.add(wordRemoved);
//        panel.add(submit);
//        panel.add(back);
//    }
//
//    // Effects: Calls correct method with corresponding action listener input
//    @Override
//    public void actionPerformed(ActionEvent e) {
//        if (e.getSource() == submit) {
//            Entry toRemove = null;
//            for (Entry en : entryList) {
//                if (en.getWord().equals(wordRemoved.getText())) {
//                    toRemove = en;
//                }
//                break;
//            }
//            entryList.removeEntry(toRemove);
//            frame.dispose();
//            SuccessfullyDeleted successfullyDeleted = new SuccessfullyDeleted(entryList);
//        } else if (e.getSource() == back) {
//            frame.dispose();
//            new MyNoteAppGUI(entryList);
//        }
//    }
//
//    // Effects: initializes frame settings
//    public void initializeFrame() {
//        frame.add(panel, BorderLayout.CENTER);
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.setTitle("Remove entry");
//        frame.setSize(700, 500);
////        frame.pack();
//        frame.setVisible(true);
//    }
//}
