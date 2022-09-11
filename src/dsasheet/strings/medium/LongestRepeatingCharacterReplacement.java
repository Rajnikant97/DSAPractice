package dsasheet.strings.medium;

public class LongestRepeatingCharacterReplacement {
    public static void main(String[] args) {
        String str = "AABABBA";
        int k = 1;
        System.out.println(characterReplacement2(str, k));
    }

    public static int characterReplacement(String s, int k) {
        int start = 0;
        int end = 0;
        int n = s.length();
        int[] freq = new int[26];
        int maxFreq = 0;
        int maxLength = 0;
        while (start < n && end < n) {
            maxFreq = Math.max(maxFreq, ++freq[s.charAt(end) - 'A']);
            int currLength = end - start + 1;
            if((currLength - maxFreq) > k) {
                freq[s.charAt(start) - 'A']--;
                start++;
            }
            maxLength = Math.max(maxLength, end-start+1);
            end++;
        }
        return maxLength;
    }

    public static int characterReplacement2(String s, int k) {
        int maxLength = 0;

        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                if(isPossible(i, j, s, k)) {
                    maxLength = Math.max(maxLength, j - i + 1);
                }
            }
        }
        return maxLength;
    }

    public static boolean isPossible(int s, int e, String str, int count) {
        int[] freq = new int[26];
        int maxFreq = 0;
        for (int i = s; i <= e; i++) {
            freq[str.charAt(i) - 'A']++;
        }
        for (int i = 0; i < 26; i++) {
            maxFreq = Math.max(maxFreq, freq[i]);
        }
        return (e - s + 1 - maxFreq) <= count;
    }
}