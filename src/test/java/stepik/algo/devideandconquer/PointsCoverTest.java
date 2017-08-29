package stepik.algo.devideandconquer;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PointsCoverTest {
    private final static Random R = new Random();
    public static final int BOUND = (int) 1e8;

    @Test
    public void cover1() throws Exception {
        List<PointsCover.Line> lines = Arrays.asList(
                new PointsCover.Line(0, 5),
                new PointsCover.Line(7, 7),
                new PointsCover.Line(-100, -3),
                new PointsCover.Line(7, 10));

        List<Integer> points = Arrays.asList(1, 6, 11, 7, -34);

        Assert.assertEquals(Arrays.asList(1, 0, 0, 2, 1), PointsCover.cover(lines, points));
    }

    @Test
    public void coverBound() throws Exception {
        List<PointsCover.Line> lines = Arrays.asList(
                new PointsCover.Line(0, 5),
                new PointsCover.Line(7, 10));

        List<Integer> points = Collections.emptyList();
        Assert.assertEquals(Collections.emptyList(), PointsCover.cover(lines, points));

        lines = Collections.emptyList();
        Assert.assertEquals(Collections.emptyList(), PointsCover.cover(lines, points));
    }

    @Test
    public void many() throws Exception {
        final int N = 5_000;
        List<PointsCover.Line> lines = Stream.generate(PointsCoverTest::randLine).limit(N).collect(Collectors.toList());
        List<Integer> points = R.ints(N, 0, BOUND).boxed().collect(Collectors.toList());

        Assert.assertEquals(Collections.emptyList(), PointsCover.cover(lines, points));
    }

    static private PointsCover.Line randLine() {
        int a = R.nextInt(BOUND);
        int b = R.nextInt(BOUND);
        return new PointsCover.Line(Math.min(a, b), Math.max(a, b));
    }
}