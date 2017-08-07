package stepik.algo;

public class Euklid {
    static long gcd(long a, long b) {
        long min, max;

        do {
            min = Math.min(a, b);
            max = Math.max(a, b);

            a = max % min;
            b = min;
        } while (a != 0 && b != 0);

        return a + b;
    }
}
