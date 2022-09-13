package dsasheet.searchingandsorting.easy;

import java.util.Arrays;

public class PermuteTwoArrays {
    public static void main(String[] args) {
        long[] a = {1,2,3};
        long[] b = {8,7,9};
        long k = 10;
        System.out.println(isPossible(a,b,a.length,k));
    }

    public static boolean isPossible(long a[], long b[], int n, long k) {
        Arrays.sort(a);
        Arrays.sort(b);
        for(int i=0;i<n;i++){
            if((a[i]+b[n-i-1])<k){
                return false;
            }
        }
        return true;
    }
}
