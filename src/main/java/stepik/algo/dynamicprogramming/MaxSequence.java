package stepik.algo.dynamicprogramming;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class MaxSequence {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<Integer> input = new ArrayList<>(sc.nextInt());

        while (sc.hasNext()) input.add(sc.nextInt());

        System.out.println(find(input));
    }

    static int find(List<Integer> list) {
        List<Integer> leftDividers = new ArrayList<>(Collections.nCopies(list.size(), 1));

        for (int i = 1; i < list.size(); i++) {
            for (int j = 0; j < i; j++) {
                if (list.get(j) != 0 && list.get(i) % list.get(j) == 0 && leftDividers.get(j) + 1 > leftDividers.get(i)) {
                    leftDividers.set(i, leftDividers.get(j) + 1);
                }
            }
        }

        return Collections.max(leftDividers);
    }
}
