package leetcode.contest.weekly_contest_312;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NumberOfGoodPaths {
    public static void main(String[] args) {
        int[] vals = {1,1,2,2,3};
        int[][] edges = {
                {0,1},
                {1,2},
                {2,3},
                {2,4}
        };

        vals = new int[]{2,5,5,1,5,2,3,5,1,5};
        edges = new int[][]{
{0,1},{2,1},{3,2},{3,4},{3,5},{5,6},{1,7},{8,4},{9,7}
        };
        System.out.println(numberOfGoodPaths(vals, edges));
    }

    static int count = 0;
    static Set<Integer> set;
    static Set<Integer> tempSet;
    public static int numberOfGoodPaths(int[] vals, int[][] edges) {
        int n = vals.length;
        count = 0;
        List<Integer>[] tree = new List[n];
        set = new HashSet<>();

        for (int i = 0; i < n; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            int to = edge[0];
            int from = edge[1];
            tree[to].add(from);
            tree[from].add(to);
        }

//        for (int i = 0; i < n; i++) {
//            System.out.println(i+"->"+tree[i]+", val="+vals[i]);
//        }

        for (int i = 0; i < n; i++) {
            if (set.contains(i)){
                continue;
            }
            tempSet = new HashSet<>();
            dfs(tree, i, vals, i, new boolean[n]);
            count += (tempSet.size() * (tempSet.size()+1)) / 2;
            set.addAll(tempSet);
        }

        return count;
    }

    public static void dfs(List<Integer>[] tree, int curr, int[] vals, int targetNode, boolean[] is) {
        if(vals[curr] > vals[targetNode]) {
            return;
        }

        if(vals[curr] == vals[targetNode]) {
//            System.out.println(targetNode+" -> "+curr);
            tempSet.add(curr);
        }

        is[curr] = true;

        for(int next : tree[curr]) {
            if(is[next])continue;

            dfs(tree, next, vals, targetNode, is);
        }
    }
}
