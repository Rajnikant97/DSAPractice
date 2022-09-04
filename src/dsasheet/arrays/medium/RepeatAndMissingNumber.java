package dsasheet.arrays.medium;

import java.util.*;

public class RepeatAndMissingNumber {
    public static void main(String[] args) {
        Integer[] Input = {3, 1, 2, 5, 3};
        System.out.println(repeatedNumber(Arrays.asList(Input)));
    }

    public static ArrayList<Integer> repeatedNumber2(final List<Integer> A) {
        Set<Integer> set = new HashSet<>();
        int a = 0, b, n = A.size();
        for (int i = 0; i < n; i++) {
            if(set.contains(A.get(i))) {
                a= A.get(i);
                break;
            } else {
                set.add(A.get(i));
            }
        }

        long sum = 0;
        for (int i = 0; i < n; i++) {
            sum += A.get(i);
        }

        long actualSum = (long) n * ((long)n + 1L) /2L;
        long diff = actualSum - sum;

        b =(int) (a + diff);
        ArrayList<Integer> nums =  new ArrayList<>();
        nums.add(a);
        nums.add(b);
        return nums;
    }

    public static ArrayList<Integer> repeatedNumber(final List<Integer> A) {
        int a = 0, b, n = A.size();
        long actualSum = 0;
        long actualSquareSum = 0;
        for (int i = 0; i < n; i++) {
            actualSum += A.get(i);
            actualSquareSum += (long) A.get(i) * (long) A.get(i);
        }
        
        long sum = (long) n * ((long) n + 1L) /2L;
        long squareSum = (long) n * ((long) n + 1) * (2L * (long) n + 1L) / 6L;

        long add = (actualSquareSum - squareSum) / (actualSum - sum);
        long diff = actualSum - sum;

        System.out.println("add = " + add);
        System.out.println("diff = " + diff);
        
        a = (int) (add + diff) / 2;
        b = (int) (add - a);

        ArrayList<Integer> nums =  new ArrayList<>();
        nums.add(a);
        nums.add(b);
        return nums;
    }
}
