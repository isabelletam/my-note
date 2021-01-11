package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

// Testing methods in Entry and EntryList
public class EntryTest {

    private EntryList myEntryList;

    @BeforeEach
    void setup() {
        myEntryList = new EntryList();
    }

    @Test
        //getters
    void testGetters() {
        Entry myEntry = new Entry("House", "English");
        myEntry.setType("NOUN");
        myEntry.setWord("Living");
        assertEquals("Living", myEntry.getWord());
        assertEquals(EntryType.NOUN, myEntry.getType());
        assertEquals("English", myEntry.getLanguage());

        myEntry.setDefinition("A place to live");
        assertEquals("A place to live", myEntry.getDefinition());

        myEntry.setPhonetics("hous");
        assertEquals("hous", myEntry.getPhonetics());

        myEntry.needPractice();
        assertEquals(true, myEntry.doesNeedPractice());
    }

    @Test
        //setters
    void testSetters() {
        Entry myEntry = new Entry("食べる", "English");

        myEntry.setWord("こんにちは");
        assertEquals("こんにちは", myEntry.getWord());

        myEntry.setType("VERB");
        assertEquals(EntryType.VERB, myEntry.getType());

        myEntry.setType("NONE");
        assertEquals(EntryType.NONE, myEntry.getType());

        myEntry.setType("lol");
        assertEquals(EntryType.MISC, myEntry.getType());

        myEntry.setDefinition("hello");
        assertEquals("hello", myEntry.getDefinition());

        myEntry.setLanguage("Japanese");
        assertEquals("Japanese", myEntry.getLanguage());

        myEntry.setPhonetics("konnichiwa");
        assertEquals("konnichiwa", myEntry.getPhonetics());

        myEntry.needPractice();
        assertEquals(true, myEntry.doesNeedPractice());

    }

    @Test
    void testAddEntry() {
        Entry myEntry = new Entry("House", "English");
        myEntryList.addEntry(myEntry);
        assertTrue(myEntryList.containsEntry(myEntry));
        Entry entryTwo = new Entry("LOL", "English");
        myEntryList.addEntry(entryTwo);
        assertEquals(2, myEntryList.getSize());
        Entry entryThree = new Entry("LMAO", "English");
        entryThree.setType("none");
        myEntryList.addEntry(entryThree);
        assertEquals(3, myEntryList.getSize());
    }

    @Test
    void testRemoveEntry() {
        Entry myEntry = new Entry("House", "English");
        Entry entryOne = new Entry("Pig", "English");
        myEntryList.addEntry(myEntry);
        myEntryList.addEntry(entryOne);
        myEntryList.removeEntry(myEntry);
        assertEquals(myEntryList.getSize(), 1);
        assertFalse(myEntryList.containsEntry(myEntry));
        assertTrue(myEntryList.containsEntry(entryOne));
    }

    @Test
    void testContainsEntry() {
        Entry myEntry = new Entry("Red", "English");
        myEntryList.addEntry(myEntry);
        assertTrue(myEntryList.containsEntry(myEntry));
        myEntryList.removeEntry(myEntry);
        assertEquals(myEntryList.getSize(), 0);
    }

    @Test
    void testReturnAllOfType() {
        Entry entryOne = new Entry("Cold", "English");
        entryOne.setType("ADJECTIVE");
        Entry entryTwo = new Entry("Hot", "English");
        entryTwo.setType("ADJECTIVE");
        Entry entryThree = new Entry("Bear", "English");
        entryThree.setType("NOUN");
        Entry entryFour = new Entry("Running", "English");
        entryFour.setType("VERB");
        Entry entryFive = new Entry("very", "English");
        entryFive.setType("ADVERB");
        Entry entrySix = new Entry("to", "English");
        entrySix.setType("PARTICLE");


        myEntryList.addEntry(entryOne);
        myEntryList.addEntry(entryTwo);
        myEntryList.addEntry(entryThree);
        myEntryList.addEntry(entryFour);
        myEntryList.addEntry(entryFive);
        myEntryList.addEntry(entrySix);

        List<Entry> adjectiveList = new ArrayList<>();
        adjectiveList.add(entryOne);
        adjectiveList.add(entryTwo);

        assertEquals(adjectiveList, myEntryList.returnAllOfType(EntryType.ADJECTIVE));

        List<Entry> nounList = new ArrayList<>();
        nounList.add(entryThree);

        assertEquals(nounList, myEntryList.returnAllOfType(EntryType.NOUN));

        List<Entry> verbList = new ArrayList<>();
        verbList.add(entryFour);

        assertEquals(verbList, myEntryList.returnAllOfType(EntryType.VERB));

        List<Entry> adverbList = new ArrayList<>();
        adverbList.add(entryFive);

        assertEquals(adverbList, myEntryList.returnAllOfType(EntryType.ADVERB));

        List<Entry> particleList = new ArrayList<>();
        particleList.add(entrySix);

        assertEquals(particleList, myEntryList.returnAllOfType(EntryType.PARTICLE));
    }

    @Test
    void testReturnAllNeedPractice() {
        Entry entryOne = new Entry("Bunny", "English");
        Entry entryTwo = new Entry("Bear", "English");
        Entry entryThree = new Entry("Shark", "English");

        List<String> myList = new ArrayList<>();

        assertEquals(myList, myEntryList.returnAllNeedPractice());

        myEntryList.addEntry(entryOne);
        myEntryList.addEntry(entryTwo);
        myEntryList.addEntry(entryThree);

        entryOne.needPractice();
        entryThree.needPractice();

        List<String> needsPrac = new ArrayList<>();
        needsPrac.add(entryOne.getWord());
        needsPrac.add(entryOne.getDefinition());
        needsPrac.add(entryOne.getLanguage());
        needsPrac.add(entryOne.getPhonetics());
        needsPrac.add(entryThree.getWord());
        needsPrac.add(entryThree.getDefinition());
        needsPrac.add(entryThree.getLanguage());
        needsPrac.add(entryThree.getPhonetics());

        assertEquals(needsPrac, myEntryList.returnAllNeedPractice());
    }

    @Test
    void testGetSize() {
        Entry entryOne = new Entry("Bunny", "English");
        Entry entryTwo = new Entry("Mochi", "English");

        myEntryList.addEntry(entryOne);
        myEntryList.addEntry(entryTwo);

        assertEquals(2, myEntryList.getSize());

        EntryList entryListTwo = new EntryList();

        assertEquals(entryListTwo.getSize(), 0);

    }

    @Test
    void testPracticeStatus() {
        Entry entryOne = new Entry("Bear", "English");
        entryOne.notNeedPractice();
        assertFalse(entryOne.needsPractice);

        entryOne.needPractice();
        assertTrue(entryOne.needsPractice);

        assertTrue(entryOne.doesNeedPractice());
    }

    @Test
    void testChangePracticeStatusNoChange() {
        Entry entryOne = new Entry("Bunny", "English");
        myEntryList.addEntry(entryOne);

        myEntryList.changePracticeStatus(entryOne, false);

        assertFalse(entryOne.needsPractice);
    }

    @Test
    void testChangePracticeStatusChange() {
        Entry entryOne = new Entry("Bunny", "English");
        myEntryList.addEntry(entryOne);

        myEntryList.changePracticeStatus(entryOne, true);

        assertTrue(entryOne.needsPractice);
    }

    @Test
    void testDatabaseNotContainChangePracticeStatus() {
        Entry entryOne = new Entry("Penguin", "Japanese");
        myEntryList.addEntry(entryOne);

        Entry entryTwo = new Entry("Lion", "English");

        myEntryList.changePracticeStatus(entryOne, true);
        myEntryList.changePracticeStatus(entryTwo, false);

        assertTrue(entryOne.needsPractice);
        assertFalse(entryTwo.needsPractice);
    }

    @Test
    void testAssignToEntryMap() {
        Entry entryOne = new Entry("Penguin", "Japanese");
        Entry entryTwo = new Entry("Lion", "English");

        EntryMap entryMap = new EntryMap();

        entryMap.put(EntryType.NOUN, entryOne);
        entryMap.put(EntryType.VERB, entryTwo);

        assertFalse(entryMap.containsKey(entryOne));
        assertTrue(entryMap.containsKey(EntryType.NOUN));

        entryMap.put(EntryType.ADJECTIVE, entryOne);
        entryMap.put(EntryType.ADVERB, entryOne);
        entryMap.put(EntryType.PARTICLE, entryOne);
        entryMap.put(EntryType.NONE, entryOne);
        entryMap.put(EntryType.MISC, entryOne);

        assertEquals(entryMap.size(), 7);
        assertFalse(entryMap.isEmpty());
        assertEquals(entryOne, entryMap.get(EntryType.NOUN));

        entryMap.clear();

        assertEquals(entryMap.size(), 0);

        entryMap.put(EntryType.NOUN, entryOne);

        entryMap.remove(EntryType.NOUN, entryOne);
        assertFalse(entryMap.containsValue(entryOne));

        entryMap.put(EntryType.NOUN, entryOne);
        entryMap.putAll(entryMap);
        entryMap.values();
        entryMap.entrySet();
        entryMap.keySet();

        entryMap.clear();

        entryOne.assignToMap("NOUN");
        entryOne.assignToMap("VERB");
        entryOne.assignToMap("ADJECTIVE");
        entryOne.assignToMap("ADVERB");
        entryOne.assignToMap("PARTICLE");
        entryOne.assignToMap("NONE");
        entryOne.assignToMap("MISC");



    }

}
