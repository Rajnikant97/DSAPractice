package dsasheet.arrays.medium;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

public class KthLargestInArray {
    public static void main(String[] args) {
        int[] nums = {3,2,3,1,2,4,5,5,6,-1,-2,-2,0,0,-5,-4};
        int k = 4;

        for (int i = 1; i <= nums.length; i++) {
            System.out.print(i+"->" + findKthLargest(nums, i));
            System.out.print("="+findKthLargest2(nums,i));
            System.out.println("="+findKthLargest3(nums,i));
        }
    }

    public static int findKthLargest(int[] arr, int k) {
        int min = 0;
        int max = 0;

        for (int i = 0; i < arr.length; i++) {
            min = Math.min(min, arr[i]);
            max = Math.max(max, arr[i]);
        }

        min = -min;
        int[] pArr = new int[max + 1];
        int[] nArr = new int[min + 1];
        int pCount = 0;
        for (int i = 0; i < arr.length; i++) {
            int x = arr[i];
            if(x < 0) {
                nArr[-x]++;
            } else {
                pArr[x]++;
                pCount++;
            }
        }

        if (k > pCount) {
            int count = pCount;
            for (int i = 0; i <= min; i++) {
                count += nArr[i];
                if(count >= k) {
                    return -i;
                }
            }
        } else {
            int count = 0;
            for (int i = max; i >=0 ; i--) {
                count += pArr[i];
                if(count >= k) {
                    return i;
                }
            }
        }
        return -1;
    }

    public static int findKthLargest2(int[] arr, int k) {
        Map<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < arr.length; i++) {
            if(map.containsKey(arr[i])) {
                map.replace(arr[i], map.get(arr[i]) + 1);
            } else {
                map.put(arr[i], 1);
            }
        }

        int count = 0;
        for(Map.Entry<Integer,Integer> e : map.entrySet()) {
            count += e.getValue();
            if(count > (arr.length - k)) {
                return e.getKey();
            }
        }
        return -1;
    }

    public static int findKthLargest3(int[] arr, int k) {
        Arrays.sort(arr);
        return arr[arr.length-k];
    }
}
