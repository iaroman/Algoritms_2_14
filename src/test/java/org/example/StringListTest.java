package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class StringListTest {
    StringList stringListTest;
    @BeforeEach
    void setUp() {
        stringListTest = new StringList(10);
        stringListTest.add("zero");
        stringListTest.add("one");
        stringListTest.add("two");
        stringListTest.add("three");
        stringListTest.add("four");
    }

    @Test
    void testAdd() {
        int size = stringListTest.size();
        String expected = stringListTest.add("five");
        String actual = stringListTest.get(size);
        assertEquals(expected, actual);

        stringListTest.add("6");
        stringListTest.add("7");
        stringListTest.add("8");
        stringListTest.add("9");
        assertThrows(ExceedingSizeException.class,
                () -> stringListTest.add("test"));
    }

    @Test
    void testEquals() {
        StringList stringList = new StringList(10);
        stringList.add("zero");
        stringList.add("one");
        stringList.add("two");
        stringList.add("three");
        stringList.add("four");
        assertEquals(stringList, stringListTest);
        stringList.add("new");
        assertNotEquals(stringList, stringListTest);
    }

    @Test
    void testAddIndex() {
        String actualPrev = stringListTest.get(1);

        String expected = stringListTest.add(1, "its 1");
        String actual = stringListTest.get(1);
        assertEquals(expected, actual);

        assertEquals(stringListTest.get(2), actualPrev);
    }

    @Test
    void set() {
        String actualPrev = stringListTest.get(2);

        String expected = stringListTest.set(1, "its 1");
        String actual = stringListTest.get(1);
        assertEquals(expected, actual);

        assertEquals(stringListTest.get(2), actualPrev);
    }

    @Test
    void removeByString() {
        int size = stringListTest.size();
        String actual = stringListTest.get(size-1);
        String expected = stringListTest.remove(actual);
        assertEquals(actual, expected);
        assertEquals(stringListTest.size(), size-1);
    }

    @Test
    void removeByIndex() {
        int size = stringListTest.size();
        String actual = stringListTest.get(size-1);
        String expected = stringListTest.remove(size-1);
        assertEquals(actual, expected);
        assertEquals(stringListTest.size(), size-1);
    }

    @Test
    void containsTrue() {
        for (int i = 0; i < stringListTest.size(); i++) {
            assertTrue(stringListTest.contains(stringListTest.get(i)));
        }
    }
    @Test
    void containsFalse() {
        for (int i = 0; i < stringListTest.size(); i++) {
            assertFalse(stringListTest.contains(stringListTest.get(i)+" "));
        }
    }

    @Test
    void indexOf() {
        for (int i = 0; i < stringListTest.size(); i++) {
            assertEquals(i, stringListTest.indexOf(stringListTest.get(i)));
        }
        assertEquals(-1, stringListTest.indexOf("dont have"));
    }

    @Test
    void lastIndexOf() {
        StringList stringList = new StringList(5);
        String onlyThis = "only this";
        stringList.add(onlyThis);
        stringList.add(onlyThis);
        stringList.add(onlyThis);
        stringList.add(onlyThis);
        stringList.add(onlyThis);
        assertEquals(stringList.size()-1, stringList.lastIndexOf(onlyThis));

        assertEquals(-1, stringList.lastIndexOf("not This"));
    }

    @Test
    void get() {
        String expected = stringListTest.add("test");
        String actual = stringListTest.get(stringListTest.size()-1);
        assertEquals(expected, actual);
    }

    @Test
    void size() {
        StringList stringList = new StringList(10);
        assertEquals(0, stringList.size());
        stringList.add("1");
        assertEquals(1, stringList.size());
        stringList.add("2");
        assertEquals(2, stringList.size());
    }

    @Test
    void isEmpty() {
        StringList stringList = new StringList(10);
        assertTrue(stringList.isEmpty());
        stringList.add("1");
        assertFalse(stringList.isEmpty());
        stringList.remove("1");
        assertTrue(stringList.isEmpty());
    }

    @Test
    void clear() {
        assertFalse(stringListTest.isEmpty());
        stringListTest.clear();
        assertTrue(stringListTest.isEmpty());
    }

    @Test
    void toArray() {
        StringList stringList = new StringList(5);
        String [] actual = {"1u", "2u", "3u", "4u", "5u"};
        for (String s : actual) {
            stringList.add(s);
        }
        String [] expected = stringList.toArray();
        assertTrue(Arrays.equals(expected, actual));
    }
}