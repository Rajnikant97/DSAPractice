package dsasheet.arrays.medium;

public class TrappingRainWater {
    public static void main(String[] args) {
        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(trap(height));
        System.out.println(trap2(height));
    }

    public static int trap(int[] height) {
        int l = 0;
        int r = height.length - 1;
        int lMax = height[0];
        int rMax = height[r];
        int trap = 0;

        while (l <= r) {
            if (lMax < rMax) {
                lMax = Math.max(lMax, height[l]);
                trap += lMax - height[l];
                l++;
            } else {
                rMax = Math.max(rMax, height[r]);
                trap += rMax - height[r];
                r--;
            }
        }
        return trap;
    }

    public static int trap2(int[] height) {
        int n = height.length;
        int[] lMax = new int[n];
        int[] rMax = new int[n];
        int trap = 0;

        lMax[0] = height[0];
        for (int i = 1; i < n; i++) {
            lMax[i] = Math.max(lMax[i - 1], height[i]);
        }

        rMax[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rMax[i] = Math.max(rMax[i + 1], height[i]);
        }

        for (int i = 0; i < n; i++) {
            int water = Math.min(lMax[i], rMax[i]) - height[i];
            trap += Math.max(water, 0);
        }
        return trap;
    }
}