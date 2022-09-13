package dsasheet.searchingandsorting.medium;

import java.util.Arrays;

public class CountTripletsWithSumSmallerThanXIInDistinctElementArray {

    public static void main(String[] args) {
        int sum = 12;
        int[] arr = {5, 1, 3, 4, 7};
        System.out.println(countTriplets(arr,arr.length,sum));
    }

    static long countTriplets(int arr[], int n,int sum) {
        Arrays.sort(arr);
        long count = 0;
        for(int i =0 ;i<n;i++) {
            long temp = sum - arr[i];
            int l = 1+i;
            int r = n-1;
            while(l<r) {
                long s = arr[l]+arr[r];
//                 System.out.println(arr[i]+" "+arr[l]+" "+arr[r]);
                if(s<temp) {
                    count += r-l;
                    l++;
                }else {
                    r--;
                }
            }
        }
        return count;
    }
}
