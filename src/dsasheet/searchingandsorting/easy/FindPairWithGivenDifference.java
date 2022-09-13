package dsasheet.searchingandsorting.easy;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class FindPairWithGivenDifference {
    public static void main(String[] args) {
        int[] arr = {5, 20, 3, 2, 5, 80};
        System.out.println(findPair2(arr, arr.length, 78));
    }

    public static boolean findPair(int[] arr, int size, int n) {
        Arrays.sort(arr);
        int i=0,j=1;
        while (i<size && j<size) {
            int diff = arr[j]-arr[i];
//            System.out.println(diff);
            if(i!=j && diff==n){
                return true;
            } else if(diff>n) {
                i++;
            } else {
                j++;
            }
        }
        return false;
    }

    public static boolean findPair2(int[] arr, int size, int n) {
        Set<Integer> set = new HashSet<>();
        boolean duplicate = false;
        for (int i = 0; i < arr.length; i++) {
            if(set.contains(arr[i])) {
                duplicate =true;
            }
            set.add(arr[i]);
        }
        if(n==0) {
            return duplicate;
        }
        for (int i = 0; i < arr.length; i++) {
            int diff = Math.abs(arr[i] - n);
            if(set.contains(diff)){
                return true;
            }
        }
        return false;
    }
}
