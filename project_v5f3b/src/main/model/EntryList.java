package model;

import org.json.JSONArray;
import org.json.JSONObject;
import persistence.Writable;

import java.util.ArrayList;
import java.util.List;

// A class that represents a list of Entry. Manages the manipulation of List<Entry>.
public class EntryList implements Writable {

    //fields
    public List<Entry> database;

    public EntryList() {
        database = new ArrayList<>();
    }

    // REQUIRES: entry != null
    // MODIFIES: this
    // EFFECTS: stores the given Entry en into this
    public void addEntry(Entry en) {
        database.add(en);
    }

    // REQUIRES: entry != null
    // MODIFIES: this
    // EFFECTS: removes given Entry en from this
    public void removeEntry(Entry en) {
        database.remove(en);
    }


    // EFFECTS: returns true if this contains Entry en, otherwise false
    public boolean containsEntry(Entry en) {
        for (Entry e : database) {
            if (e == en) {
                return true;
            }
        }
        return false;
    }


    // EFFECTS: returns current size of this
    public int getSize() {
        int count = 0;
        for (Entry e : database) {
            count = ++count;
        }
        return count;
    }

    // REQUIRES: that type is a valid EntryType
    // EFFECTS: returns a List<Entry> from this that is of EntryType type
    public List<Entry> returnAllOfType(EntryType type) {
        List<Entry> returnEntry = new ArrayList<>();

        for (Entry e : database) {
            if (e.getType() == type) {
                returnEntry.add(e); //hmm????
            }
        }
        return returnEntry;
    }


    // EFFECTS: returns a List<Entry> of all Entrys marked as needsPractice
    public List<String> returnAllNeedPractice() {
        List<String> returnEntry = new ArrayList<>();

        Boolean needPrac = true;

        for (Entry e : database) {
            if (e.doesNeedPractice() == needPrac) {
                String w = e.getWord();
                String d = e.getDefinition();
                String l = e.getLanguage();
                String p = e.getPhonetics();

                returnEntry.add(w);
                returnEntry.add(d);
                returnEntry.add(l);
                returnEntry.add(p);

            }
        }
        System.out.println(returnEntry);
        return returnEntry;
    }


    // REQUIRES: entry is in database
    // EFFECTS: Change Entry en needsPractice to needsPrac
    public void changePracticeStatus(Entry en, Boolean needsPrac) {
        if (needsPrac == true) {
            en.needPractice();
        } else {
            en.notNeedPractice();
        }

    }


    public List<Entry> returnAllEntries() { //!!! LIST<ENTRY> should be void
        List<String> myList = new ArrayList<>();
        for (Entry e : database) {
            String w = e.getWord();
            String d = e.getDefinition();
            String l = e.getLanguage();
            String p = e.getPhonetics();

            myList.add(w);
            myList.add(d);
            myList.add(l);
            myList.add(p);

        }
        System.out.println(myList);
        return database; //!!! delete
    }

    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("entries", entriesToJson());
        return json;
    }

    // EFFECTS: returns things in this workroom as a JSON array
    private JSONArray entriesToJson() {
        JSONArray jsonArray = new JSONArray();

        for (Entry e : database) {
            jsonArray.put(e.toJson());
        }

        return jsonArray;
    }

}


