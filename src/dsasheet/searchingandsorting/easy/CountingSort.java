package dsasheet.searchingandsorting.easy;

public class CountingSort {
    public static void main(String[] args) {
        String str = "edsab";
        System.out.println(countSort(str));
        System.out.println(countSort2(str));
    }

    public static String countSort(String arr) {
        int[] count = new int[26];
        for(int i=0;i<arr.length();i++) {
            count[arr.charAt(i)-'a']++;
        }
        for(int i=1;i<count.length;i++) {
            count[i] += count[i-1];
        }
        for(int i = count.length-1;i>0;i--) {
            count[i]=count[i-1];

        }
        count[0]=0;

        char[] ans = new char[arr.length()];
        for(int i=0;i<arr.length();i++) {
            int ind = count[arr.charAt(i)-'a']++;
            ans[ind] = arr.charAt(i);
        }
        return String.valueOf(ans);
    }

    public static String countSort2(String arr) {
        int[] count = new int[26];
        for(int i=0;i<arr.length();i++){
            count[arr.charAt(i)-'a']++;
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<26;i++){
            int c = count[i];
            while(c-->0) {
                sb.append((char)(i+'a'));
            }
        }
        return sb.toString();
    }
}
