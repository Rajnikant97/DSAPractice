package dsasheet.twodarrays.medium;

import java.util.ArrayList;

public class ZigzagDiagonalTraversal {
    public static void main(String[] args) {
        int[][] mat = {
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };
        System.out.println(downwardDigonal(mat.length, mat));
    }
    static ArrayList<Integer> downwardDigonal(int n, int a[][]) {
        ArrayList<Integer> list = new ArrayList<>();
        for(int x = 0; x < n; x++) {
            for(int r = 0, c = x; c >= 0 && r < n; r++,c--) {
                list.add(a[r][c]);
            }
        }
        for(int x = 1; x < n; x++) {
            for(int r = x, c = n-1; c >= 0 && r < n; r++,c--) {
                list.add(a[r][c]);
            }
        }
        return list;
    }
}
