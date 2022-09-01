package dsasheet.arrays.easy;

public class SearchInRotatedSortedArray {

    public static void main(String[] args) {
        int[] arr = {4,5,6,7,0,1,2};
        System.out.println(search(arr,1));
    }
    public static int search(int[] arr, int target) {
        int indMin = findIndexOfMinimum(arr);

        if(target < arr[0] || indMin == 0) {
            return binarySearch(arr, indMin, arr.length - 1, target);
        } else {
            return binarySearch(arr, 0, indMin - 1, target);
        }
    }

    public static int findIndexOfMinimum(int[] arr){
        int indMin = 0;
        int start = 0;
        int end = arr.length-1;
        if(arr[start] >= arr[end]) {
            while(start < end) {
                int mid = (start + end + 1) / 2;
                if(arr[mid] < arr[mid-1]) {
                    indMin = mid;
                    break;
                } else if (arr[mid] > arr[start]) {
                    start = mid;
                } else {
                    end = mid;
                }
            }
        }
        return indMin;
    }

    public static int binarySearch(int[] arr, int start, int end, int key) {
        while(start<=end) {
            int mid = (start+end)/2;
            if(arr[mid] == key){
                return mid;
            } else if (arr[mid] < key) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }


}
