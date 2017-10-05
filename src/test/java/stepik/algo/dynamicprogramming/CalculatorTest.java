package stepik.algo.dynamicprogramming;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.junit.Assert.assertEquals;

public class CalculatorTest {
    @Test
    public void calc() throws Exception {
        assertEquals(Collections.singletonList(1), Calculator.calc(1));
        assertEquals(Arrays.asList(1, 2, 4, 5), Calculator.calc(5));
        assertEquals(Arrays.asList(1, 3, 9, 10), Calculator.calc(10));
        assertEquals(Arrays.asList(1, 3, 9, 10, 11, 22, 66, 198, 594, 1782, 5346, 16038, 16039, 32078, 96234), Calculator.calc(96234));
    }

}