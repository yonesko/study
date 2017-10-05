package stepik.algo.dynamicprogramming;

import java.util.*;
import java.util.stream.Collectors;

class Calculator {
    public static void main(String[] args) {
        List<Integer> ans = calc(new Scanner(System.in).nextInt());
        System.out.println(ans.size() - 1);

        System.out.println(ans.stream().map(Object::toString).collect(Collectors.joining(" ")));
    }

    public static List<Integer> calc(int n) {
        List<Integer> ret = new ArrayList<>();

        int d[] = new int[n];
        Arrays.fill(d, Integer.MAX_VALUE);
        d[0] = 0;

        for (int i = 2; i <= n; i++) {
            if (i % 3 == 0) d[i - 1] = d[i / 3 - 1] + 1;
            if (i % 2 == 0) d[i - 1] = Math.min(d[i / 2 - 1] + 1, d[i - 1]);
            d[i - 1] = Math.min(d[i - 1 - 1] + 1, d[i - 1]);
        }

        ret.add(n);
        while (n != 1) {
            if (n % 3 == 0 && d[n / 3 - 1] == d[n - 1] - 1) n /= 3;
            else if (n % 2 == 0 && d[n / 2 - 1] == d[n - 1] - 1) n /= 2;
            else if (d[n - 1 - 1] == d[n - 1] - 1) n--;
            ret.add(n);
        }

        Collections.reverse(ret);
        return ret;
    }
}
