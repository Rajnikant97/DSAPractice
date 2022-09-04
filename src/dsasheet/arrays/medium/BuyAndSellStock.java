package dsasheet.arrays.medium;

public class BuyAndSellStock {
    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
        System.out.println(maxProfit(prices));
    }

    public static int maxProfit(int[] prices) {
        int maxProfit = 0;
        int minBuyPrice = prices[0];
        for (int i = 0; i < prices.length; i++) {
            if(prices[i] > minBuyPrice) {
                maxProfit = Math.max(maxProfit, prices[i] - minBuyPrice);
            } else {
                minBuyPrice = prices[i];
            }
        }
        return maxProfit;
    }
}
