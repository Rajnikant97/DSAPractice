package dsasheet.searchingandsorting.medium;

import java.util.ArrayList;

public class FindDuplicatesInAnArray {
    public static void main(String[] args) {
        int a[] = {2,3,1,2,3};
        System.out.println(duplicates(a,a.length));
    }

    public static ArrayList<Integer> duplicates(int arr[], int n) {
        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0;i<n;i++) {
            int curr = arr[i]%n;
            arr[curr] += n;
        }

        for(int i=0;i<n;i++) {
            if(arr[i]/n > 1) {
                list.add(i);
            }
        }

        if(list.isEmpty()){
            list.add(-1);
        }
        return list;
    }

    public static ArrayList<Integer> duplicates2(int arr[], int n) {
        // code here
        ArrayList<Integer>list = new ArrayList<>();
        int[] count = new int[n];
        for(int i=0;i<n;i++){
            count[arr[i]]++;
        }
        for(int i=0;i<n;i++) {
            if(count[i]>1){
                list.add(i);
            }
        }
        if(list.isEmpty()) {
            list.add(-1);
        }
        return list;
    }

    public static ArrayList<Integer> duplicates3(int arr[], int n) {
        for(int i=0;i<n;i++) {
            int ind = i;
            while(true) {
                if(arr[ind] == ind) {
                    arr[ind] = -1;
                    break;
                } else if(arr[ind] < 0) {
                    arr[ind]--;
                    break;
                }
                int temp = arr[ind];
                arr[ind]=ind;
                ind = temp;
            }
        }

        ArrayList<Integer> list = new ArrayList<>();
        for(int i=0;i<n;i++){
            if(arr[i]<-1){
                list.add(i);
            }
        }

        if(list.isEmpty()){
            list.add(-1);
        }
        return list;
    }
}
