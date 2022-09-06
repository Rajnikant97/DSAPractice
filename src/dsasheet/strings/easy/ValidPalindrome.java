package dsasheet.strings.easy;

public class ValidPalindrome {

    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
//        s="race a car";
//        s="%$&";
        System.out.println(isPalindrome2(s));
    }

    public static boolean isPalindrome2(String s) {
        int l = 0;
        int r = s.length() - 1;
        while (l < r) {
            while(!Character.isLetterOrDigit(s.charAt(l))) {
                l++;
            }
            while(!Character.isLetterOrDigit(s.charAt(r))) {
                r--;
            }
            if(Character.toLowerCase(s.charAt(l)) != Character.toLowerCase(s.charAt(r))) {
                    return false;
            }
            l++;
            r--;
        }
        return true;
    }



    public static boolean isPalindrome(String s) {
        s = s.toLowerCase();
        int l = 0;
        int r = s.length() - 1;
        while (l < r) {
            char lch = s.charAt(l);
            char rch  = s.charAt(r);

            if(isAlphaNumeric(lch) && isAlphaNumeric(rch)) {
                if (lch != rch) {
                    return false;
                }
                l++;
                r--;
            }

            if(!isAlphaNumeric(lch)) {
                l++;
            }

            if(!isAlphaNumeric(rch)) {
                r--;
            }
        }
        return true;
    }

    public static boolean isAlphaNumeric(char ch) {
        return (ch >= 'a' && ch <= 'z') || (ch >= '0' && ch <= '9') || (ch >= 'A' && ch <= 'Z');
    }
}
