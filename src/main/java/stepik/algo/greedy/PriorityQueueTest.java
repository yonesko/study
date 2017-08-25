package stepik.algo.greedy;

import org.junit.Assert;
import org.junit.Test;

import java.util.*;

public class PriorityQueueTest {
    @Test
    public void t() {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        Deque<Integer> ints = new LinkedList<>();
        for (int i = 0; i < 1e6; i++) {
            ints.add(i);
            pq.insert(i);
        }

        while (!ints.isEmpty()) {
            Assert.assertEquals(ints.pollLast(), pq.extractMax());
        }

    }

    @Test
    public void t2() {
        Random random = new Random(System.currentTimeMillis());
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        List<Integer> ints = new ArrayList<>();

        java.util.PriorityQueue<Integer> pqExpected = new java.util.PriorityQueue<>(Collections.reverseOrder(Integer::compareTo));

        for (int i = 0; i < 200; i++) {
            int elem = random.nextInt(1000);
            ints.add(elem);
            pq.insert(elem);
            pqExpected.add(elem);
        }

        while (!pqExpected.isEmpty()) {
            Assert.assertEquals(
                    String.format("ints=%s\nexpected=%s\nactual=%s", ints, pqExpected, pq),
                    pqExpected.poll(),
                    pq.extractMax());
        }
    }
}