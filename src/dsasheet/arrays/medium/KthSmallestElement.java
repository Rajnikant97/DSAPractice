package dsasheet.arrays.medium;

public class KthSmallestElement {
    public static void main(String[] args) {
        int arr[] = {7, 10, 4, 3, 20, 15};
        int k = 3;
        System.out.println(kthSmallest(arr, 0, arr.length-1, k));
    }
    public static int kthSmallest(int[] arr, int l, int r, int k) {
        //Your code here
        int size = 100_001;
        boolean[] ind = new boolean[size];
        for (int j : arr) {
            ind[j] = true;
        }
        for(int i = 0; i<=size; i++) {
            if(ind[i]) {
                if(k==1) {
                    return i;
                } else {
                    k--;
                }
            }
        }
        return -1;
    }
}
