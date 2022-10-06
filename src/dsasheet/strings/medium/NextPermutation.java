package dsasheet.strings.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NextPermutation {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        for (int i = 0; i < 120; i++) {
            List<Integer> list =nextPermutation(arr.length, arr);
            System.out.println(list);
            for (int j = 0; j < arr.length; j++) {
                arr[j] = list.get(j);
            }
        }
    }

    static List<Integer> nextPermutation(int n, int[] arr){
        List<Integer> list = new ArrayList<>();
        int ind = -1;
        for(int i = n-1; i > 0; i--) {
            if(arr[i-1] < arr[i]) {
                ind = i-1;
                break;
            }
        }
        if(ind == -1) {
            for (int i = n-1; i >= 0; i--) {
                list.add(arr[i]);
            }
        } else {
            int ind2 = n-1;
            for (int i = ind+1; i < n; i++) {
                if(arr[i] < arr[ind]) {
                    ind2 = i-1;
                    break;
                }
            }
            int temp = arr[ind];
            arr[ind] = arr[ind2];
            arr[ind2] = temp;
            for (int i = 1; i <= (n-ind)/2 ; i++) {
                temp = arr[ind+i];
                arr[ind+i]=arr[n-i];
                arr[n-i]=temp;
            }
            for (int i = 0; i < n; i++) {
                list.add(arr[i]);
            }
        }
        return list;
    }
}
