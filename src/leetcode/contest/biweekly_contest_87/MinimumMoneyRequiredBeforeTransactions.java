package leetcode.contest.biweekly_contest_87;

import java.util.Arrays;
import java.util.Comparator;

public class MinimumMoneyRequiredBeforeTransactions {

    public static void main(String[] args) {
        int[][] arr = {{3,9},{0,4},{7,10},{3,5},{0,9},{9,3},{7,4},{0,0},{3,3},{8,0}};
        MinimumMoneyRequiredBeforeTransactions m = new MinimumMoneyRequiredBeforeTransactions();

        System.out.println(m.minimumMoney(arr));
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i][0]+" "+arr[i][1] +" = "+(arr[i][1]-arr[i][0]) );
        }
    }

    public long minimumMoney2(int[][] transactions) {
        long moneyLose = 0;
        int maxCost = 0;
        for(int[] a : transactions) {
            if(a[0] > a[1]) {
                moneyLose += a[0]-a[1];
                maxCost = Math.max(maxCost, a[1]);
            } else {
                maxCost = Math.max(maxCost, a[0]);
            }
        }
        return moneyLose + maxCost;
    }

    public long minimumMoney(int[][] transactions) {
        long money = 0;
        long initialMoney = 0;
        sort(transactions);
        for(int i=0;i<transactions.length;i++) {
            int cost = transactions[i][0];
            int cashback = transactions[i][1];
            if(cost > money) {
                initialMoney += cost - money;
                money = 0;
            } else {
                money -= cost;
            }
            money  += cashback;
        }
        return initialMoney;
    }

    public void sort(int[][] arr) {
        Arrays.sort(arr, (e1, e2) -> {
            int profit1 = e1[1] - e1[0];
            int profit2 = e2[1] - e2[0];
            if(e1[0]==e2[0] && e1[1]==e2[1]){
                return 0;
            }
            if(profit1>=0 && profit2>=0){
                return e2[0]>e1[0] ? 1 : -1 ;
            } else if(profit1>=0) {
                return 1;
            } else if(profit2>=0){
                return -1;
            } else {
                return e2[1]<e1[1] ? 1 : -1;
            }
        });
    }
}
