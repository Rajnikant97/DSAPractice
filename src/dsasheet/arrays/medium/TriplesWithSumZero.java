package dsasheet.arrays.medium;

import java.util.*;

public class TriplesWithSumZero {

    public static void main(String[] args) {
        int[] arr = {-1,0,1,2,-1,-4};
        System.out.println(threeSum(arr));
        System.out.println(threeSum2(arr));
    }

    public static List<List<Integer>> threeSum(int[] arr) {
        Set<List<Integer>> set = new HashSet<>();
        Arrays.sort(arr);
        int n = arr.length;
        for(int i=0;i<n;i++){
            int sum = -arr[i];
            int l = i+1;
            int r = n-1;
            while(l<r) {
                int x = arr[l]+arr[r];
                if(x==sum) {
                    set.add(Arrays.asList(arr[i],arr[l],arr[r]));
                    l++;
                    r--;
                } else if(x<sum) {
                    l++;
                }else{
                    r--;
                }
            }
        }
        return new ArrayList<>(set);
    }

    public static List<List<Integer>> threeSum2(int[] arr) {
        List<List<Integer>> lists = new ArrayList<>();
        Arrays.sort(arr);
        int n = arr.length;
        for(int i=0;i<n;i++){
            if(i>0 && arr[i] == arr[i-1])continue;
            int sum = -arr[i];
            int l = i+1;
            int r = n-1;
            while(l<r) {
                int x = arr[l]+arr[r];
                if(x==sum) {
                    lists.add(Arrays.asList(arr[i],arr[l],arr[r]));
                    l++;
                    r--;
                    while(l<r && arr[r]==arr[r+1])r--;
                } else if(x<sum) {
                    l++;
                }else{
                    r--;
                }
            }
        }
        return lists;
    }
}
