package dsasheet.bitmanipulation.easy;

public class PositionOfSetBit {
    public static void main(String[] args) {
        System.out.println(findPosition(16));
        System.out.println(findPosition(12));
        System.out.println(1 + Math.log(16) / Math.log(2));

    }

    static int findPosition(int N) {
        if(N == 0) return -1;
        if((N & (N-1)) != 0) return -1;
        int count = 0;
        while(N > 0) {
            N >>= 1;
            count++;
        }
        return count;
    }
}
