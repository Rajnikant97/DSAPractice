package dsasheet.searchingandsorting.easy;

public class FloorInASortedArray {
    public static void main(String[] args) {
        long[] arr = {1,2,8,10,11,12,19};
        for (int i = 0; i <=20 ; i++) {
            System.out.println(i +"->"+findFloor(arr, arr.length, i));
        }
    }

    static int findFloor(long arr[], int n, long x) {
        int l = 0;
        int r = arr.length - 1;
        int mid = 0;
        while(l<=r) {
            mid = (l+r)/2;
            if(arr[mid] == x) {
                return mid;
            } else if(arr[mid] > x) {
                r = mid-1;
            } else {
                l = mid+1;
            }
        }
        while(mid>=0 && arr[mid] > x) {
            System.out.print("i ");
            mid--;
        }
        return mid>=0 ? mid : -1;
    }
}
