package dsasheet.arrays.easy;

public class MaxSubArraySum {
    public static void main(String[] args) {
        int[] arr = {-2,1,-3,4,-1,2,1,-5,4};
        arr = new int[] {-1,-2};
        System.out.println(maxSubArray(arr));
    }

    public static int maxSubArray(int[] arr) {
        int max  =Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
        }

        if(max < 0) {
            return max;
        }

        int maxSum = 0;
        int sum = 0;

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            sum = Math.max(sum , 0);
            maxSum = Math.max(maxSum, sum);
        }
        return maxSum;
    }
}
