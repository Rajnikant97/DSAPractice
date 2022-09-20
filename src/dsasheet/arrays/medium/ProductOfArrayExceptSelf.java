package dsasheet.arrays.medium;

public class ProductOfArrayExceptSelf {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4};
        for(int x:productExceptSelf(arr)){
            System.out.print(x+" ");
        }
        System.out.println();

        for(long x:productExceptSelf2(arr)){
            System.out.print(x+" ");
        }
        System.out.println();

        for(long x:productExceptSelf3(arr)){
            System.out.print(x+" ");
        }
        System.out.println();
    }

    public static int[] productExceptSelf(int[] arr) {
        int prod = 1;
        int n = arr.length;
        int[] prr = new int[n];
        prr[n-1]=arr[n-1];
        for(int i=n-2;i>=0;i--) {
            prr[i] = arr[i] * prr[i+1];
        }

        for(int i = 0; i<n-1; i++) {

            prr[i] = prod * prr[i+1];
            prod *= arr[i];
        }
        prr[n-1] = prod;
        return prr;
    }

    public static long[] productExceptSelf2(int[] nums) {
        long p = 1;
        int n = nums.length;
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

    public static int[] productExceptSelf3(int[] arr) {
        int prod = 1;
        int n = arr.length;
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
