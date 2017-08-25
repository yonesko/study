package stepik.algo.devideandconquer;

import org.junit.Assert;
import org.junit.Test;

import java.util.Comparator;
import java.util.stream.IntStream;

public class InversionNumberTest {
    @Test
    public void reversed() throws Exception {
        int nums = 100;
        int arr[] = IntStream.range(0, nums)
                .boxed()
                .sorted(Comparator.reverseOrder())
                .mapToInt(Integer::intValue)
                .toArray();

        Assert.assertEquals(nums * (nums - 1) / 2, InversionNumber.count(arr));
    }

    @Test
    public void ordered() throws Exception {
        int arr[] = IntStream.range(0, 100)
                .boxed()
                .mapToInt(Integer::intValue)
                .toArray();

        Assert.assertEquals(0, InversionNumber.count(arr));
    }

    @Test
    public void empty() {
        int arr[] = {};
        Assert.assertEquals(0, InversionNumber.count(arr));
    }

    @Test
    public void one() {
        int arr[] = {1};
        Assert.assertEquals(0, InversionNumber.count(arr));
    }

    @Test
    public void two() {
        int arr[] = {2, 1};
        Assert.assertEquals(1, InversionNumber.count(arr));
    }
}