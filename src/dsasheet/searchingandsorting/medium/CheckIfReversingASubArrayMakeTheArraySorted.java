package dsasheet.searchingandsorting.medium;

public class CheckIfReversingASubArrayMakeTheArraySorted {
    public static void main(String[] args) {
        int[] arr = {1,2,5,4,3};
        System.out.println(checkReverse(arr, arr.length));

        arr = new int[]{5,4,3,1,2};
        System.out.println(checkReverse(arr, arr.length));

        arr = new int[]{1,2,3,10,9,8,11,12,13};
        System.out.println(checkReverse(arr, arr.length));

        arr = new int[]{13,12,11,5,6,7,8,3,2,1};
        System.out.println(checkReverse(arr, arr.length));

        arr = new int[]{13,12,11,6,7,8,3,4,5};
        System.out.println(checkReverse(arr, arr.length));

        arr = new int[]{1,2,3,4,5};
        System.out.println(checkReverse(arr, arr.length));

        arr = new int[]{5,4,3,2,1};
        System.out.println(checkReverse(arr, arr.length));

        arr = new int[]{1};
        System.out.println(checkReverse(arr, arr.length));

        arr = new int[]{};
        System.out.println(checkReverse(arr, arr.length));

    }

    static boolean checkReverse(int[] arr, int n) {
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] +" ");
        }
        System.out.println();
        int peakCount = 0;
        int ind1 = -1;
        int ind2 = -1;

        for (int i = 1; i < n-1; i++) {
            if((arr[i]-arr[i-1]) * (arr[i]-arr[i+1]) > 0) {
                peakCount++;
                if(peakCount == 1) {
                    ind1 = i;
                } else if(peakCount == 2) {
                    ind2 = i;
                } else {
                    return false;
                }
            }
        }
        if(ind2 != -1) {
            return (arr[ind2+1] - arr[ind1]) * (arr[ind2] - arr[ind1-1]) > 0;
        } else if(ind1 != -1) {
            return (arr[ind1] - arr[ind1-1]) * (arr[n-1] - arr[ind1-1]) > 0;
        }
        return true;
    }
}
