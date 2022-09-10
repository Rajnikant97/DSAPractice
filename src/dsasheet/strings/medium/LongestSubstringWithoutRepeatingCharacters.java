package dsasheet.strings.medium;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {

    public static void main(String[] args) {
        String str = "abcdabc";
        System.out.println(lengthOfLongestSubstring(str));
    }

    public static int lengthOfLongestSubstring(String s) {
        int l = 0;
        int max = 0;
        Set<Character> set = new HashSet<>();
        for(int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);
            if(set.contains(curr)) {
                max = Math.max(max, i - l);
                for(int j = l; j < i; j++) {
                    if(s.charAt(j) == curr){
                        l = j+1;
                        break;
                    } else {
                        set.remove(s.charAt(j));
                    }
                }
            } else {
                set.add(curr);
            }
            // System.out.println(set);
        }
        // System.out.println("max="+max);
        max = Math.max(max, s.length() - l);
        return max;
    }
}
