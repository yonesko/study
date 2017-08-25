package stepik.algo.greedy;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class PriorityQueue<E extends Comparable<E>> {
    private ArrayList<E> queue;

    public PriorityQueue() {
        queue = new ArrayList<>();
    }

    public void insert(E elem) {
        queue.add(elem);
        shiftUp();
    }

    private void shiftUp() {
        for (int chInd = queue.size() - 1, parInd = (chInd - 1) / 2; chInd > 0; chInd = parInd, parInd = (chInd - 1) / 2) {
            E child = queue.get(chInd);
            E parent = queue.get(parInd);
            if (child.compareTo(parent) > 0) {
                queue.set(chInd, parent);
                queue.set(parInd, child);
            }
        }
    }

    public E extractMax() {
        E head = queue.get(0);
        int lastInd = queue.size() - 1;

        queue.set(0, queue.get(lastInd));
        queue.remove(lastInd);

        shiftDown();

        return head;
    }

    private void shiftDown() {
        for (int parInd = 0; parInd < queue.size(); ) {
            E par = queue.get(parInd);
            E biggestCh = null;
            int biggestChInd = 0;

            for (int chInd = parInd * 2 + 1; chInd < queue.size() && chInd < parInd * 2 + 3; chInd++) {
                E curr = queue.get(chInd);
                if (biggestCh == null || curr.compareTo(biggestCh) > 0) {
                    biggestChInd = chInd;
                    biggestCh = curr;
                }
            }

            if (biggestCh != null && biggestCh.compareTo(par) > 0) {
                queue.set(parInd, biggestCh);
                queue.set(biggestChInd, par);
                parInd = biggestChInd;
            } else return;
        }
    }

    public int size() {
        return queue.size();
    }

    @Override
    public String toString() {
        return queue.toString();
    }

    public static void main2(String[] args) {
        final Pattern CMD_INSERT = Pattern.compile("Insert (?<val>\\d+)");
        final Pattern CMD_EXTRACTMAX = Pattern.compile("ExtractMax");
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        Scanner sc = new Scanner(System.in);
        sc.useDelimiter("\n");
        int cmdCount = sc.nextInt();

        for (int i = 0; i < cmdCount; i++) {
            String cmd = sc.next();
            Matcher matcher;
            if ((matcher = CMD_INSERT.matcher(cmd)).matches()) {
                Integer val = Integer.valueOf(matcher.group("val"));
                pq.insert(val);
                continue;
            }
            if (CMD_EXTRACTMAX.matcher(cmd).matches()) System.out.println(pq.extractMax());
        }

    }

    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        Random random = new Random(System.currentTimeMillis());
//        for (int i = 0; i < 10; i++) pq.insert(random.nextInt(100));
        Stream.of(423, 314, 215, 680, 860, 622, 234, 426, 724, 856, 388, 9, 964, 603, 548, 975, 671, 16, 18, 412).forEach(pq::insert);
        System.out.println(pq);

        while (pq.size() > 0) System.out.println(String.format("max=%d pq=%s", pq.extractMax(), pq));
    }
}

