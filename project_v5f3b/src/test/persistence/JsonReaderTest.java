//package persistance;
//
//import model.Entry;
//import model.EntryList;
//import org.junit.jupiter.api.Test;
//
//import java.io.FileNotFoundException;
//import java.io.IOException;
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.junit.jupiter.api.Assertions.fail;
//
//// THE CODE WAS BASED OFF OF Json serialization demo!
//class JsonReaderTest extends JsonTest {
//
//    @Test
//    void testReaderNonExistentFile() {
//        JsonReader reader = new JsonReader("./data/noSuchFile.json");
//        try {
//            EntryList el = reader.read();
//            fail("IOException expected");
//        } catch (IOException e) {
//            System.out.println("EXCEPTION SHOULD BE THROWN");;
//        }
//    }
//
//    @Test
//    void testReaderEmptyEntryList() {
//        JsonReader reader = new JsonReader("./data/testReaderEmptyEntryList.json");
//        try {
//            EntryList el = reader.read();
//            assertEquals(0, el.getSize());
//        } catch (IOException e) {
//            fail("Couldn't read from file");
//        }
//    }
//
//    @Test
//    void testReaderGeneralEntryList() {
//        JsonReader reader = new JsonReader("./data/testReaderGeneralEntryList.json");
//        try {
//            EntryList el = reader.read();
//            List<Entry> entries = el.returnAllEntries();
//            assertEquals(entries.size(), 2);
//            checkEntry("hello", "english", entries.get(0));
//            checkEntry("bye", "english", entries.get(1));
//        } catch (IOException e) {
//            fail("SHOULDN'T HAVE THROWN");
//        }
//    }
//}
