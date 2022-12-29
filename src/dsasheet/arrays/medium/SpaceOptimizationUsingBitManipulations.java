package dsasheet.arrays.medium;

import java.util.*;

public class SpaceOptimizationUsingBitManipulations {
    public static void main(String[] args) {
        int start = 4;
        int end = 130;
        int num1 = 2;
        int num2 = 5;

        System.out.println(getMultiplesMap(start,end,num1,num2));

        int[] arr = getMultiplesArray(start,end,num1,num2);
        for (int i = start; i <= end; i++) {
            if(arr[i-start]==1){
                System.out.print(i+" ");
            }
        }
        System.out.println();

        int[] bitArray = getMultiplesBitArray(start, end, num1, num2);
        for (int i = start; i <= end; i++) {
            int val = bitArray[i/30] & (1<<(i%30));
            if(val != 0) {
                System.out.print(i+" ");
            }
        }
        System.out.println();
    }

    public static Map<Integer, Integer> getMultiplesMap(int start, int end, int num1, int num2) {
        Map<Integer, Integer> map = new LinkedHashMap<>();
        for (int i = start; i <= end; i++) {
            if(i%num1==0 || i%num2==0) {
                map.put(i, 1);
            }
        }
        return map;
    }

    public static int[] getMultiplesArray(int start, int end, int num1, int num2) {
        int[] arr = new int[end-start+1];
        for (int i = start; i <=end; i++) {
            if(i%2==0 || i%5==0) {
                arr[i-start] = 1;
            }
        }
        return arr;
    }

    public static int[] getMultiplesBitArray(int start, int end, int num1, int num2) {
        int[] bitArray = new int[end/30+1];
        for (int i = start; i <= end; i++) {
            if(i%2==0 || i%5==0) {
                bitArray[i/30] = bitArray[i/30] | (1<<(i%30));
            }
        }
        return bitArray;
    }

}