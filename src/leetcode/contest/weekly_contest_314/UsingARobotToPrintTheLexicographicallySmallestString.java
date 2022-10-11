package leetcode.contest.weekly_contest_314;

import java.util.Stack;

public class UsingARobotToPrintTheLexicographicallySmallestString {
    public static void main(String[] args) {
        String s = "zzassfddskladfadkjoirfjjssdh"; //aaaddhssjjfriojkfdlksddfsszz
        s = "bydizfve";//bdevfziy

        System.out.println(robotWithString(s));
    }

    public static String robotWithString(String s) {
        int n = s.length();
        char[] nextMin = new char[n];
        char min = s.charAt(n-1);
        for (int i = n-1; i >= 0; i--) {
            nextMin[i] = min;
            min = (char) Math.min(s.charAt(i), min);
        }

        int ind = 0;
        Stack<Character> stack = new Stack<>();
        StringBuilder ans = new StringBuilder();

        while (ind < n) {
            char next = s.charAt(ind);
            if(stack.isEmpty()) {
               stack.push(s.charAt(ind++));
               continue;
            }

            char top = stack.peek();

            if(top <= nextMin[ind] && top <= next) {
                ans.append(stack.pop());
            } else {
                stack.push(s.charAt(ind++));
            }
        }
        while (!stack.isEmpty()) {
            ans.append(stack.pop());
        }
        return ans.toString();
    }
}
