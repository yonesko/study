package stepik.algo.greedy;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class BackpackTest {
    @Test
    public void backpack() throws Exception {
        ArrayList<Backpack.Item> items = new ArrayList<>();
        items.add(new Backpack.Item(60, 20));
        items.add(new Backpack.Item(100, 50));
        items.add(new Backpack.Item(100, 50));
        items.add(new Backpack.Item(50, 25));
        items.add(new Backpack.Item(120, 30));
        Assert.assertEquals(180, Backpack.backpack(50, items), 0.001);
    }

    @Test
    public void backpack1() throws Exception {
        ArrayList<Backpack.Item> items = new ArrayList<>();
        Assert.assertEquals(0, Backpack.backpack(50, items), 0.001);
    }

    @Test
    public void backpack2() throws Exception {
        ArrayList<Backpack.Item> items = new ArrayList<>();
        items.add(new Backpack.Item(100, 50));
        Assert.assertEquals(100, Backpack.backpack(50, items), 0.001);
    }

    @Test
    public void backpack3() throws Exception {
        ArrayList<Backpack.Item> items = new ArrayList<>();
        items.add(new Backpack.Item(0, 50));
        Assert.assertEquals(0, Backpack.backpack(50, items), 0.001);
    }

    @Test
    public void backpack4() throws Exception {
        ArrayList<Backpack.Item> items = new ArrayList<>();
        items.add(new Backpack.Item(1, 50));
        Assert.assertEquals(0.02, Backpack.backpack(1, items), 0.001);
    }

    @Test
    public void backpack5() throws Exception {
        ArrayList<Backpack.Item> items = new ArrayList<>();
        items.add(new Backpack.Item(1, 1));
        Assert.assertEquals(0.0, Backpack.backpack(0, items), 0.001);
    }

    @Test
    public void backpack6() throws Exception {
        ArrayList<Backpack.Item> items = new ArrayList<>();
        items.add(new Backpack.Item(121, 9));
        items.add(new Backpack.Item(135, 3));
        Assert.assertEquals(161.888, Backpack.backpack(5, items), 0.001);
    }

    @Test
    public void backpack7() throws Exception {
        ArrayList<Backpack.Item> items = new ArrayList<>();
        items.add(new Backpack.Item(250, 23));
        items.add(new Backpack.Item(120, 11));
        Assert.assertEquals(283.043, Backpack.backpack(26, items), 0.001);
    }
}