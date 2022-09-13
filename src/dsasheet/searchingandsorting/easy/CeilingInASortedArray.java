package dsasheet.searchingandsorting.easy;

public class CeilingInASortedArray {
    public static void main(String[] args) {
        int[] arr = {1, 2, 8, 10, 10, 12, 19};
        for (int i = 0; i <= 20; i++) {
            System.out.println(i+"->"+findCeil(arr, i));
        }
    }

    public static int findCeil(int[] arr, int x) {
        int l =0;
        int r = arr.length-1;
        int mid = 0;
        while (l <= r) {
            mid = (l+r) / 2;
            if(arr[mid] == x) {
                return x;
            } else if(arr[mid] > x) {
                r = mid-1;
            } else {
                l = mid+1;
            }
        }
        while (mid < arr.length && arr[mid] < x) {
            mid++;
        }
        return mid >= arr.length ? -1 : arr[mid];
    }
}
