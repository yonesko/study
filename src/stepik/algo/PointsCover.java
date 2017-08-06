package stepik.algo;

import java.util.*;

class PointsCover {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Set<Line> lines = new HashSet<>(sc.nextInt());

        while (sc.hasNext()) lines.add(new Line(sc.nextInt(), sc.nextInt()));

        Set<Integer> points = PointsCover.pointsCover(lines);

        System.out.println(points.size());

        points.forEach(System.out::println);
    }


    static Set<Integer> pointsCover(Set<Line> lines) {
        Set<Integer> ret = new HashSet<>();
        SortedSet<Line> sortedLines = new TreeSet<>(new LineComparator());
        sortedLines.addAll(lines);

        int lastPoint = -1;
        for (Line line : sortedLines) {
            if (line.a > lastPoint) {
                lastPoint = line.b;
                ret.add(lastPoint);
            }
        }

        return ret;
    }
}

class Line {
    final int a, b;

    public Line(int a, int b) {
        this.a = Math.min(a, b);
        this.b = Math.max(a, b);
    }


    @Override
    public String toString() {
        return "Line{" +
                "a=" + a +
                ", b=" + b +
                '}';
    }
}

class LineComparator implements Comparator<Line> {
    @Override
    public int compare(Line o1, Line o2) {
        return o1.b - o2.b == 0 ? o1.a - o2.a : o1.b - o2.b;
    }
}