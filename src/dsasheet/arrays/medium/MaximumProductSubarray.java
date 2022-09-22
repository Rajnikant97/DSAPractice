package dsasheet.arrays.medium;

public class MaximumProductSubarray {
    public static void main(String[] args) {
        int[] arr = {2,3,-2,4};
        System.out.println(maxProduct(arr));
        System.out.println(maxProduct2(arr));
        System.out.println(maxProduct3(arr));
    }

    public static int maxProduct(int[] arr) {
        int max = Integer.MIN_VALUE;
        int n = arr.length;
        int curr = 1;
        int first = 1;
        boolean zero = false;
        boolean isFirstNegative = true;
        for (int i = 0; i < n; i++) {
            if(arr[i] != 0) {
                curr *= arr[i];
                max = Math.max(max, curr);
                max = Math.max(max, curr / first);
                if(curr < 0 && isFirstNegative) {
                    first = curr;
                    isFirstNegative = false;
                }
            } else {
                curr = 1;
                first = 1;
                isFirstNegative = true;
                zero = true;
            }
        }
        if(max<0 && zero) {
            max = 0;
        }
        return max;
    }

    public static int maxProduct2(int[] arr) {
        int maxP = Integer.MIN_VALUE;
        int n = arr.length;
        int currP = 1;
        for(int i=0;i<n;i++) {
            currP = 1;
            for(int j=i;j<n;j++){
                currP = currP*arr[j];
                maxP = Math.max(currP,maxP);
            }
        }
        return maxP;
    }

    public static int maxProduct3(int[] nums) {
        int max = nums[0];
        int min = nums[0];
        int ans = nums[0];

        for (int i = 1; i < nums.length; i++){
            int maxProduct = Math.max(nums[i], nums[i] * max);
            int minProduct = Math.min(nums[i], nums[i] * min);

            //in case of negative number flips the max and min
            maxProduct = Math.max(maxProduct, nums[i] * min);
            minProduct = Math.min(minProduct, nums[i] * max);

            max = maxProduct;
            min = minProduct;

            ans = Math.max(ans, max);
        }

        return ans;
    }

    public static int maxProduct5(int[] arr) {
        int max = Integer.MIN_VALUE;
        int curr = 1;
        for(int i=0; i<arr.length; i++) {
            curr *= arr[i];
            max = Math.max(max, Math.max(curr, arr[i]));
            if(curr == 0) {
                curr = 1;
            }
        }
        curr = 1;
        for(int i=arr.length-1; i>=0; i--) {
            curr *= arr[i];
            max = Math.max(max, Math.max(curr, arr[i]));
            if(curr == 0) {
                curr = 1;
            }
        }
        return max;
    }
}
