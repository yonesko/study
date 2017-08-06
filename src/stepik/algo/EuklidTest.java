package stepik.algo;

import org.junit.Assert;
import org.junit.Test;

public class EuklidTest {
    @Test
    public void gcd() throws Exception {
        long t[][] = {
                {56, 4, 4}
                , {3, 5, 1}
                , {30, 50, 10}
                , {120, 115, 5}
                , {14159572 , 63967072, 4}
                , {14159572 , 8, 4}
        };

        for (long[] d : t)
            Assert.assertEquals(d[0] + " " + d[1], d[2], Euklid.gcd(d[0], d[1]));
    }
}