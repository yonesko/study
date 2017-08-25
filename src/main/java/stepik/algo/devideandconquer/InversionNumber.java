package stepik.algo.devideandconquer;

public class InversionNumber {
    static int count(int arr[]) {
        int ret = 0;

        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) ret++;
            }
        }

        return ret;
    }
}
