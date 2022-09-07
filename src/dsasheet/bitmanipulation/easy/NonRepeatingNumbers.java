package dsasheet.bitmanipulation.easy;

import java.util.*;

public class NonRepeatingNumbers {

    public static void main(String[] args) {
       int[] arr = {1,1,4,4,3,5};
       int[] brr = singleNumber(arr);
        for (int i = 0; i < brr.length; i++) {
            System.out.print(brr[i] + " ");
        }

        System.out.println();
        brr = singleNumber2(arr);
        for (int i = 0; i < brr.length; i++) {
            System.out.print(brr[i] + " ");
        }
    }

    public static int[] singleNumber(int[] nums) {
        Set<Integer> count = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            int x = nums[i];
            if(count.contains(x)) {
                count.remove(x);
            } else {
                count.add(x);
            }
        }

        int[] single = new int[2];
        int ind =0;
        for(int e : count) {
            single[ind++] = e;
        }
        return single;
    }

    public static int[] singleNumber2(int[] arr) {
        int xor = 0;
        for (int i = 0; i < arr.length; i++) {
            xor ^= arr[i];
        }
        int bitMask = 1;
        while((bitMask & xor) == 0) {
            bitMask = bitMask << 1;
        }
        int x = 0;
        int y = 0;
        for (int i = 0; i < arr.length; i++) {
            if((arr[i] & bitMask) == 0) {
                x ^= arr[i];
            } else {
                y ^= arr[i];
            }
        }

        int[] single = {x, y};
        Arrays.sort(single);
        return single;
    }
}
