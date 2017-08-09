package stepik.algo.greedy;

import java.util.Collections;
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
        return _summand(n, 1);
    }

    private static Set<Integer> _summand(int n, int d) {
        if (d >= (float) n / 2) return Collections.singleton(n);
        Set<Integer> result = new HashSet<>();

        result.add(d);
        result.addAll(_summand(n - d, d + 1));

        return result;
    }

}
