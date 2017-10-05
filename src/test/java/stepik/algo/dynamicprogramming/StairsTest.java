package stepik.algo.dynamicprogramming;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StairsTest {

    @Test
    public void calc() throws Exception {
        assertEquals(4, Stairs.calc(new int[]{4}));
        assertEquals(7, Stairs.calc(new int[]{1, 6}));
        assertEquals(21, Stairs.calc(new int[]{1, 2, 3, 4, 5, 6}));
        assertEquals(3, Stairs.calc(new int[]{1, -2, 3, -4, 5, -6}));
        assertEquals(3, Stairs.calc(new int[]{-1, 2, 1}));
        assertEquals(9, Stairs.calc(new int[]{-6, 5, -4, 3, -2, 1}));
        assertEquals(-6, Stairs.calc(new int[]{1, -2, -100, -4, 5, -6}));
        assertEquals(-6, Stairs.calc(new int[]{1, -2, 3, -4, -100, -6}));
        assertEquals(-102, Stairs.calc(new int[]{1, -2, 3, -300, -100, -6}));
        assertEquals(-100, Stairs.calc(new int[]{1, -2, 3, -4, -6, -100}));
    }

}