package dsasheet.strings.easy;

public class RemoveConsecutiveCharacters {
    public static void main(String[] args) {
        String s = "aaaaabbbbbaaaba";
        System.out.println(remove3(s));
    }

    public static String remove(String str) {
        StringBuilder sb = new StringBuilder(str);
        for (int i = 1; i < sb.length(); i++) {
            if(sb.charAt(i) == sb.charAt(i-1)) {
                sb.deleteCharAt(i);
                i--;
            }
        }
        return sb.toString();
    }

    public static String remove2(String str) {
        StringBuilder sb = new StringBuilder(str);
        int ind = 1;
        while (ind < sb.length()) {
            if(sb.charAt(ind) == sb.charAt(ind-1)) {
                sb.deleteCharAt(ind);
            } else {
                ind++;
            }
        }
        return sb.toString();
    }

    public static String remove3(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(str.charAt(0));
        for (int i = 1; i < str.length(); i++) {
            if(str.charAt(i) != str.charAt(i-1)) {
                sb.append(str.charAt(i));
            }
        }
        return sb.toString();
    }
}
