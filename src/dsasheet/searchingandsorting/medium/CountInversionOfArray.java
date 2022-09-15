package dsasheet.searchingandsorting.medium;

import java.util.Arrays;

public class CountInversionOfArray {
    public static void main(String[] args) {
        long[] arr = {2, 4, 1, 3, 5};
        System.out.println(inversionCount(arr, arr.length));
    }

    static long inversionCount(long arr[], long N) {
        return mergeSortAndCount(arr,0,(int)N-1);
    }

    static long mergeSortAndCount(long[] arr, int l, int r) {
        long count = 0;
        if(l<r) {
            int mid = (l+r)/2;
            count += mergeSortAndCount(arr, l, mid);
            count += mergeSortAndCount(arr, mid+1, r);
            count += mergeAndCount(arr, l, mid, r);
        }
        return count;
    }

    static long mergeAndCount(long[]arr, int l, int mid, int r) {
        long count = 0;
        long[] left = Arrays.copyOfRange(arr, l, mid+1);
        long[] right = Arrays.copyOfRange(arr, mid+1, r+1);
        int i=0,j=0,k=l;
        while(i<left.length && j<right.length) {
            if(left[i]<=right[j]) {
                arr[k++] = left[i++];
            } else {
                arr[k++] = right[j++];
                count += mid + 1 - (l+i);
            }
        }
        while(i<left.length) {
            arr[k++] = left[i++];
        }
        while(j<right.length) {
            arr[k++] = right[j++];
        }
        return count;
    }

    static long inversionCount2(long arr[], long N)
    {
        // Your Code Here
        long count = 0;
        int n = arr.length;
        long min = arr[n-1];
        long max = arr[n-1];
        for (int i=n-1;i>=0;i--) {
            if (max<arr[i]) {
                max = arr[i];
                count += n-i-1;
            } else if (min<arr[i]) {
                for(int j=i+1;j<n;j++){
                    if(arr[i]>arr[j]){
                        count++;
                    }
                }
            } else {
                min=arr[i];
            }
        }
        return count;
    }
}
