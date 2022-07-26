package stack;

import java.util.Stack;

/**
 * @description：20. 有效的括号
 * https://leetcode.cn/problems/valid-parentheses/
 * @author: zhangxianglong
 * @date: 2022/5/23
 */
public class IsValid {
    /**
     * @param s
     * @return
     */
    public static boolean isValid(String s) {
        if (s.length() < 2) {
            return false;
        }
        Stack<Character> stack = new Stack<>();
        char[] characters = s.toCharArray();

        for (int i = 0; i < characters.length; i++) {
            char c = characters[i];
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
                continue;
            }

            if (c == ')' || c == '}' || c == ']') {
                if (stack.isEmpty()) {
                    return false;
                }
                if (c == ')' && stack.pop() != '(') {
                    return false;
                }
                if (c == '}' && stack.pop() != '{') {
                    return false;
                }
                if (c == ']' && stack.pop() != '[') {
                    return false;
                }
            }

        }
        if (!stack.isEmpty()) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "{[]}";

        System.out.println(isValid2(s));

    }

    public static boolean isValid2(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[') {
                stack.push(s.charAt(i));
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                Character tmp = stack.pop();
                if (tmp == '(' && s.charAt(i) != ')') {
                    return false;
                }
                if (tmp == '{' && s.charAt(i) != '}') {
                    return false;
                }
                if (tmp == '[' && s.charAt(i) != ']') {
                    return false;
                }
            }
        }

        if (stack.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }
}
