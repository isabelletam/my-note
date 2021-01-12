//package ui;
//
//
//import model.Entry;
//import model.EntryList;
//import persistence.JsonReader;
//import persistence.JsonWriter;
//
//import java.io.FileNotFoundException;
//import java.io.IOException;
//import java.util.Scanner;
//
//// The code for my user interface
//// user interface for Entry app. Code based off of TellerApp.
//public class MyNoteApp {
//
//    private static final String JSON_STORE = "./data/entries.json";
//    private JsonWriter jsonWriter;
//    private JsonReader jsonReader;
//
//    private Scanner input;
//    private Entry entry;
//    private EntryList entrylist;
//
//    // EFFECTS: run MyNote application
//    public MyNoteApp() throws FileNotFoundException {
//        input = new Scanner(System.in);
//        entrylist = new EntryList();
//        jsonWriter = new JsonWriter(JSON_STORE);
//        jsonReader = new JsonReader(JSON_STORE);
//        runMyNoteApp();
//    }
//
//    // EFFECTS: processes user input
//    private void runMyNoteApp() {
//        boolean keepGoing = true;
//        String command = null;
//
//        initialize();
//
//        while (keepGoing) {
//            displayMenu();
//            command = input.nextLine();
//
//            if (command.equals("q")) {
//                keepGoing = false;
//            } else {
//                processCommand(command);
//            }
//        }
//
//        System.out.println("\nGood luck studying!");
//    }
//
//    // MODIFIES: this
//    // EFFECTS: processes user command
//    private void processCommand(String command) {
//        if (command.equals("a")) {
//            addNewEntry();
//        } else if (command.equals("e")) {
//            editEntry();
//        } else if (command.equals("p")) {
//            practiceEntry();
//        } else if (command.equals("s")) {
//            saveEntryList();
//        } else if (command.equals("l")) {
//            loadEntryList();
//        } else {
//            System.out.println("Selection not valid");
//        }
//    }
//
//    // MODIFIES: this
//    // EFFECTS: initializes EntryList
//    private void initialize() {
//        entrylist = new EntryList();
//        entry = new Entry("", "");
//        input = new Scanner(System.in);
//    }
//
//    // EFFECTS: displays menu of options to user
//    private void displayMenu() {
//        System.out.println("\nSelect from:");
//        System.out.println("\ta -> Add new entry");
//        System.out.println("\te -> Edit previous Entry");
//        System.out.println("\tp -> Practice!");
//        // !!!
//        System.out.println("\ts -> save work room to file");
//        System.out.println("\tl -> load work room from file");
//        System.out.println("\tq -> quit");
//    }
//
//    // MODIFIES: this
//    // EFFECTS: adds a new entry to entrylist
//    private void addNewEntry() {
//        Entry entry = new Entry("", "");
//        System.out.println("Set word:");
//        entry.setWord(input.nextLine());
//        System.out.println("Type: input from:");
//        System.out.println("n -> noun \nv -> verb \nad -> adjective \nadv -> adverb \np -> particle \nno -> none");
//        whatToPractice(input.nextLine());
//        System.out.println("Set language:");
//        entry.setLanguage(input.nextLine());
//        System.out.println("Set definition:");
//        String def = input.nextLine();
//        entry.setDefinition(def);
//        System.out.println("Set phonetics:");
//        String phon = input.nextLine();
//        entry.setPhonetics(phon);
//        System.out.println("Needs practice?:");
//        System.out.println("t for true");
//        System.out.println("f for false");
//        wantToPractice(input.nextLine(), entry);
//
//        System.out.println("Entry added! Onto the next one!");
//
//        this.entry = entry;
//        entrylist.addEntry(entry);
//    }
//
//    // MODIFIES: this
//    // EFFECTS: sets the type of the word based on input
//    private void whatToPractice(String command) {
//        if (command.equals("n")) {
//            entry.setType("noun");
//        } else if (command.equals("v")) {
//            entry.setType("verb");
//        } else if (command.equals("ad")) {
//            entry.setType("adjective");
//        } else if (command.equals("adv")) {
//            entry.setType("adverb");
//        } else if (command.equals("p")) {
//            entry.setType("particle");
//        } else if (command.equals("no")) {
//            entry.setType("none");
//        } else if (command.equals("q")) {
//
//            System.out.println("\nHappy studying!");
//        } else {
//            System.out.println("Selection not valid, try again");
//            whatToPractice(command);
//        }
//    }
//
//
//    // MODIFIES: this
//    // EFFECTS: sets practice status of entry
//    private void wantToPractice(String s, Entry e) {
//
//        if (s.equals("t")) {
//            e.needPractice();
//        } else if (s.equals("f")) {
//            e.doesNeedPractice();
//        } else {
//            System.out.println("Selection is invalid, enter input again");
//            wantToPractice(input.nextLine(), e);
////            input.nextLine();
//        }
//    }
//
//    // MODIFIES: this
//    // EFFECTS: edit entry
//    private void editEntry() {
//        String command = null;
//        Entry e = selectEntry();
//        while (true) {
//            nextMenu();
//            command = input.nextLine();
//            if (command.equals("q")) {
//                System.exit(0);
//            } else if (command.equals("w")) {
//                editWord(e);
//            } else if (command.equals("t")) {
//                editType(e);
//            } else if (command.equals("l")) {
//                editLanguage(e);
//            } else if (command.equals("d")) {
//                editDefinition(e);
//            } else if (command.equals("p")) {
//                editPracticeStatus(e);
//            } else {
//                System.out.println("Input is not valid, please try again");
//                editEntry();
//            }
////            displayMenu();
////            command = input.nextLine();
////            processCommand(command);
//        }
//
//    }
//
//
//    // EFFECTS: prints options for next menu
//    private void nextMenu() {
//        System.out.println("What would you like to edit?");
//        System.out.println("\nSelect from:");
//        System.out.println("\tw -> word?");
//        System.out.println("\tt -> type?");
//        System.out.println("\tl -> language?");
//        System.out.println("\td -> definition?");
//        System.out.println("\tp -> practice status?");
//        System.out.println("\tq -> quit");
//    }
//
//    // EFFECTS: returns current list of Entry
//    private void returnCurrentEntries() {
//        entrylist.returnAllEntries();
//    }
//
//    // EFFECTS: prompts user to select an already existing Entry and returns it
//    private Entry selectEntry() { // used to be void
//        returnCurrentEntries();
//        String selection = "";
//
//        System.out.println("Type in which word you want to select!");
//        selection = input.nextLine();
//
//        for (Entry e : entrylist.database) {
//
//            if (e.getWord().equals(selection)) {
//                printWord(e);
//                return e;
//            }
////            failedSelectEntry();
//        }
//        System.out.println("Entry not valid, please try again");
//        editEntry();
//        return null;
//    }
//
//    // EFFECTS: prints out "Selection is not valid, please try again" and displays menu again
//    private void failedSelectEntry() {
//        System.out.println("Selection is not valid, please try again");
//        displayMenu();
//        processCommand(input.nextLine());
//    }
//
//    // EFFECTS: returns list of current entries that need practice
//    private void practiceEntry() {
//        returnCurrentEntries();
//        displayMenu();
//        processCommand(input.nextLine());
//    }
//
//    // MODIFIES: this
//    // EFFECTS: sets entry.word = input.nextLine()
//    private void editWord(Entry e) {
//        System.out.println("What would you like to change the word to?");
//        e.setWord(input.nextLine());
//        System.out.println("Change is made! Onto the next task!");
//        returnToMenu();
//    }
//
//    // MODIFIES: this
//    // EFFECTS: sets entry.type = input.nextLine()
//    private void editType(Entry e) {
//        System.out.println("What would you like to change the type to?");
//        e.setType(input.nextLine());
//        System.out.println("Change is made! Onto the next task!");
//        returnToMenu();
//    }
//
//    // MODIFIES: this
//    // EFFECTS: sets entry.language = input.nextLine()
//    private void editLanguage(Entry e) {
//        System.out.println("What would you like to change the language to?");
//        e.setLanguage(input.nextLine());
//        System.out.println("Change is made! Onto the next task!");
//        returnToMenu();
//    }
//
//    // MODIFIES: this
//    // EFFECTS: sets entry.definition = input.nextLine()
//    private void editDefinition(Entry e) {
//        System.out.println("What would you like to change the definition to?");
//        e.setDefinition(input.nextLine());
//        System.out.println("Change is made! Onto the next task!");
//        returnToMenu();
//    }
//
//    // MODIFIES: this
//    // EFFECTS: sets entry.needPractice = input.nextLine()
//    private void editPracticeStatus(Entry e) {
//        System.out.println("What would you like to change the practice status to?");
//        System.out.println("t for true");
//        System.out.println("f for false");
//        wantToPractice(input.nextLine(), e);
//        System.out.println("Change is made! Onto the next task!");
//        returnToMenu();
//    }
//
//    private void returnToMenu() {
//        displayMenu();
//        String command = "";
//        command = input.nextLine();
//        processCommand(command);
//    }
//
//    private void printWord(Entry e) {
//        String w = e.getWord();
//        String d = e.getDefinition();
//        String l = e.getLanguage();
//        String p = e.getPhonetics();
//        System.out.println("Word is:");
//        System.out.println(w);
//        System.out.println("Definition is:");
//        System.out.println(d);
//        System.out.println("Language is:");
//        System.out.println(l);
//        System.out.println("Phonetics is:");
//        System.out.println(p);
//    }
//
//
//    // EFFECTS: saves the workroom to file
//    private void saveEntryList() {
//        try {
//            jsonWriter.open();
//            jsonWriter.write(entrylist);
//            jsonWriter.close();
//            System.out.println("Saved "  + " to " + JSON_STORE);
//        } catch (FileNotFoundException e) {
//            System.out.println("Unable to write to file: " + JSON_STORE);
//        }
//    }
//
//    // MODIFIES: this
//    // EFFECTS: loads workroom from file
//    private void loadEntryList() {
//        try {
//            entrylist = jsonReader.read();
//            System.out.println("Loaded " + " from " + JSON_STORE);
//        } catch (IOException e) {
//            System.out.println("Unable to read from file: " + JSON_STORE);
//        }
//    }
//}
