package dsasheet.strings.easy;

import java.io.PrintStream;

public class MobileKeypadSequence {
    public static void main(String[] args) {
        String S = "HEY U";
        System.out.println(printSequence(S));
    }

    public static String printSequence(String S) {
        String[] key = {
                "2","22","222",
                "3","33","333",
                "4","44","444",
                "5","55","555",
                "6","66","666",
                "7","77","777","7777",
                "8","88","888",
                "9","99","999","9999"
        };
        StringBuilder seq =new StringBuilder();
        for (int i = 0; i < S.length(); i++) {
            if(S.charAt(i) == ' '){
                seq.append("0");
            } else {
                seq.append(key[S.charAt(i) - 'A']);
            }
        }
        return seq.toString();
    }
}
