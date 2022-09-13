package dsasheet.searchingandsorting.easy;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class ThreeSortedArrays {
    public static void main(String[] args) {
        int n1 = 6; int[] A = {1, 5, 10, 20, 40, 80};
        int n2 = 5; int[] B = {6, 7, 20, 80, 100};
        int n3 = 8; int[] C = {3, 4, 15, 20, 30, 70, 80, 120};
        System.out.println(commonElements(A,B,C,n1,n2,n3));
    }

    public static ArrayList<Integer> commonElements(int a[], int b[], int c[], int n1, int n2, int n3) {
        int i=0,j=0,k=0;
        ArrayList<Integer> list = new ArrayList<>();
        int prev = -1;
        boolean first = true;
        while(i<n1 && j<n2 && k<n3) {
            if((first || a[i]!=prev) && a[i]==b[j] && a[i]==c[k]){
                list.add(a[i]);
                prev = a[i];
                first = false;
                i++;j++;k++;
            } else if(a[i] < b[j]) {
                i++;
            } else if(b[j] < c[k]) {
                j++;
            } else {
                k++;
            }
//            System.out.println(i+","+j+","+k);
        }
        return list;
    }
}
