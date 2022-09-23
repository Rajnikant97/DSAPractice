package dsasheet.arrays.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class OverlappingIntervals {
    public static void main(String[] args) {
        int[][]mat = {{1,3},{2,4},{6,8},{9,10}};
        for(int[]arr:overlappedInterval(mat)) {
            System.out.println(arr[0]+", "+arr[1]);
        }
    }

    public static int[][] overlappedInterval(int[][] mat) {
        Arrays.sort(mat, Comparator.comparingInt(a -> a[0]));
        List<List<Integer>> list = new ArrayList<>();
        int[] curr = mat[0];
        for(int[]arr : mat) {
            if(curr[1] >= arr[0]) {
                curr[1] = Math.max(curr[1], arr[1]);
            } else {
                list.add(Arrays.asList(curr[0],curr[1]));
                curr = arr;
            }
        }
        list.add(Arrays.asList(curr[0],curr[1]));
        int[][] ans = new int[list.size()][2];
        for (int i = 0; i < ans.length; i++) {
            ans[i][0] = list.get(i).get(0);
            ans[i][1] = list.get(i).get(1);
        }
        return ans;
    }
}
