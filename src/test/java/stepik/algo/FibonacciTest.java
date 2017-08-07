package stepik.algo;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

public class FibonacciTest {
    @Test
    public void fib() {
        long t[][] = {
                {0, 0}
                , {1, 1}
                , {8, 21}
                , {7, 13}
                , {20, 6765}
                , {92, 7540113804746346429L}
        };

        for (long[] d : t) Assert.assertEquals(String.valueOf(d[0]), d[1], Fibonacci.fib((int) d[0]));

    }

    @Test
    public void lastDigit() {
        for (int n = 0; n < 93; n++) {
            String fibStr = String.valueOf(Fibonacci.fib(n));
            Assert.assertEquals(String.valueOf(n), (int) Integer.valueOf(fibStr.substring(fibStr.length() - 1)), Fibonacci.lastDigit(n));
        }
    }

    @Test
    public void many() {
        for (int n = 0; n < 1e7; n++) {
            Fibonacci.lastDigit(n);
        }
    }
}