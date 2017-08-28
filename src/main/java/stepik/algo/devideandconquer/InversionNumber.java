package stepik.algo.devideandconquer;

import java.util.*;
import java.util.stream.Collectors;

public class InversionNumber {
    private static long invNum = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int arr[] = new int[sc.nextInt()];

        for (int i = 0; i < arr.length; i++) arr[i] = sc.nextInt();

        System.out.println(count(arr));
    }

    static List<Integer> count(List<Integer> arr) {
        int m = arr.size() / 2;
        return merge(mergeSort(arr.subList(0, m)), mergeSort(arr.subList(m, arr.size())));
    }

    static List<Integer> merge(List<Integer> a, List<Integer> b) {
        List<Integer> ret = new ArrayList<>(a.size() + b.size());

        int ia = 0, ib = 0;
        for (; ia < a.size() && ib < b.size(); ) {
            if (a.get(ia) > b.get(ib)) {
                invNum += a.size() - ia;
                ret.add(b.get(ib++));
            } else {
                ret.add(a.get(ia++));
            }
        }

        for (int i = ia; i < a.size(); i++) ret.add(a.get(i));
        for (int i = ib; i < b.size(); i++) ret.add(b.get(i));

        return ret;
    }

    static List<Integer> mergeSort(List<Integer> arr) {
        if (arr.size() < 2) return arr;

        if (arr.size() == 2) {
            if (arr.get(0) > arr.get(1)) {
                Collections.swap(arr, 0, 1);
                invNum++;
                return arr;
            } else return arr;
        }
        int m = arr.size() / 2;
        return merge(mergeSort(arr.subList(0, m)), mergeSort(arr.subList(m, arr.size())));
    }

    static long count(int arr[]) {
        invNum = 0;

        count(Arrays.stream(arr)
                .boxed()
                .collect(Collectors.toList()));

        return invNum;
    }

    static int countRobust(int arr[]) {
        int invNum = 0;

        for (int i = 0; i < arr.length - 1; i++)
            for (int j = i + 1; j < arr.length; j++)
                if (arr[i] > arr[j]) invNum++;

        return invNum;
    }
}
