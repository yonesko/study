package stepik.algo.dynamicprogramming;

import java.util.Scanner;

public class Stairs {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int arr[] = new int[sc.nextInt()];
        for (int i = 0; i < arr.length; i++) arr[i] = sc.nextInt();

        System.out.println(calc(arr));
    }

    public static int calc(int arr[]) {
        int D[] = new int[arr.length + 1];
        D[1] = arr[0];

        for (int i = 2; i < D.length; i++) {
            D[i] = Math.max(D[i - 1], D[i - 2]) + arr[i - 1];
        }

        return D[arr.length];
    }
}