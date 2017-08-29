package stepik.algo.devideandconquer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class PointsCover {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int linesNum = sc.nextInt();
        int pointNum = sc.nextInt();
        List<PointsCover.Line> lines = new ArrayList<>(linesNum);
        List<Integer> points = new ArrayList<>(pointNum);

        for (int i = 0; i < linesNum; i++) lines.add(new Line(sc.nextInt(), sc.nextInt()));

        for (int i = 0; i < pointNum; i++) points.add(sc.nextInt());

        cover(lines, points).forEach(v -> System.out.print(String.format("%d ", v)));
    }

    static List<Integer> cover(List<PointsCover.Line> lines, List<Integer> points) {
        List<Integer> ret = new ArrayList<>(points.size());
        HashMap<Integer, Integer> stat = new HashMap<>();
//        System.out.println(String.format("a %s", Instant.now()));

        lines.parallelStream().forEach(line -> {
            for (int i = line.getStart(); i <= line.getEnd(); i++)
                stat.compute(i, (point, cover) -> cover == null ? 1 : cover + 1);
        });

//        System.out.println(String.format("b %s", Instant.now()));
        for (Integer point : points) ret.add(stat.getOrDefault(point, 0));
//        System.out.println(String.format("c %s", Instant.now()));
        return ret;
    }

    static class Line {
        final int start, end;

        public int getStart() {
            return start;
        }

        public int getEnd() {
            return end;
        }

        public Line(int start, int end) {
            this.start = Math.min(start, end);
            this.end = Math.max(start, end);
        }

        @Override
        public String toString() {
            return "Line{" +
                    "start=" + start +
                    ", end=" + end +
                    '}';
        }
    }
}
