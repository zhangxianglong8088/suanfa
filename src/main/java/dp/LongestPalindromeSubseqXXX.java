package dp;

/**
 * 516. 最长回文子序列
 * https://leetcode.cn/problems/longest-palindromic-subsequence/
 *
 * @description：
 * @author: zhangxianglong
 * @date: 2022/5/26
 */
public class LongestPalindromeSubseqXXX {


    public static int longestPalindromeSubseq1(String s) {
        //定义dp数组
        int n = s.length();
        //dp数组的含义 i到j之间回文字符串的长度
        int[][] dp = new int[n + 1][n + 1];
        for (int i = 0; i < n; i++) {
            //对角线上长度都是1
            dp[i][i] = 1;
        }

        //遍历dp数组 注意遍历顺序
        //遍历顺序是从尾部开始遍历，原因是
        // dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]) 需要先知道dp[i+1]的值才能推到出dp[i][j]的值

        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[0][n - 1];
    }


    public static void main(String[] args) {

        int len = longestPalindromeSubseq3("cbbd");

        System.out.println(len);
    }

    public static int longestPalindromeSubseq3(String s) {

        int n = s.length();

        int[][] dp = new int[n + 1][n + 1];

        for (int i = 0; i < n; i++) {

            dp[i][i] = 1;
        }

        for (int i = 1; i <= n; i++) {

            for (int j = 1; j < i; j++) {
                if (s.charAt(i - 1) == s.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j + 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[j + 1][i]);
                }
            }
        }

        int max = 1;
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                max = Math.max(dp[i][j], max);
            }
        }
        return max;

    }

}
