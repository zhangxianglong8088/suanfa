package dp;

/**
 * 72. 编辑距离
 * 解题思路：https://leetcode.cn/problems/edit-distance/solution/shi-pin-jiang-jie-bian-ji-ju-chi-dong-tai-gui-hua-/
 *
 * @description：https://leetcode.cn/problems/edit-distance/
 * @author: zhangxianglong
 * @date: 2022/7/23
 */
public class MinDistanceI {

    public static int minDistance(String word1, String word2) {

        //定义dp[i][j] 表示 world1 中0-i的字符串变成 world2中的0-j的字符串需要经过的最小次数
        int n1 = word1.length();
        int n2 = word2.length();
        int[][] dp = new int[n1 + 1][n2 + 1];

        //初始化dp数组
        for (int i = 0; i <= n1; i++) {
            dp[i][0] = i;
        }

        for (int j = 0; j <= n2; j++) {
            dp[0][j] = j;
        }

        for (int i = 1; i <= n1; i++) {

            for (int j = 1; j <= n2; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = min(dp[i - 1][j - 1], dp[i][j - 1], dp[i - 1][j]) + 1;
                }
            }
        }

        return dp[n1][n2];

    }

    /**
     * 取三个数字的最小值
     *
     * @param n1
     * @param n2
     * @param n3
     * @return
     */
    static int min(int n1, int n2, int n3) {
        return Math.min(Math.min(n1, n2), n3);
    }

    public static void main(String[] args) {
        String word1 = "horse";
        String word2 = "ros";

        int res = editDistance(word1, word2);

        System.out.println(res);
    }

    public static int editDistance(String str1, String str2) {

        int n1 = str1.length();
        int n2 = str2.length();

        int[][] dp = new int[n1 + 1][n2 + 1];

        for (int i = 0; i <= n1; i++) {
            dp[i][0] = i;
        }


        for (int j = 0; j <= n2; j++) {
            dp[0][j] = j;
        }

        for (int i = 1; i <= n1; i++) {
            for (int j = 1; j <= n2; j++) {

                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j - 1], dp[i - 1][j]), dp[i][j - 1]) + 1;
                }

            }
        }
        return dp[n1][n2];

    }

}
