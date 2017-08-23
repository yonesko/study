package stepik.algo.greedy;

import org.junit.Assert;
import org.junit.Test;

public class HuffmanTest {
    @Test
    public void codeHuffman() {
        String inputToExpected[][] = {
                {"abacabad", "01001100100111"}
                ,{"aaaaaaaaaaaaaaaaa", "00000000000000000"}
                ,{"a", "0"}
                ,{"ab", "01"}
        };

        for (String[] tcase : inputToExpected) {
            Assert.assertEquals(tcase[1], Huffman.encode(tcase[0]));
        }
    }

}