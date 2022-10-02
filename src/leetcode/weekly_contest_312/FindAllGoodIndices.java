package leetcode.weekly_contest_312;

import java.util.ArrayList;
import java.util.List;

public class FindAllGoodIndices {
    public static void main(String[] args) {
        int[] arr = {395808,395808,395808,395808,395808,395808,395808,395808,395808,395808,395808,395808,395808,395808,395808,395808,395808,395808,395808,395808,395808,395808,395808,395808,395808,395808,395808,395808,395808,395808,395808,395808,395808,395808,395808,395808,395808,395808,395808,395808,395808,395808,395808,395808,395808,470030,470030,470030,470030,470030,470030,470030,470030,470030,470030,470030,470030,470030,470030,470030,470030,470030,470030,470030,470030,470030,470030,470030,470030,153490,330001,330001,330001,330001,330001,330001,330001,37284,470030,470030,470030,470030,470030,470030,156542,226743};
        arr = new int[]{2,1,1,1,3,4,1};
        int k =2;
        System.out.println(goodIndices(arr, k));
    }

    public static List<Integer> goodIndices(int[] nums, int k) {
        List<Integer> list = new ArrayList<>();
        for (int i = k; i < nums.length - k; i++) {
            if(isNonIncreasing(nums, i-k, i-1) && isNonDecreasing(nums, i+1, i+k)) {
                list.add(i);
            }
        }
        return list;
    }

    public static boolean isNonIncreasing(int[] arr, int s, int e) {
//        System.out.println(s+"->"+e);
        for (int i = s+1; i <= e; i++) {
            if(arr[i-1] < arr[i]) {
                return false;
            }
        }
        return true;
    }

    public static boolean isNonDecreasing(int[] arr, int s, int e) {
//        System.out.println(s+"->"+e);
        System.out.println();
        for (int i = s+1; i <= e; i++) {
            if(arr[i-1] > arr[i]) {
                return false;
            }
        }
        return true;
    }
}
