package stepik.algo.greedy;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

public class SummandTest {
    @Test
    public void summand() throws Exception {
        Map<Integer, Set<Integer>> inputs = new HashMap<>();
        inputs.put(1, new HashSet<>(Collections.singletonList(1)));
        inputs.put(2, new HashSet<>(Collections.singletonList(2)));
        inputs.put(3, new HashSet<>(Arrays.asList(1, 2)));
        inputs.put(4, new HashSet<>(Arrays.asList(1, 3)));
        inputs.put(5, new HashSet<>(Arrays.asList(1, 4)));
        inputs.put(6, new HashSet<>(Arrays.asList(1, 2, 3)));
        inputs.put(7, new HashSet<>(Arrays.asList(1, 2, 4)));

        inputs.forEach((n, expected) -> Assert.assertEquals(String.valueOf(n), expected, Summand.summand(n)));
    }

    @Test(timeout = 5000)
    public void big() {
        Summand.summand((int) 1e9);
    }

}