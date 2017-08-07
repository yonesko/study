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
        List<Line> sortedLines = new ArrayList<>(lines.size());
        sortedLines.addAll(lines);
        sortedLines.sort(Comparator.comparingInt(o -> o.b));

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