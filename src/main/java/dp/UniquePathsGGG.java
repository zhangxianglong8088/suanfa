package dp;

/**
 * 62. 不同路径
 * 题解思路：https://programmercarl.com/0062.%E4%B8%8D%E5%90%8C%E8%B7%AF%E5%BE%84.html#%E6%80%9D%E8%B7%AF
 * dp[i][j] ：表示从（0 ，0）出发，到(i, j) 有dp[i][j]条不同的路径。
 * 想要求dp[i][j]，只能有两个方向来推导出来，即dp[i - 1][j] 和 dp[i][j - 1]。
 * <p>
 * 此时在回顾一下 dp[i - 1][j] 表示啥，是从(0, 0)的位置到(i - 1, j)有几条路径，dp[i][j - 1]同理。
 * <p>
 * 那么很自然，dp[i][j] = dp[i - 1][j] + dp[i][j - 1]，因为dp[i][j]只有这两个方向过来。
 *
 * @description： https://leetcode.cn/problems/unique-paths/
 * @author: zhangxianglong
 * @date: 2022/5/26
 */
public class UniquePathsGGG {

    public static int uniquePaths(int m, int n) {
        //定义dp数组
        int[][] dp = new int[m][n];
        //初始化dp数组
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }

        for (int j = 0; j < n; j++) {
            dp[0][j] = 1;
        }

        //确定递推公式 dp[i][j] = dp[i][j-1]+dp[i-1][j]

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }

        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {
        int n = uniquePaths(3, 7);
        System.out.println(n);
    }
}
