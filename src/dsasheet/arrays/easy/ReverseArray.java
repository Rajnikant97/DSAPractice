package dsasheet.arrays.easy;

public class ReverseArray {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7};
        reverse(arr, arr.length);

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void reverse(int[] arr, int n) {
        for (int i = 0; i < n/2; i++) {
            int temp = arr[i];
            arr[i] = arr[n-1-i];
            arr[n-i-1] = temp;
        }
    }
}
