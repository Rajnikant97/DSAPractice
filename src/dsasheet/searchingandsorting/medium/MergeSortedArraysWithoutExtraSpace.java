package dsasheet.searchingandsorting.medium;

import java.util.Arrays;

public class MergeSortedArraysWithoutExtraSpace {
    public static void main(String[] args) {
        long[] arr = {1, 1, 2, 5, 6, 7, 11, 12, 14, 23, 24, 29, 35, 36, 36, 38, 41, 44};
        long[] brr = {7, 8, 8, 17, 20, 22, 27, 27, 38};

        merge(arr, brr, arr.length, brr.length);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
        System.out.println();
        for (int i = 0; i < brr.length; i++) {
            System.out.print(brr[i]+" ");
        }
    }
    public static void merge2(long[] arr, long[] brr, int n, int m) {
        for(int i=0;i<n;i++) {
            if(arr[i] > brr[0]) {
                long temp = arr[i];
                arr[i] = brr[0];
                brr[0] = temp;
                for(int j=0;j<m-1;j++){
                    if(brr[j]>brr[j+1]) {
                        temp = brr[j];
                        brr[j] = brr[j+1];
                        brr[j+1] = temp;
                    } else {
                        break;
                    }
                }
            }
        }
    }

    public static void merge(long[] arr, long[] brr, int n, int m) {
        int i = 0;
        int j = 0;
        int k = n-1;
        while(i<n && j<m && i<=k) {
//            System.out.println(arr[i] + " " + brr[j]);
            if(arr[i] < brr[j]) {
                i++;
            } else {
                long temp = arr[k];
                arr[k] = brr[j];
                brr[j] = temp;
                j++;
                k--;
            }
        }
        Arrays.sort(arr);
        Arrays.sort(brr);
    }
}
