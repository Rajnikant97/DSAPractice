package leetcode.weekly_contest_312;

public class LongestSubarrayWithMaximumBitwiseAND {
    public static void main(String[] args) {
        int[] arr = {395808,395808,395808,395808,395808,395808,395808,395808,395808,395808,395808,395808,395808,395808,395808,395808,395808,395808,395808,395808,395808,395808,395808,395808,395808,395808,395808,395808,395808,395808,395808,395808,395808,395808,395808,395808,395808,395808,395808,395808,395808,395808,395808,395808,395808,470030,470030,470030,470030,470030,470030,470030,470030,470030,470030,470030,470030,470030,470030,470030,470030,470030,470030,470030,470030,470030,470030,470030,470030,153490,330001,330001,330001,330001,330001,330001,330001,37284,470030,470030,470030,470030,470030,470030,156542,226743};
        arr = new int[]{2,2,2};
        System.out.println(longestSubarray(arr));
    }

    public static int longestSubarray(int[] nums) {
        int maxLen = 1;
        int currLen = 1;
        int currAND = nums[0];
        int maxAND = 0;

        for (int i = 0; i < nums.length; i++) {
            maxAND = Math.max(maxAND, nums[i]);
        }
        for (int i = 1; i < nums.length; i++) {
            currAND = currAND & nums[i];
            if(currAND != maxAND) {
                maxLen = Math.max(maxLen, currLen);
                currAND = nums[i];
                currLen = 0;
            }
            currLen++;
        }
        if(currAND == maxAND) {
            maxLen = Math.max(maxLen, currLen);
        }

        return maxLen;
    }
}
