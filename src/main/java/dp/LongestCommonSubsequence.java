package dp;

/**
 * 1143. 最长公共子序列
 * https://programmercarl.com/1143.%E6%9C%80%E9%95%BF%E5%85%AC%E5%85%B1%E5%AD%90%E5%BA%8F%E5%88%97.html#_1143-%E6%9C%80%E9%95%BF%E5%85%AC%E5%85%B1%E5%AD%90%E5%BA%8F%E5%88%97
 * 解题思路；
 * 主要就是两大情况： text1[i - 1] 与 text2[j - 1]相同，text1[i - 1] 与 text2[j - 1]不相同
 * <p>
 * 如果text1[i - 1] 与 text2[j - 1]相同，那么找到了一个公共元素，所以dp[i][j] = dp[i - 1][j - 1] + 1;
 * <p>
 * 如果text1[i - 1] 与 text2[j - 1]不相同，那就看看text1[0, i - 2]与text2[0, j - 1]的最长公共子序列 和 text1[0, i - 1]与text2[0, j - 2]的最长公共子序列，取最大的。
 * <p>
 * 即：dp[i][j] = max(dp[i - 1][j], dp[i][j - 1]);
 *
 * @description：https://leetcode.cn/problems/longest-common-subsequence/
 * @author: zhangxianglong
 * @date: 2022/5/26
 */
public class LongestCommonSubsequence {
    public static void main(String[] args) {
        String text1 = "abcde";
        String text2 = "ace";
        int res = longestCommonSubsequence(text1, text2);
        System.out.println(res);

    }

    public static int longestCommonSubsequence(String text1, String text2) {

        //定义dp数组
        int[][] dp = new int[text1.length() + 1][text2.length() + 1];

        //遍历dp数组
        for (int i = 1; i <= text1.length(); i++) {
            char c1 = text1.charAt(i - 1);
            for (int j = 1; j < text2.length(); j++) {
                char c2 = text2.charAt(j - 1);
                if (c1 == c2) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }

            }
        }
        return dp[text1.length()][text2.length()];
    }
}
