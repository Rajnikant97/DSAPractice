package dsasheet.arrays.easy;

public class SumOfMaxAndMin {
    public static void main(String[] args) {
        int[] arr = {-2,1,-4,5,3};
        System.out.println(findSum(arr, arr.length));
    }

    public static int findSum(int[] arr, int n) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, arr[i]);
            min = Math.min(min, arr[i]);
        }
        return (min + max);
    }
}
