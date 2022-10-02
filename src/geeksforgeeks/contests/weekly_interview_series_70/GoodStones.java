package geeksforgeeks.contests.weekly_interview_series_70;

import java.util.HashSet;
import java.util.Set;

public class GoodStones {
    public static void main(String[] args) {
        int[] arr = {2, 3, -1, 2, -2, 4, 1};
        System.out.println(goodStones(arr.length, arr));
    }

    public static int goodStones(int n, int[] arr) {

        Set<Integer> good = new HashSet<>();
        Set<Integer> bad = new HashSet<>();

        for(int i=0;i<n;i++) {
            if(!good.contains(i) && !bad.contains(i)) {
                int ind = i;
                Set<Integer> curr = new HashSet<>();

                while(true) {
                    if(bad.contains(ind) || curr.contains(ind)) {
                        bad.addAll(curr);
                        break;
                    } else if(good.contains(ind)) {
                        good.addAll(curr);
                        break;
                    }
                    curr.add(ind);
                    ind = ind + arr[ind];

                    if(ind < 0 || ind >= n) {
                        good.addAll(curr);
                        break;
                    }
                }
            }
        }
        return good.size();
    }
}


