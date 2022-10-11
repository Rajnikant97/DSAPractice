package leetcode.contest.weekly_contest_314;

public class FindTheOriginalArrayOfPrefixXor {
    public static void main(String[] args) {
        int[] p = {5,2,0,3,1};
        for(int x : findArray(p)) {
            System.out.print(x+" ");
        }
    }

    public static int[] findArray(int[] pref) {
        int n = pref.length;
        int[] arr = new int[n];
        int xor = 0;
        for (int i = 0; i < n; i++) {
            arr[i] = xor ^ pref[i];
            xor = xor ^ arr[i];
        }
        return arr;
    }
}
