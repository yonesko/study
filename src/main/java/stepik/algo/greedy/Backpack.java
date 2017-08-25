package stepik.algo.greedy;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

class Backpack {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int capacity;

        List<Backpack.Item> items = new ArrayList<>(sc.nextInt());
        capacity = sc.nextInt();

        while (sc.hasNext()) items.add(new Backpack.Item(sc.nextInt(), sc.nextInt()));

        System.out.println(Backpack.backpack(capacity, items));
    }

    public static double backpack(int capacity, List<Item> items) {
        items.sort(Comparator.<Item>comparingDouble(o -> (double) o.cost / o.volume).reversed());
        double sumCost = 0D, volumeLeft = capacity;

        for (Item item : items) {
            if (volumeLeft >= item.volume) {
                volumeLeft -= item.volume;
                sumCost += item.cost;
            } else {
                sumCost += (volumeLeft / item.volume) * item.cost;
                break;
            }
        }

        return sumCost;
    }

    static class Item {
        final int cost, volume;

        Item(int cost, int volume) {
            this.cost = cost;
            this.volume = volume;
        }

        @Override
        public String toString() {
            return "Item{" +
                    "cost=" + cost +
                    ", volume=" + volume +
                    '}';
        }
    }
}
