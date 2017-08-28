package stepik.algo.devideandconquer;

import java.util.Arrays;
import java.util.Scanner;

public class BinarySearch {
    static int search(int arr[], int val) {
        int l = 0, r = arr.length - 1;
        int m;

        while (l <= r) {
            m = l + (r - l) / 2;
            if (arr[m] == val) {
                return m;
            } else if (arr[m] < val) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int nums[] = new int[sc.nextInt()];
        for (int i = 0; i < nums.length; i++) nums[i] = sc.nextInt();

        System.out.println(Arrays.toString(nums));

        int searchCount = sc.nextInt();
        for (int i = 0; i < searchCount; i++) {
            int r = BinarySearch.search(nums, sc.nextInt());
            System.out.printf(String.format("%d ", r == -1 ? -1 : r + 1));
        }
    }
}
