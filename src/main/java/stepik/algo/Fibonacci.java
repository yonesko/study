package stepik.algo;

class Fibonacci {
    static int lastDigit(int n) {
        if (n < 2) return n;
        int n1 = 1, n2 = 0;
        int ret = n1 + n2;

        for (int i = 2; i <= n; i++) {
            ret = (n1 + n2) % 10;
            n2 = n1;
            n1 = ret;
        }
        return ret;
    }

    static long fib(int n) {
        if (n < 2) return n;
        long n1 = 1, n2 = 0;
        long ret = n1 + n2;

        for (int i = 2; i <= n; i++) {
            ret = n1 + n2;
            n2 = n1;
            n1 = ret;
        }
        return ret;
    }
}
