package dsasheet.arrays.easy;

import java.util.HashSet;
import java.util.Set;

public class DuplicateInArray {

    public static void main(String[] args) {
        int[] arr = {1,2,3};
        System.out.println(containsDuplicate(arr));
    }

    public static boolean containsDuplicate(int[] arr) {
        Set<Integer> set  = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            if(set.contains(arr[i])) {
                return true;
            } else {
                set.add(arr[i]);
            }
        }
        return false;
    }
}
