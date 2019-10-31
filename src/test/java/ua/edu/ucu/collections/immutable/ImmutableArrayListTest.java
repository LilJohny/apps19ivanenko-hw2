package ua.edu.ucu.collections.immutable;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ImmutableArrayListTest {
    private Object[] simpleArray;
    private Object[] longArray;
    private Object[] insertedArray;
    private Object[] insertedArrayRemoved;

    @Before
    public void setUp() {
        simpleArray = new Object[]{1, 2, 3};
        longArray = new Object[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        insertedArray = new Object[]{1, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 2, 3};
        insertedArrayRemoved = new Object[]{1, 1, 2, 3, 5, 6, 7, 8, 9, 10, 2, 3};
    }

    @Test
    public void testAddAllIndexSimple() {
        ImmutableArrayList array = new ImmutableArrayList();
        ImmutableArrayList result = (ImmutableArrayList) array.addAll(0, simpleArray);
        assertArrayEquals(result.toArray(), simpleArray);
    }

    @Test
    public void testAddAllIndexLong() {
        ImmutableArrayList array = new ImmutableArrayList();
        ImmutableArrayList result = (ImmutableArrayList) array.addAll(0, simpleArray);
        result = (ImmutableArrayList) result.addAll(1, longArray);
        assertArrayEquals(result.toArray(), insertedArray);
    }

    @Test
    public void testAddAllIndexFar() {
        ImmutableArrayList array = new ImmutableArrayList(simpleArray);
        ImmutableArrayList result = (ImmutableArrayList) array.addAll(1, longArray);
        assertArrayEquals(result.toArray(), insertedArray);
    }

    @Test
    public void testRemove() {
        ImmutableArrayList array = new ImmutableArrayList(insertedArray);
        ImmutableArrayList result = (ImmutableArrayList) array.remove(4);
        assertArrayEquals(result.toArray(), insertedArrayRemoved);
    }

}
