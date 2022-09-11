package dsasheet.strings.medium;

public class LongestPalindromicSubstring {
    public static void main(String[] args) {
        String str = "baaaabc";
        System.out.println(longestPalindrome(str));
    }

    public static String longestPalindrome(String s) {
        int ansStart = 0;
        int ansEnd = 0;
        for (int i = 0; i < s.length(); i++) {
            int[] pair = expandPalindrome(s, i, i);
            if((ansEnd-ansStart)<(pair[1]-pair[0])) {
                ansStart = pair[0];
                ansEnd = pair[1];
            }

            pair = expandPalindrome(s, i, i+1);
            if((ansEnd-ansStart)<(pair[1]-pair[0])) {
                ansStart = pair[0];
                ansEnd = pair[1];
            }
        }
        return s.substring(ansStart + 1, ansEnd);
    }

    public static int[] expandPalindrome(String str, int start, int end) {
        while(start>=0 && end<str.length()) {
            if(str.charAt(start) != str.charAt(end)) {
                break;
            }
            start--;
            end++;
        }
        return new int[]{start, end};
    }

    public static String longestPalindrome2(String s) {
        int ansStart = 0;
        int ansEnd = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                if(isPalindrome(s, i, j) && (j-i) > (ansEnd-ansStart)) {
                    ansStart = i;
                    ansEnd = j;
                }
            }
        }
        return s.substring(ansStart, ansEnd+1);
    }

    public static boolean isPalindrome(String str, int s, int e) {
        while(s<e) {
            if(str.charAt(s) != str.charAt(e)) {
                return false;
            }
            s++;
            e--;
        }
        return true;
    }

    public static String longestPalindrome3(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];
        int ansStart = 0;
        int ansEnd = 0;
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
                    start = i;
                    end = j;
                }
            }
            if((ansEnd-ansStart) < (end-start)) {
                ansStart = start;
                ansEnd = end;
            }
        }
        return s.substring(ansStart, ansEnd + 1);
    }
}
