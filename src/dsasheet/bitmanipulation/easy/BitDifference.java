package dsasheet.bitmanipulation.easy;

public class BitDifference {

    public static void main(String[] args) {
        System.out.println(countBitsFlip(10, 20));
    }

    public static int countBitsFlip(int a, int b){
        int count = 0;
        while(a>0 || b>0) {
            if((a&1) != (b&1)){
                count++;
            }
            a >>= 1;
            b >>= 1;
        }
        return count;
    }
}
