package dsasheet.arrays.medium;

import java.util.*;

public class LargestNumberFormedFromAnArray {
    public static void main(String[] args) {
        String str = "138 359 178 398 295 905 610 232 746 176 636 299 143 400 969 413 261 558 595 9 396 969 114 531 7 963 943 366 83";
        String[] arr = str.split(" ");

        System.out.println(printLargest(arr));

        for(String s : arr) {
            System.out.print(s+" ");
        }
        System.out.println();

        arr = new String[]{"9", "969","969"};
        System.out.println(printLargest(arr));

        for(String s : arr) {
            System.out.print(s+" ");
        }
        System.out.println();

        List<Integer> list  = Arrays.asList(138, 359, 178, 398, 295, 905);
        printLargest(list);
        System.out.println(list);
    }

    static String printLargest(String[] arr) {
        Arrays.sort(arr, (o1, o2) -> {
            String s1 = o1+o2;
            String s2 = o2+o1;
            return s2.compareTo(s1);
        });
        StringBuilder sb = new StringBuilder("");
        for(String s : arr) {
            sb.append(s);
        }
        return sb.toString();
    }

    // Given an array of numbers,
    // program to arrange the numbers
    // to form the largest number


    // The main function that prints
    // the arrangement with the
    // largest value. The function
    // accepts a vector of strings
    static void printLargest(List<Integer> arr) {

        // Sort the numbers using
        // library sort function. The
        // function uses our comparison
        // function myCompare() to
        // compare two strings.
        Collections.sort(arr, new Comparator<Integer>(){

            // A comparison function which
            // is used by sort() in
            // printLargest()
            @Override
            public int compare(Integer x, Integer y)
            {

                int xy = x;
                int yx = y;

                // Count length of x and y
                int countx = 0;
                int county = 0;

                // Count length of X
                while (x > 0) {
                    countx++;
                    x /= 10;
                }

                // Count length of Y
                while (y > 0) {
                    county++;
                    y /= 10;
                }

                x = xy;
                y = yx;

                while (countx > 0)
                {
                    countx--;
                    yx *= 10;
                }

                while (county > 0)
                {
                    county--;
                    xy *= 10;
                }

                // Append x to y
                yx += x;

                // Append y to x
                xy += y;

                return -xy + yx;
            }
        });
    }
}
