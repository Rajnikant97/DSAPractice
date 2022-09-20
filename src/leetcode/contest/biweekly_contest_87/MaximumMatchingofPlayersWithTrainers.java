package leetcode.contest.biweekly_contest_87;

import java.util.Arrays;

public class MaximumMatchingofPlayersWithTrainers {
    public static void main(String[] args) {
        MaximumMatchingofPlayersWithTrainers m = new MaximumMatchingofPlayersWithTrainers();
        int[] players = {4,7,9};
        int[]trainers = {8,2,5,8};
        System.out.println(m.matchPlayersAndTrainers(players, trainers));
    }

    public int matchPlayersAndTrainers(int[] players, int[] trainers) {
        int i = 0, j=0, count=0;
        Arrays.sort(players);
        Arrays.sort(trainers);
        while(i<players.length && j<trainers.length) {
            if(players[i] <= trainers[j]) {
                count++;
                i++;
                j++;
            } else {
                j++;
            }
        }
        return count;
    }
}
