package dsasheet.searchingandsorting.easy;

public class SearchInStepArray {
    public static void main(String[] args) {
        int[] arr = {4, 5, 6, 7, 6};
        int k = 1;
        int x = 6;
        System.out.println(search(arr, arr.length, x, k));
    }

    public static int search (int[] arr, int n, int x, int k) {
        int i = 0;
        while(i<n){
            if(arr[i] == x) {
                return i;
            }
            i += Math.max(1, Math.abs(arr[i] - x) / k);
        }
        return -1;
    }
}
