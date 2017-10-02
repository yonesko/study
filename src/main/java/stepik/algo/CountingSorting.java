package stepik.algo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class CountingSorting {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> list = new ArrayList<>(sc.nextInt());

        while (sc.hasNext()) list.add(sc.nextInt());

        sort(list);

        list.forEach(integer -> System.out.print(String.format("%d ", integer)));
    }

    static void sort(List<Integer> list) {
        int stat[] = new int[11];

        for (Integer integer : list) stat[integer]++;

        list.clear();

        for (int i = 0; i < stat.length; i++) list.addAll(Collections.nCopies(stat[i], i));
    }
}
