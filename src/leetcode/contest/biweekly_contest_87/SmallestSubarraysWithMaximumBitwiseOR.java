package leetcode.contest.biweekly_contest_87;

public class SmallestSubarraysWithMaximumBitwiseOR {
    public static void main(String[] args) {
        SmallestSubarraysWithMaximumBitwiseOR s = new SmallestSubarraysWithMaximumBitwiseOR();
        int[] nums = {1,0,2,1,3};
        for(int x : s.smallestSubarrays(nums)) {
            System.out.print(x+" ");
        }
        System.out.println();
    }

    public int[] smallestSubarrays(int[] nums) {
        int n = nums.length;
        int[] bits = new int[32];
        int[] ans = new int[n];
        for(int i=n-1; i>=0; i--) {
            ans[i] = 1;
            for(int j = 0; j<bits.length;j++){
                if((nums[i] & (1<<j)) > 0) {
                    bits[j] = i;
                }
                ans[i] = Math.max(ans[i], bits[j] - i + 1);
            }
        }
        return ans;
    }
}
