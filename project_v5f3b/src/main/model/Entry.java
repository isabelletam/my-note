package model;

import org.json.JSONObject;
import persistence.Writable;

import java.util.HashMap;
import java.util.Map;

// Class for a single entry. Allows us to manipulate a single entry.
public class Entry extends EntryMap implements Writable {

    //fields:
    public String word;
    public EntryType type;
    public String definition;
    public String language;
    public String phonetics;
    public Boolean needsPractice;
    public EntryMap entrymap;

    //Entry constructor
    public Entry(String word, String lan) {
        this.word = word;
        this.type = EntryType.NONE;
        this.definition = "";
        this.language = lan;
        this.phonetics = "";
        this.needsPractice = false;
        this.entrymap = new EntryMap();
    }

    //getters
    public String getWord() {
        return word;
    }

    public EntryType getType() {
        return type;
    }

    public String getDefinition() {
        return definition;
    }

    public String getLanguage() {
        return language;
    }

    public String getPhonetics() {
        return phonetics;
    }

    // Setters
    public void setDefinition(String def) {
        this.definition = def;
    }

    public void setPhonetics(String ph) {
        this.phonetics = ph;
    }

    public void setType(String type) {
        if (type.equals("NOUN")) {
            this.type = EntryType.NOUN;
        } else if (type.equals("VERB")) {
            this.type = EntryType.VERB;
        } else if (type.equals("ADJECTIVE")) {
            this.type = EntryType.ADJECTIVE;
        } else if (type.equals("ADVERB")) {
            this.type = EntryType.ADVERB;
        } else if (type.equals("PARTICLE")) {
            this.type = EntryType.PARTICLE;
        } else if (type.equals("NONE")) {
            this.type = EntryType.NONE;
        } else {
            this.type = EntryType.MISC;
        }
    }

    public void setLanguage(String lan) {
        this.language = lan;
    }

    public void setWord(String word) {
        this.word = word;
    }

    // MODIFIES: this
    // EFFECTS: set the word to be not needing practice
    public void notNeedPractice() {
        this.needsPractice = false;
    }

    // MODIFIES: this
    // EFFECTS: set the word to be needing practice
    public void needPractice() {
        this.needsPractice = true;
    }

    // EFFECTS: return true if this word needs practice, else return false
    public boolean doesNeedPractice() {
        if (needsPractice) {
            return true;
        }
        return false;
    }

    // Modifies: Entrymap
    // Effects: Maps entry as value to entrytype which is key
    public void assignToMap(String type) {
        if (type.equals("NOUN")) {
            entrymap.put(EntryType.NOUN, this);
        } else if (type.equals("VERB")) {
            entrymap.put(EntryType.VERB, this);
        } else if (type.equals("ADJECTIVE")) {
            entrymap.put(EntryType.ADJECTIVE, this);
        } else if (type.equals("ADVERB")) {
            entrymap.put(EntryType.ADVERB, this);
        } else if (type.equals("PARTICLE")) {
            entrymap.put(EntryType.PARTICLE, this);
        } else if (type.equals("NONE")) {
            entrymap.put(EntryType.NONE, this);
        } else {
            entrymap.put(EntryType.MISC, this);
        }
    }

    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("word", word);
        json.put("language", language);
        json.put("type", type);
        json.put("definition", definition);
        json.put("phonetics", phonetics);
        return json;
    }

}
