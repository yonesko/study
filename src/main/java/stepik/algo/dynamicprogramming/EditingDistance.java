package stepik.algo.dynamicprogramming;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class EditingDistance {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println(calc(sc.next(), sc.next()));
    }

    public static int calc(String a, String b) {
        int d[][] = new int[a.length() + 1][b.length() + 1];

        for (int i = 0; i < d.length; i++) d[i][0] = i;
        for (int i = 0; i < d[0].length; i++) d[0][i] = i;


        for (int i = 1; i < d.length; i++) {
            for (int j = 1; j < d[i].length; j++) {
                int c = a.charAt(i - 1) == b.charAt(j - 1) ? 0 : 1;
                d[i][j] = Collections.min(Arrays.asList(d[i - 1][j] + 1, d[i][j - 1] + 1, d[i - 1][j - 1] + c));
            }
        }

        return d[a.length()][b.length()];
    }
}
