package stepik.algo;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class CountingSortingTest {
    private final static Random R = new Random();

    @Test
    public void sort() throws Exception {
        ArrayList<Integer> list = new ArrayList<>();
        CountingSorting.sort(list);

        Assert.assertEquals(Collections.emptyList(), list);
    }

    @Test
    public void rand() throws Exception {
        List<Integer> list = R.ints(10_000, 0, 11).boxed().collect(Collectors.toList());
        List<Integer> expected = new ArrayList<>(list).stream().sorted().collect(Collectors.toList());

        CountingSorting.sort(list);

        Assert.assertEquals(expected, list);
    }

    @Test(timeout = 2000)
    public void many() {
        List<Integer> list = R.ints(10_000, 0, 11).boxed().collect(Collectors.toList());
        CountingSorting.sort(list);
    }

}