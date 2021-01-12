package persistence;

import model.Entry;
import model.EntryList;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

// THE CODE WAS BASED OFF OF Json serialization demo!
public class JsonWriterTest extends JsonTest {

    @Test
    void testWriterInvalidFile() {
        try {
            EntryList el = new EntryList();
            JsonWriter writer = new JsonWriter("./data/my\0illegal:fileName.json");
            writer.open();
            fail("IOException was expected");
        } catch (FileNotFoundException e) {
            System.out.println("EXCEPTION SHOULD BE THROWN");
        }
    }

    @Test
    void testWriterEmptyEntryList() {
        try {
            EntryList el = new EntryList();
            JsonWriter writer = new JsonWriter("./data/testWriterEmptyEntryList.json");
            writer.open();
            writer.write(el);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterEmptyEntryList.json");
            el = reader.read();
            assertEquals(0, el.getSize());
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }

    @Test
    void testWriterGeneralEntryList() {
        try {
            EntryList el = new EntryList();
            el.addEntry(new Entry("hello", "english"));
            el.addEntry(new Entry("bye", "english"));
            JsonWriter writer = new JsonWriter("./data/testWriterGeneralEntryList.json");
            writer.open();
            writer.write(el);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterGeneralEntryList.json");
            el = reader.read();
            List<Entry> entries = el.returnAllEntries();
            assertEquals(el.getSize(), 2);
            checkEntry("hello", "english", entries.get(0));
            checkEntry("bye", "english", entries.get(1));

        } catch (IOException e) {
            fail("Exception should not have been thrown");
        }
    }
}
