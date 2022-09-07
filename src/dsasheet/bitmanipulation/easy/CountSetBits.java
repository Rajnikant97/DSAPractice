package dsasheet.bitmanipulation.easy;

public class CountSetBits {

    public static void main(String[] args) {
        int n = 13;
        System.out.println(setBits(n));
        System.out.println(Integer.bitCount(n));
        System.out.println(countSetBitsBrianKernighanAlgorithm(n));
    }
    static int setBits(int n) {
        // code here
        int bitMask = 1;
        int count = 0;
        while(n > 0) {
            if((n & bitMask) != 0) {
                count++;
            }
            n >>= 1;
        }
        return count;
    }

    public static int countSetBitsBrianKernighanAlgorithm(int n) {
        int count = 0;
        while(n > 0) {
            n &= (n-1);
            count++;
        }
        return count;
    }
}
