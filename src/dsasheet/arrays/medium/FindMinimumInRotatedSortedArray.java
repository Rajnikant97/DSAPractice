package dsasheet.arrays.medium;

public class FindMinimumInRotatedSortedArray {
    public static void main(String[] args) {
        int[] arr = {3,4,5,1,2};
        System.out.println(findMin(arr));
    }

    public static int findMin(int[] arr) {
        int n = arr.length;
        int last = arr[n-1];
        int first = arr[0];
        if(first < last) {
            return first;
        }
        if(n==1) {
            return arr[0];
        }

        int l = 0;
        int r = n-1;
        while(l<=r) {
            int mid = (l+r+1)/2;
            if(arr[mid] < arr[mid-1]) {
                return arr[mid];
            } else if(arr[mid] < first) {
                r = mid-1;
            } else {
                l=mid+1;
            }
        }
        return -1;
    }
}
