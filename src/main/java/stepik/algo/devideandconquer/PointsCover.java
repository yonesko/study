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
        HashMap<Integer, Integer> stat = new HashMap<>(points.size());

        List<Point> all = new ArrayList<>(points.size());

        for (Line line : lines) {
            all.add(new Point(Point.Type.START, line.start));
            all.add(new Point(Point.Type.END, line.end));
        }

        for (Integer point : points) all.add(new Point(Point.Type.DOT, point));

        all.sort((p1, p2) -> {
            int c = Integer.compare(p1.coord, p2.coord);

            if (c == 0 && p1.type != p2.type) {
                if (p1.type == Point.Type.START) return -1;
                if (p2.type == Point.Type.START) return 1;

                if (p1.type == Point.Type.END) return 1;
                if (p2.type == Point.Type.END) return -1;
            }

            return c;
        });

        int cover = 0;
        for (Point point : all) {
            switch (point.type) {
                case START:
                    cover++;
                    break;
                case END:
                    cover--;
                    break;
                case DOT:
                    stat.put(point.coord, cover);
                    break;
            }
        }

        for (Integer point : points) ret.add(stat.get(point));

        return ret;
    }

    static class Point {
        final Type type;
        final int coord;

        public Point(Type type, int coord) {
            this.type = type;
            this.coord = coord;
        }

        enum Type {START, END, DOT}

        @Override
        public String toString() {
            return "Point{" +
                    "type=" + type +
                    ", coord=" + coord +
                    '}';
        }
    }

    static class Line {
        final int start, end;

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
