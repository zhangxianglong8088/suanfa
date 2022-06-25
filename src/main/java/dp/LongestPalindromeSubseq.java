package dp;

/**
 * 516. 最长回文子序列
 * https://leetcode.cn/problems/longest-palindromic-subsequence/
 *
 * @description：
 * @author: zhangxianglong
 * @date: 2022/5/26
 */
public class LongestPalindromeSubseq {

    public static int longestPalindromeSubseq(String s) {
        int len = s.length();
        //定义dp数组 dp[i][j]  i和j区间内的最大回文子序列长度
        int[][] dp = new int[len + 1][len + 1];

        //遍历dp数组
        for (int i = len - 1; i >= 0; i--) {
            //当i和j相同的时候 长度为1
            dp[i][i] = 1;
            for (int j = i + 1; j < len; j++) {

                if (s.charAt(i) == s.charAt(j)) {
                    //如果 i和j的值相同
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    //如果 i和j的值不相同 选择将i加入或者将j加入 取最大值
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[0][len - 1];
    }

    public static void main(String[] args) {

        int len = longestPalindromeSubseq("bbbab");

        System.out.println(len);
    }
}
