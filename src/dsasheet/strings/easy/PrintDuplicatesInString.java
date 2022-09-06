package dsasheet.strings.easy;

import java.util.HashMap;
import java.util.Map;

public class PrintDuplicatesInString {
    public static void main(String[] args) {
        String str = "thisisteststring";
        print2(str);
        print(str);
    }

    public static void print(String s) {
        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i)-'a']++;
        }

        for (int i = 0; i < 26; i++) {
            if(count[i] > 1){
                System.out.println((char)(i + 'a') + ", count = " + count[i]);
            }
        }
    }

    public static void print2(String s){
        Map<Character, Integer> count = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(count.containsKey(ch)) {
                count.replace(ch, count.get(ch) + 1);
            } else {
                count.put(ch, 1);
            }
        }

        for (Map.Entry<Character,Integer> e : count.entrySet()) {
            if(e.getValue() > 1) {
                System.out.println(e.getKey() + ", count = " + e.getValue());
            }
        }
    }
}
