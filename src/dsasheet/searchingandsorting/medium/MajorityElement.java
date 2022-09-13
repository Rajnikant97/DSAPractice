package dsasheet.searchingandsorting.medium;

import java.util.HashMap;
import java.util.Map;

public class MajorityElement {
    public static void main(String[] args) {
        int[] arr = {2,2,2,1,1,2,2,2,3,4,5};
        System.out.println(majorityElement(arr,arr.length));
    }

    static int majorityElement(int a[], int size) {
        int ind = 0;
        int count = 0;
        for(int i = 0; i<size; i++) {
            if(count == 0) {
                ind = i;
            }
            if(a[i] == a[ind]) {
                count++;
            } else {
                count--;
            }
        }
        count = 0;
        for(int i=0;i < size; i++) {
            if(a[i] == a[ind]) {
                count++;
            }
        }
        return (count > size/2) ? a[ind] : -1;
    }

    static int majorityElement2(int a[], int size) {
        // your code here
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<size;i++) {
            if(!map.containsKey(a[i])) {
                map.put(a[i], 0);
            }
            map.put(a[i], map.get(a[i]) + 1);
        }

        for(Map.Entry<Integer, Integer> e : map.entrySet()) {
            if(e.getValue() > size/2) {
                return e.getKey();
            }
        }
        return -1;
    }
}
