package dsasheet.searchingandsorting.medium;

public class MaximumSumSuchThatNoTwoElementsAreAdjacent {
    public static void main(String[] args) {
        int[] arr = {5,5,10,100,10,5};
        System.out.println(findMaxSum2(arr,arr.length));
    }

    public static int findMaxSum(int arr[], int n) {
        int[][] dp = new int[2][n];
        dp[0][0] = 0;
        dp[1][0] = arr[0];
        for (int i = 1; i < n; i++) {
            dp[1][i] = dp[0][i-1] + arr[i];
            dp[0][i] = Math.max(dp[0][i-1], dp[1][i-1]);
        }
        return Math.max(dp[0][n-1], dp[1][n-1]);
    }

    public static int findMaxSum2(int arr[], int n) {
        int includeLast = arr[0];
        int excludeLast = 0;
        for (int i = 1; i < n; i++) {
            int includeCurr = excludeLast + arr[i];
            int excludeCurr = Math.max(includeLast, excludeLast);
            includeLast = includeCurr;
            excludeLast = excludeCurr;
        }
        return Math.max(includeLast, excludeLast);
    }
}
