package stepik.algo;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Set<Line> lines = new HashSet<>(sc.nextInt());

        while (sc.hasNext()) lines.add(new Line(sc.nextInt(), sc.nextInt()));

        Set<Integer> points = PointsCover.pointsCover(lines);

        System.out.println(points.size());

        points.forEach(i -> System.out.println());
    }
}
