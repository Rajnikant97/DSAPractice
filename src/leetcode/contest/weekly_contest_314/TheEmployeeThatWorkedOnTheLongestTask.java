package leetcode.contest.weekly_contest_314;

public class TheEmployeeThatWorkedOnTheLongestTask {
    public static void main(String[] args) {
        int[][] arr = {
                {0,3},
                {2,5},
                {0,9},
                {1,15}
        };
        int n = 10;
        System.out.println(hardestWorker(n, arr));
    }

    public static int hardestWorker(int n, int[][] logs) {
        int maxTime = logs[0][1];
        int id = logs[0][0];
        for (int i = 1; i < logs.length; i++) {
            int currTime = logs[i][1] - logs[i-1][1];
            if(currTime > maxTime) {
                maxTime = currTime;
                id = logs[i][0];
            } else if(currTime == maxTime) {
                id = Math.min(logs[i][0], id);
            }
        }
        return id;
    }
}
