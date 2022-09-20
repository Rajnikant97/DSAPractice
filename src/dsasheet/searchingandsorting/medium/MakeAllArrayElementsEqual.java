package dsasheet.searchingandsorting.medium;

import java.util.Arrays;

public class MakeAllArrayElementsEqual {
    public static void main(String[] args) {
        int[] arr = { 1, 100, 101,45,23,78,45,24,86,43,12 };//307
        System.out.println(minCostToMakeElementEqual(arr,arr.length));
    }

    public static int minCostToMakeElementEqual(int[] arr, int n){
        Arrays.sort(arr);
        int cost = 0;
        int l = 0;
        int r = n-1;
        while(l<r) {
            int c1 = (l+1)*(arr[l+1]-arr[l]);
            int c2 = (n-r)*(arr[r]-arr[r-1]);
            if(c1 < c2) {
                cost += c1;
                l++;
            } else {
                cost += c2;
                r--;
            }
        }
        return cost;
    }
}
