package geeksforgeeks.contests.weekly_interview_series_70;

public class PrefixSuffixString {
    public static void main(String[] args) {
        String[] s1 = {"cat", "catanddog", "lion"};
        String[] s2 = {"cat", "dog", "rat"};

        System.out.println(prefixSuffixString(s1, s2));
    }
    public static int prefixSuffixString(String s1[],String s2[]) {
        int count = 0;
        for(String str2 : s2) {
            for(String str1 : s1) {
                if(str1.contains(str2)) {
                    count++;
                    break;
                }
            }
        }
        return count;
    }
}
