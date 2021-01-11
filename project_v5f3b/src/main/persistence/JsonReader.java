package persistence;

import model.Entry;
import model.EntryList;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

import org.json.*;

// THE CODE WAS BASED OFF OF Json serialization demo!
// Represents a reader that reads workroom from JSON data stored in file
public class JsonReader {

//    private String name;
    private String source;

    // EFFECTS: constructs reader to read from source file
    public JsonReader(String source) {
        this.source = source;
    }

    // EFFECTS: reads workroom from file and returns it;
    // throws IOException if an error occurs reading data from file
    public EntryList read() throws IOException {
        String jsonData = readFile(source);
        JSONObject jsonObject = new JSONObject(jsonData);
        return parseEntryList(jsonObject);
    }

    // EFFECTS: reads source file as string and returns it
    private String readFile(String source) throws IOException {
        StringBuilder contentBuilder = new StringBuilder();

        try (Stream<String> stream = Files.lines(Paths.get(source), StandardCharsets.UTF_8)) {
            stream.forEach(s -> contentBuilder.append(s));
        }

        return contentBuilder.toString();
    }

    // EFFECTS: parses workroom from JSON object and returns it
    private EntryList parseEntryList(JSONObject jsonObject) {
//        String name = jsonObject.getString("word"); //!!!! DELETE
        EntryList el = new EntryList();
        addEntries(el, jsonObject);
        return el;
    }

    // MODIFIES: el
    // EFFECTS: parses entries from JSON object and adds them to workroom
    private void addEntries(EntryList el, JSONObject jsonObject) {
        JSONArray jsonArray = jsonObject.getJSONArray("entries");
        for (Object json : jsonArray) {
            JSONObject nextEntry = (JSONObject) json;
            addEntry(el, nextEntry);
        }
    }

    // MODIFIES: wr
    // EFFECTS: parses thingy from JSON object and adds it to workroom
    private void addEntry(EntryList el, JSONObject jsonObject) {
        String name = jsonObject.getString("word");
        String lan = jsonObject.getString("language");
        String type = jsonObject.getString("type");
        System.out.println(type);
        String def = jsonObject.getString("definition");
        String phon = jsonObject.getString("phonetics");
//        Boolean prac = jsonObject.getBoolean("needsPractice");
        Entry entry = new Entry(name,lan);
        entry.setType(type);
        entry.setDefinition(def);
        entry.setPhonetics(phon);

        el.addEntry(entry);
    }
}

