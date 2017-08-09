package stepik.algo.greedy;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

class Summand {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Set<Integer> summand = summand(sc.nextInt());
        System.out.println(summand.size());
        summand.forEach(System.out::println);
    }

    static Set<Integer> summand(int n) {
        Set<Integer> result = new HashSet<>();

        for (int d = 1; ; n = n - d, d++) {
            if (d >= (float) n / 2) {
                result.add(n);
                break;
            }
            result.add(d);
        }

        return result;
    }
}
