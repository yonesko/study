package stepik.algo;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

public class GreedyAlgorithmsTest {
    @Test
    public void bound() throws Exception {
        Set<Line> inputLines = new HashSet<>();

        Set<Integer> points = GreedyAlgorithms.pointsCover(inputLines);

        Set<Integer> expectedPoints = new HashSet<>();

        Assert.assertEquals(expectedPoints, points);
    }

    @Test
    public void pointsCover1() throws Exception {
        Set<Line> inputLines = new HashSet<>();
        inputLines.add(new Line(1, 3));
        inputLines.add(new Line(2, 5));
        inputLines.add(new Line(3, 6));

        Set<Integer> points = GreedyAlgorithms.pointsCover(inputLines);

        Set<Integer> expectedPoints = new HashSet<>(Collections.singletonList(3));

        Assert.assertEquals(expectedPoints, points);
    }

    @Test
    public void pointsCover2() throws Exception {
        Set<Line> inputLines = new HashSet<>();
        inputLines.add(new Line(2, 5));
        inputLines.add(new Line(1, 3));
        inputLines.add(new Line(4, 7));
        inputLines.add(new Line(5, 7));
        inputLines.add(new Line(4, 7));
        inputLines.add(new Line(5, 6));

        Set<Integer> points = GreedyAlgorithms.pointsCover(inputLines);

        Set<Integer> expectedPoints = new HashSet<>(Arrays.asList(3, 6));

        Assert.assertEquals(expectedPoints, points);
    }

    @Test
    public void pointsCover4() throws Exception {
        Set<Line> inputLines = new HashSet<>();
        inputLines.add(new Line(52, 52));
        inputLines.add(new Line(36, 36));
        inputLines.add(new Line(4, 4));
        inputLines.add(new Line(8, 8));
        inputLines.add(new Line(44, 44));
        inputLines.add(new Line(28, 28));
        inputLines.add(new Line(60, 61));
        inputLines.add(new Line(44, 45));
        inputLines.add(new Line(32, 33));
        inputLines.add(new Line(64, 65));
        inputLines.add(new Line(0, 1));
        inputLines.add(new Line(92, 93));
        inputLines.add(new Line(84, 85));
        inputLines.add(new Line(52, 53));
        inputLines.add(new Line(48, 49));
        inputLines.add(new Line(80, 82));
        inputLines.add(new Line(36, 38));
        inputLines.add(new Line(68, 70));
        inputLines.add(new Line(12, 14));
        inputLines.add(new Line(40, 42));
        inputLines.add(new Line(52, 54));
        inputLines.add(new Line(1, 1));
        inputLines.add(new Line(93, 93));
        inputLines.add(new Line(29, 29));
        inputLines.add(new Line(41, 41));
        inputLines.add(new Line(81, 81));
        inputLines.add(new Line(5, 5));
        inputLines.add(new Line(9, 9));
        inputLines.add(new Line(41, 42));
        inputLines.add(new Line(81, 82));
        inputLines.add(new Line(33, 34));
        inputLines.add(new Line(73, 74));
        inputLines.add(new Line(49, 50));
        inputLines.add(new Line(1, 2));
        inputLines.add(new Line(57, 58));
        inputLines.add(new Line(17, 18));
        inputLines.add(new Line(45, 46));
        inputLines.add(new Line(57, 59));
        inputLines.add(new Line(69, 71));
        inputLines.add(new Line(89, 91));
        inputLines.add(new Line(1, 3));
        inputLines.add(new Line(65, 67));
        inputLines.add(new Line(29, 31));
        inputLines.add(new Line(17, 19));
        inputLines.add(new Line(49, 51));
        inputLines.add(new Line(25, 27));
        inputLines.add(new Line(34, 34));
        inputLines.add(new Line(30, 30));
        inputLines.add(new Line(58, 58));
        inputLines.add(new Line(74, 74));
        inputLines.add(new Line(62, 62));
        inputLines.add(new Line(10, 10));
        inputLines.add(new Line(78, 78));
        inputLines.add(new Line(26, 26));
        inputLines.add(new Line(54, 54));
        inputLines.add(new Line(78, 79));
        inputLines.add(new Line(22, 23));
        inputLines.add(new Line(66, 67));
        inputLines.add(new Line(86, 87));
        inputLines.add(new Line(94, 95));
        inputLines.add(new Line(58, 59));
        inputLines.add(new Line(38, 40));
        inputLines.add(new Line(14, 16));
        inputLines.add(new Line(10, 12));
        inputLines.add(new Line(70, 72));
        inputLines.add(new Line(66, 68));
        inputLines.add(new Line(26, 28));
        inputLines.add(new Line(22, 24));
        inputLines.add(new Line(54, 56));
        inputLines.add(new Line(2, 4));
        inputLines.add(new Line(82, 84));
        inputLines.add(new Line(63, 63));
        inputLines.add(new Line(35, 35));
        inputLines.add(new Line(23, 23));
        inputLines.add(new Line(15, 15));
        inputLines.add(new Line(79, 79));
        inputLines.add(new Line(31, 32));
        inputLines.add(new Line(87, 88));
        inputLines.add(new Line(55, 56));
        inputLines.add(new Line(83, 84));
        inputLines.add(new Line(3, 4));
        inputLines.add(new Line(35, 36));
        inputLines.add(new Line(7, 8));
        inputLines.add(new Line(63, 64));
        inputLines.add(new Line(51, 53));
        inputLines.add(new Line(75, 77));
        inputLines.add(new Line(39, 41));
        inputLines.add(new Line(91, 93));
        inputLines.add(new Line(79, 81));

        Set<Integer> points = GreedyAlgorithms.pointsCover(inputLines);

        Assert.assertTrue(checkEachLineCovered(inputLines, points));
    }

    @Test
    public void pointsCover3() throws Exception {
        Set<Line> lines = new HashSet<>();
        lines.add(new Line(1, 2));
        lines.add(new Line(3, 4));
        lines.add(new Line(4, 4));
        lines.add(new Line(0, 5));

        Set<Integer> points = GreedyAlgorithms.pointsCover(lines);

        Set<Integer> expectedPoints = new HashSet<>(Arrays.asList(2, 4));

        Assert.assertEquals(expectedPoints, points);
    }

    @Test
    public void rand() {
        final int N = 100;
        Random random = new Random(System.currentTimeMillis());
        Set<Line> lines = new HashSet<>();

        Set<Integer> expectedPoints = new HashSet<>(N);

        for (int i = 0; i < N; i++) {
            int point = random.nextInt((int) 1e9);
            expectedPoints.add(point);
            lines.add(new Line(random.nextInt(point), point));
        }

        Set<Integer> points = GreedyAlgorithms.pointsCover(lines);
        Assert.assertTrue(expectedPoints.containsAll(points));
    }

    @Test
    public void rand2() {
        final int N = 1000;
        Random random = new Random(System.currentTimeMillis());
        Set<Line> inputLines = new HashSet<>();

        for (int i = 0; i < N; i++) {
            int point = random.nextInt((int) 1e9);
            inputLines.add(new Line(random.nextInt(point), point));
        }

        Set<Integer> points = GreedyAlgorithms.pointsCover(inputLines);

        checkEachLineCovered(inputLines, points);
    }

    private boolean checkEachLineCovered(Set<Line> lines, Set<Integer> points) {
        for (Line line : lines) {
            boolean covered = false;
            for (Integer point : points) {
                if (point >= line.a && point <= line.b) {
                    covered = true;
                    break;
                }
            }
            if (!covered) return false;
        }
        return true;
    }

    private void visualize(Set<Line> lines) {
        for (Line line : lines) {
            for (int i = 0; i < line.a; i++) System.out.printf("_");
            System.out.printf("[");
            for (int i = 0; i < line.b - line.a; i++) System.out.printf("_");
            System.out.println("]");
        }
    }

}