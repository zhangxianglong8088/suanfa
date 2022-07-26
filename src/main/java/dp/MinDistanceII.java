package dp;

/**
 * 72. 编辑距离
 *
 * @description：https://leetcode.cn/problems/edit-distance/
 * @author: zhangxianglong
 * @date: 2022/7/23
 */
public class MinDistanceII {

    /**
     * min edit cost
     *
     * @param ic int整型 insert cost
     * @param dc int整型 delete cost
     * @param rc int整型 replace cost
     * @return int整型
     */
    public static int minEditCost(String word1, String word2, int ic, int dc, int rc) {

        //定义dp[i][j] 表示 world1 中0-i的字符串变成 world2中的0-j的字符串需要经过的最小次数
        int n1 = word1.length();
        int n2 = word2.length();
        int[][] dp = new int[n1 + 1][n2 + 1];

        //初始化dp数组
        for (int i = 0; i <= n1; i++) {
            //这个表示 字符串1 经过i次删除可以变成空字符串
            dp[i][0] = i * dc;
        }

        for (int j = 0; j <= n2; j++) {
            //这个表示 字符串2经多多次的添加可以变成第二个字符串
            dp[0][j] = j * ic;
        }

        for (int i = 1; i <= n1; i++) {

            for (int j = 1; j <= n2; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    //从上到下是 delete  从左到右 inset  左上角过来是replace
                    dp[i][j] = Math.min(dp[i][j - 1] + ic, dp[i - 1][j] + dc);
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][j - 1] + rc);
                }
            }
        }

        return dp[n1][n2];

    }

    public static void main(String[] args) {
        String word1 = "horse";
        String word2 = "ros";

        int res = minEditCost(word1, word2, 5, 3, 2);

        System.out.println(res);
    }
}
