package dsasheet.strings.medium;

import java.util.*;

public class GroupAnagrams {
    public static void main(String[] args) {
        String[] strs = {"eat","tea","tan","ate","","nat","bat",""};

//        strs = new String[] {"","",""};
        System.out.println(groupAnagrams2(strs));
    }

    public static List<List<String>> groupAnagrams2(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (int i = 0; i < strs.length; i++) {
            String count = String.valueOf(getCount(strs[i]));
            if(!map.containsKey(count)) {
                map.put(count, new ArrayList<>());
            }
            map.get(count).add(strs[i]);
        }
        return new ArrayList<>(map.values());
    }

    public static char[] getCount(String str) {
        char[] count = new char[26];
        for (int i = 0; i < str.length(); i++) {
            count[str.charAt(i) - 'a']++;
        }
        return count;
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> list = new ArrayList<>();
        for (int i = 0; i < strs.length; i++) {
            String str1 = strs[i];
            if(str1.equals("_")) {
                continue;
            }
            List<String> group = new ArrayList<>();
            group.add(str1);
            for (int j = i+1; j < strs.length; j++) {
                String str2 = strs[j];
                if(str2.equals("_")) {
                    continue;
                }
                if(isAnagram(str1, str2)) {
                    group.add(str2);
                    strs[j] = "_";
                }
            }
            list.add(group);
        }
        return list;
    }

    public static boolean isAnagram(String s1, String s2) {
        if(s1.length() != s2.length()) {
            return false;
        }

        int[] c1 = new int[26];
        int[] c2 = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            c1[s1.charAt(i) - 'a']++;
        }
        for (int i = 0; i < s2.length(); i++) {
            c2[s2.charAt(i) - 'a']++;
        }

        for (int i = 0; i < 26; i++) {
            if(c1[i] != c2[i]) {
                return false;
            }
        }
        return true;
    }
}
