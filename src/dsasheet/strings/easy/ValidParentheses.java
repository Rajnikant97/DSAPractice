package dsasheet.strings.easy;

import java.util.Stack;

public class ValidParentheses {

    public static void main(String[] args) {
        String s = "[]{}()";
        System.out.println(isValid(s));
    }
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            } else {
                if(stack.empty()) {
                    return false;
                } else {
                    char top = stack.pop();
                    if (top == '(' && ch == ')') {

                    } else if (top == '{' && ch == '}') {

                    } else if (top == '[' && ch == ']') {

                    } else {
                        return false;
                    }
                }
            }
        }
        return stack.empty();
    }
}
