package stepik.algo.devideandconquer;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Random;

public class BinarySearchTest {
    @Test
    public void t() {
        Random random = new Random(System.currentTimeMillis());
        int arr[] = new int[(int) 1e5];

        for (int i = 0; i < arr.length; i++) arr[i] = random.nextInt();
        Arrays.sort(arr);

        for (int val = 0; val < arr.length * 2; val++) {
            int expected = Arrays.binarySearch(arr, val);
            Assert.assertEquals(expected < 0 ? -1 : expected, BinarySearch.search(arr, val));
        }
    }

    @Test
    public void t2() {
        Random random = new Random(System.currentTimeMillis());
        int[] ints = random.ints((long) 1e5).sorted().toArray();

        Arrays.stream(ints).forEach(val -> {
            int expected = Arrays.binarySearch(ints, val);
            Assert.assertEquals(expected < 0 ? -1 : expected, BinarySearch.search(ints, val));
        });
    }

    @Test
    public void t3() {
        int[] ints = {4};

        Assert.assertEquals(0, BinarySearch.search(ints, 4));
        Assert.assertEquals(-1, BinarySearch.search(ints, 44));
    }

    @Test
    public void t4() {
        int[] ints = {4, 5};

        Assert.assertEquals(0, BinarySearch.search(ints, 4));
        Assert.assertEquals(1, BinarySearch.search(ints, 5));
        Assert.assertEquals(-1, BinarySearch.search(ints, 6));
        Assert.assertEquals(-1, BinarySearch.search(ints, -1));
    }
}