package dsasheet.arrays.medium;

public class FindPairWithSumInSortedAndRotatedArray {
    public static void main(String[] args) {
        int[] arr = {11,15,6,8,9,10};
        int sum = 16;
        System.out.println(findPairWithSum(arr,sum));

        arr = new int[]{11, 15, 26, 38, 9, 10};
        sum = 35;
        System.out.println(findPairWithSum(arr,sum));

        arr = new int[]{11, 15, 26, 38, 9, 10};
        sum = 45;
        System.out.println(findPairWithSum(arr,sum));
    }

    public static boolean findPairWithSum(int[] arr, int sum) {
        int n = arr.length;
        int l = 0;
        int r = arr.length;
        for (int i = 0; i < n-1; i++) {
            if(arr[i] > arr[i+1]) {
                l = i+1;
                r =i;
                break;
            }
        }
        while(l!=r) {
            int x = arr[l] + arr[r];
            if(x == sum) {
                return true;
            } else if(x < sum) {
                l = (l+1)%n;
            } else {
                r = (n+r-1)%n;
            }
        }
        return false;
    }
}
