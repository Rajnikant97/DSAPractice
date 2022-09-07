package dsasheet.bitmanipulation.easy;

public class PowerOfTwo {

    public static void main(String[] args) {
        System.out.println(isPowerOfTwo(16));
        System.out.println(isPowerOfTwo2(16));
        System.out.println(isPowerOfTwo3(16));

    }

    public static boolean isPowerOfTwo(long n){
        while(n > 0) {
            if((n & 1) == 1) {
                return n == 1;
            }
            n >>= 1;
        }
        return false;
    }

    public static boolean isPowerOfTwo2(long n){
        if(n == 0) return false;
        while(n != 1) {
            if(n % 2 == 1) {
                return false;
            }
            n = n / 2;
        }
        return true;
    }

    public static boolean isPowerOfTwo3(long n){
        if(n == 0) return false;
        return n == (n & -n);
    }
}
