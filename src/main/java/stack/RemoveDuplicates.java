package stack;

import java.util.Stack;

/**
 * https://leetcode.cn/problems/remove-all-adjacent-duplicates-in-string/
 *
 * @description：1047. 删除字符串中的所有相邻重复项
 * @author: zhangxianglong
 * @date: 2022/6/4
 */
public class RemoveDuplicates {

    public static String removeDuplicates(String s) {

        char[] c = s.toCharArray();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < c.length; i++) {
            if (stack.isEmpty()) {
                stack.add(c[i]);
            } else {
                char res = stack.peek();
                if (res == c[i]) {
                    stack.pop();
                } else {
                    stack.add(c[i]);
                }
            }
        }

        StringBuilder ss = new StringBuilder();
        for (char st : stack) {
            ss.append(st);
        }
        return ss.toString();

    }

    public static void main(String[] args) {
        String s = "abbaca";
        System.out.println(removeDuplicates(s));
    }
}
