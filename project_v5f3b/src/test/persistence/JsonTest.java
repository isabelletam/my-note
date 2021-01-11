package persistence;

import model.Entry;
import model.EntryList;

import static org.junit.jupiter.api.Assertions.assertEquals;

// THE CODE WAS BASED OFF OF Json serialization demo!
public class JsonTest {
    protected void checkEntry(String word, String lan, Entry entry) {
        assertEquals(word, entry.getWord());
        assertEquals(lan, entry.getLanguage());
    }
}
