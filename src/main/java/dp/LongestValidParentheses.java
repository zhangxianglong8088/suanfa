package dp;

/**
 * 32. 最长有效括号
 *
 * @description：https://leetcode.cn/problems/longest-valid-parentheses/
 * @author: zhangxianglong
 * @date: 2022/7/10
 */
public class LongestValidParentheses {

    public static int longestValidParentheses(String s) {
        //距离case ：".....|( ( ) ( ) )"
        //分两种情况 1、整个字符串 的结尾是"()"
        //          2、字符串 ........) )
        int maxans = 0;
        int[] dp = new int[s.length()];
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {
                    dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
                } else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {

                    dp[i] = dp[i - 1] + ((i - dp[i - 1]) >= 2 ? dp[i - dp[i - 1] - 2] : 0) + 2;
                }
                maxans = Math.max(maxans, dp[i]);
            }
        }
        return maxans;
    }

    public static void main(String[] args) {
        String s = ")()())";

        int res = longestValidParentheses(s);

        System.out.println(res);


    }
}
