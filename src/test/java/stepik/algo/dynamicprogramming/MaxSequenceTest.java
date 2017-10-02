package stepik.algo.dynamicprogramming;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class MaxSequenceTest {
    private static final Random R = new Random();

    @Test
    public void find() throws Exception {
        Assert.assertEquals(3, MaxSequence.find(Arrays.asList(3, 6, 7, 12)));

        Assert.assertEquals(1, MaxSequence.find(Arrays.asList(31, 22, 3, 5)));

        Assert.assertEquals(1, MaxSequence.find(Arrays.asList(0, 0, 0, 0)));

        Assert.assertEquals(3, MaxSequence.find(Arrays.asList(-3, -6, -7, -12)));

        Assert.assertEquals(3, MaxSequence.find(Arrays.asList(-3, 6, -7, -12)));

        Assert.assertEquals(2, MaxSequence.find(Arrays.asList(-3, 0, -7, -12)));
    }

    @Test(timeout = 2000)
    public void many() {
        List<Integer> input = R.ints(1000, 1, (int) 2e9)
                .boxed().collect(Collectors.toList());

        MaxSequence.find(input);
    }

}