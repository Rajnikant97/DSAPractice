package dsasheet.strings.medium;

public class CountPalindromicSubstring {
    public static void main(String[] args) {
        String s = "aabba";
        System.out.println(countSubstrings(s));
    }

    public static int countSubstrings(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            count += countAroundI(s, i, i);
            count += countAroundI(s, i, i+1);
        }
        return count;
    }

    public static int countAroundI(String str, int start, int end) {
        int count = 0;
        while (start >=0 && end < str.length()) {
            if(str.charAt(start) != str.charAt(end)) {
                break;
            }
            count++;
            start--;
            end++;
        }
        return count;
    }

    public static int longestPalindrome3(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];
        int count = 0;
        for (int col = 0; col < s.length(); col++) {
            int start = 0;
            int end = 0;
            for (int i = 0, j = col; j < s.length() && i < s.length() ; i++, j++) {
                if(i == j) {
                    dp[i][j] = true;
                } else if((i+1) == j) {
                    dp[i][j] = s.charAt(i) == s.charAt(j);
                } else {
                    dp[i][j] = dp[i+1][j-1] && s.charAt(i) == s.charAt(j);
                }
                if(dp[i][j]) {
                    count++;
                }
            }
        }
        return count;
    }
}
