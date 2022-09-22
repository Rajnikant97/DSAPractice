package dsasheet.arrays.medium;

public class ContainerWithMostWater {

    public static void main(String[] args) {
        int[] height = {1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(height));//49
    }
    public static int maxArea(int[] arr) {
        int n = arr.length;
        int l = 0;
        int r = n-1;
        int max = 0;
        while(l<r){
            int vol = (r-l) * Math.min(arr[l], arr[r]);
            max = Math.max(max, vol);
            if(arr[l]<arr[r]){
                l++;
            } else {
                r--;
            }
        }
        return max;
    }
}
