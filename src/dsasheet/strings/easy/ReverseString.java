package dsasheet.strings.easy;

public class ReverseString {
    public static void main(String[] args) {
        String str = "Hello World";
        System.out.println(reverseWord(str));
    }

    public static String reverseWord(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            sb.append(str.charAt(str.length()- 1-i));
        }
        return sb.toString();
    }
}
