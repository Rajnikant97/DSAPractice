package dsasheet.arrays.medium;


import java.util.Arrays;

public class NextPermutation {
    public static void main(String[] args) {
        int[] arr = {4,3,2,1};
        int[] brr = arr.clone();

        for (int i = 0; i < 24; i++) {
            nextPermutation(arr);
            nextPermutation2(brr);
            System.out.println();
            if(!Arrays.equals(arr, brr)) {
                System.out.println("answer not matching");
                break;
            }
        }
    }

    public static void nextPermutation(int[] arr) {
        int ind = -1;
        for (int i = arr.length-1; i > 0; i--) {
            if(arr[i] > arr[i-1]) {
                ind = i - 1;
                break;
            }
        }
        if(ind != -1) {
            for (int i = arr.length - 1; i > ind ; i--) {
                if (arr[i] > arr[ind]) {
                    int temp = arr[ind];
                    arr[ind] = arr[i];
                    arr[i] = temp;
                    break;
                }
            }
        }
        int l = ind + 1;
        int r = arr.length-1;
        while (l < r){
            int temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
            l++;
            r--;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void nextPermutation2(int[] arr) {
        int left = 0;
        int right = -1;
        for (int i = arr.length-1; i >= 0; i--) {
            for (int j = i-1; j >= left; j--) {
                if(arr[j] < arr[i]) {
                    if(j>left || (right == -1 || arr[i]<arr[right])){
                        left = j;
                        right = i;
                    }
                    break;
                }
            }
        }
        if(right == -1) {
            for (int i = 0; i < arr.length/2; i++) {
                int temp = arr[i];
                arr[i] = arr[arr.length-1-i];
                arr[arr.length-1-i] = temp;
            }
        } else {
            int temp = arr[right];
            arr[right] = arr[left];
            arr[left] = temp;
            Arrays.sort(arr,left+1,arr.length);
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }


}
