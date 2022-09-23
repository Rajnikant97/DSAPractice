package dsasheet.arrays.medium;

public class FindMinimumNumberOfMergeOperationsToMakeAnArrayPalindrome {

    public static void main(String[] args) {
        int[] arr = {15,4,15};
        System.out.println(countOperations(arr));

        arr = new int[] {1,4,5,1};
        System.out.println(countOperations(arr));

        arr = new int[] {1,3,6,4,13,12,2,3,5,4};
        System.out.println(countOperations(arr));
    }
    public static int countOperations(int[] arr) {
        int n = arr.length;
        int l = 0;
        int r = n-1;
        int count = 0;
        while(l<r) {
            if(arr[l]<arr[r]) {
                arr[l+1] = arr[l] + arr[l+1];
                arr[l] = -1;
                l++;
                count++;
            } else if(arr[l] > arr[r]) {
                arr[r-1] = arr[r]+arr[r-1];
                arr[r] = -1;
                r--;
                count++;
            } else {
                l++;
                r--;
            }
        }
        for(int x : arr) {
            System.out.print(x+" ");
        }
        System.out.println();
        return count;
    }
}
