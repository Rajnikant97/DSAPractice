package dsasheet.searchingandsorting.medium;

public class ProductOfArrayExceptItself {
    public static void main(String[] args) {
        int nums[] = {10, 3, 5, 6, 2};
        for(long x: productExceptSelf(nums, nums.length)) {
            System.out.print(x+" ");
        }
        System.out.println();
        for(long x: productExceptSelf2(nums, nums.length)) {
            System.out.print(x+" ");
        }
        System.out.println();
        for(long x: productExceptSelf3(nums, nums.length)) {
            System.out.print(x+" ");
        }
        System.out.println();
    }

    public static long[] productExceptSelf(int[] nums, int n) {
        long p = 1;
        long[] prod = new long[n];
        prod[n-1] = nums[n-1];
        for(int i=n-2;i>=0;i--) {
            prod[i] = prod[i+1] * nums[i];
        }
        for(int i=0;i<n-1;i++) {
            prod[i] = p * prod[i+1];
            p *= nums[i];
        }
        prod[n-1] = p;

        return prod;
    }

    public static long[] productExceptSelf2(int[] nums, int n) {
        long p = 1;
        long[] prod = new long[n];
        int countZero = 0;
        int indZero = 0;
        for(int i=0;i<n;i++) {

            if(nums[i] == 0) {
                countZero++;
                indZero = i;
            } else {
                p *= nums[i];
            }
        }
        if(countZero > 1){
            return prod;
        } else if(countZero == 1) {
            prod[indZero] = p;
            return prod;
        }

        for(int i=0;i<n;i++) {
            prod[i] = p / nums[i];
        }

        return prod;
    }

    public static int[] productExceptSelf3(int[] arr, int n) {
        int prod = 1;
        int zeroCount = 0;
        for(int i = 0; i<n; i++) {
            if(arr[i] != 0) {
                prod *= arr[i];
            } else {
                zeroCount++;
            }
        }
        if (zeroCount == 1) {
            for(int i = 0; i<n; i++) {
                if(arr[i] != 0) {
                    arr[i] = 0;
                } else {
                    arr[i] = prod;
                }
            }
        } else if(zeroCount > 1) {
            for(int i = 0; i<n; i++) {
                arr[i] = 0;
            }
        } else {
            for(int i = 0; i<n; i++) {
                arr[i] = prod / arr[i];
            }
        }
        return arr;
    }
}
