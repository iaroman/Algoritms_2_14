package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class IntegerListTest {
    IntegerList integerList;
    @BeforeEach
    void setUp() {
        integerList = new IntegerList(10);
        for (int i = 0; i < 50; i++) {
            integerList.add(i);
        }
    }

    @Test
    void testAdd() {
        int size = integerList.size();
        Integer expected = integerList.add(5);
        Integer actual = integerList.get(size);
        assertEquals(expected, actual);
    }

    @Test
    void testEquals() {
        IntegerList list = new IntegerList(10);
        for (int i = 0; i < 50; i++) {
            list.add(i);
        }
        assertEquals(list, integerList);
        list.add(666);
        assertNotEquals(list, integerList);
    }

    @Test
    void testAddIndex() {
        Integer actualPrev = integerList.get(1);

        Integer expected = integerList.add(1, 111);
        Integer actual = integerList.get(1);
        assertEquals(expected, actual);

        assertEquals(integerList.get(2), actualPrev);
    }

    @Test
    void set() {
        Integer actualPrev = integerList.get(2);

        Integer expected = integerList.set(1, 111);
        Integer actual = integerList.get(1);
        assertEquals(expected, actual);

        assertEquals(integerList.get(2), actualPrev);
    }

    @Test
    void removeByItem() {
        int size = integerList.size();
        Integer actual = integerList.get(size-1);
        Integer expected = integerList.remove(actual);
        assertEquals(actual, expected);
        assertEquals(integerList.size(), size-1);
    }

    @Test
    void removeByIndex() {
        int size = integerList.size();
        Integer actual = integerList.get(size-1);
        Integer expected = integerList.remove(size-1);
        assertEquals(actual, expected);
        assertEquals(integerList.size(), size-1);
    }

    @Test
    void containsTrue() {
        for (int i = 0; i < integerList.size(); i++) {
            assertTrue(integerList.contains(integerList.get(i)));
        }
    }
    @Test
    void containsFalse() {
        for (int i = 0; i < integerList.size(); i++) {
            assertFalse(integerList.contains(integerList.get(i)+100));
        }
    }

    @Test
    void indexOf() {
        for (int i = 0; i < integerList.size(); i++) {
            assertEquals(i, integerList.indexOf(integerList.get(i)));
        }
        assertEquals(-1, integerList.indexOf(-1));
    }

    @Test
    void lastIndexOf() {
        IntegerList list = new IntegerList(5);
        Integer onlyThis = 1;
        for (int i = 0; i < 4; i++) {
            list.add(onlyThis);
        }
        assertEquals(list.size()-1, list.lastIndexOf(onlyThis));

        assertEquals(-1, list.lastIndexOf(0));
    }

    @Test
    void get() {
        Integer expected = integerList.add(9999);
        Integer actual = integerList.get(integerList.size()-1);
        assertEquals(expected, actual);
    }

    @Test
    void size() {
        IntegerList list = new IntegerList(10);
        assertEquals(0, list.size());
        list.add(1);
        assertEquals(1, list.size());
        list.add(2);
        assertEquals(2, list.size());
    }

    @Test
    void isEmpty() {
        IntegerList list = new IntegerList(10);
        assertTrue(list.isEmpty());
        list.add(1);
        assertFalse(list.isEmpty());
        list.remove(0);
        assertTrue(list.isEmpty());
    }

    @Test
    void clear() {
        assertFalse(integerList.isEmpty());
        integerList.clear();
        assertTrue(integerList.isEmpty());
    }

    @Test
    void toArray() {
        IntegerList list = new IntegerList(5);
        Integer [] actual = {1, 2, 3, 4, 5};
        for (Integer arr : actual) {
            list.add(arr);
        }
        Integer [] expected = list.toArray();
        assertArrayEquals(expected, actual);
    }

}