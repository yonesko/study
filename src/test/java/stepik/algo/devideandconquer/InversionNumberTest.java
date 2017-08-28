package stepik.algo.devideandconquer;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.Arrays.asList;
import static java.util.Collections.emptyList;
import static java.util.Collections.singletonList;
import static org.junit.Assert.assertEquals;
import static stepik.algo.devideandconquer.InversionNumber.*;

public class InversionNumberTest {
    @Test
    public void invNumber() throws Exception {
        int arr[] = {2, 3, 9, 2, 9};
        assertEquals(2, InversionNumber.count(arr));

        arr = new int[]{12, 56, 23, 8, 4};
        assertEquals(8, InversionNumber.count(arr));

        Random random = new Random();
        for (int i = 0; i < 100 ; i++) {
            arr = random.ints(10, 0, 20).toArray();
            assertEquals(Arrays.toString(arr), InversionNumber.countRobust(arr), count(arr));
        }

    }

    @Test
    public void reversed() throws Exception {
        int nums = 100;
        int arr[] = IntStream.range(0, nums)
                .boxed()
                .sorted(Comparator.reverseOrder())
                .mapToInt(Integer::intValue)
                .toArray();

        assertEquals(nums * (nums - 1) / 2, InversionNumber.count(arr));
    }

    @Test
    public void reversed2() throws Exception {
        int nums = 10;
        int arr[] = IntStream.range(0, nums)
                .boxed()
                .sorted(Comparator.reverseOrder())
                .mapToInt(Integer::intValue)
                .toArray();

        assertEquals(nums * (nums - 1) / 2, InversionNumber.count(arr));
    }

    @Test(timeout = 2000)
    public void many() {
        int arr[] = IntStream.range(0, (int) 1e6)
                .boxed()
                .mapToInt(Integer::intValue)
                .toArray();
        assertEquals(0, InversionNumber.count(arr));
    }

    @Test
    public void ordered() throws Exception {
        int arr[] = IntStream.range(0, 100)
                .boxed()
                .mapToInt(Integer::intValue)
                .toArray();

        assertEquals(0, InversionNumber.count(arr));
    }

    @Test
    public void empty() {
        int arr[] = {};
        assertEquals(0, InversionNumber.count(arr));
    }

    @Test
    public void one() {
        int arr[] = {1};
        assertEquals(0, InversionNumber.count(arr));
    }

    @Test
    public void two() {
        int arr[] = {2, 1};
        assertEquals(1, InversionNumber.count(arr));
    }

    @Test
    public void mergeTest() {
        assertEquals(asList(1, 1), merge(singletonList(1), singletonList(1)));
        assertEquals(singletonList(1), merge(emptyList(), singletonList(1)));
        assertEquals(asList(-34, 1, 2, 99), merge(asList(1, 2), asList(-34, 99)));
        assertEquals(asList(-34, 1, 2, 3, 7, 99),
                merge(
                        merge(asList(1, 2), asList(-34, 99)),
                        asList(3, 7)));
        assertEquals(asList(-34, 1, 2, 3, 7, 99, 101, 102, 103, 104),
                merge(
                        merge(asList(1, 2, 101, 102, 103, 104), asList(-34, 99)),
                        asList(3, 7)));
    }

    @Test
    public void mergeSortTest() {
        assertEquals(asList(1, 2), mergeSort(asList(2, 1)));
        assertEquals(asList(1, 2), mergeSort(asList(1, 2)));
        assertEquals(emptyList(), mergeSort(emptyList()));

        List<Integer> randInts = new Random().ints(1000).boxed().collect(Collectors.toList());
        List<Integer> sortedInts = new ArrayList<>(randInts);
        Collections.sort(sortedInts);

        assertEquals(sortedInts, mergeSort(randInts));
    }
}