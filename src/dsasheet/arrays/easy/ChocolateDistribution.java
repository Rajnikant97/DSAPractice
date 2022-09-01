package dsasheet.arrays.easy;

import java.util.Arrays;

public class ChocolateDistribution {
    public static void main(String[] args) {
        int[] arr = {12, 4, 7, 9, 2, 23, 25, 41, 30, 40, 28, 42, 30, 44, 48, 43, 50};
        int m = 7;
        System.out.println(minDifference(arr,arr.length,m)); // 10
    }

    public static int minDifference(int[] arr, int n, int m) {
        Arrays.sort(arr);
        int min  = Integer.MAX_VALUE;
        for (int i = 0; i <= (n-m); i++) {
            int diff = arr[m+i-1] - arr[i];
            min = Math.min(min, diff);
        }
        return min;
    }
}
