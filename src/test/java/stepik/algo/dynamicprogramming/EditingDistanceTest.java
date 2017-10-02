package stepik.algo.dynamicprogramming;

import org.junit.Assert;
import org.junit.Test;

public class EditingDistanceTest {
    @Test
    public void calc() throws Exception {
        Assert.assertEquals(5, EditingDistance.calc("editing", "distance"));

        Assert.assertEquals(0, EditingDistance.calc("editing", "editing"));

        Assert.assertEquals(0, EditingDistance.calc("ab", "ab"));

        Assert.assertEquals(0, EditingDistance.calc("", ""));

        Assert.assertEquals(3, EditingDistance.calc("short", "ports"));
    }

}