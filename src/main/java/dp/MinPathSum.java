package dp;

/**
 * @description：64. 最小路径和
 * https://leetcode.cn/problems/minimum-path-sum/
 * @author: zhangxianglong
 * @date: 2022/5/26
 */
public class MinPathSum {

    public static int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        //定义dp数组 表示 到 i，j位置的和
        int rows = grid.length;
        int columns = grid[0].length;


        int[][] dp = new int[rows][columns];

        //初始化dp数组
        dp[0][0] = grid[0][0];

        for (int i = 1; i < rows; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }

        for (int j = 1; j < columns; j++) {
            dp[0][j] = dp[0][j - 1] + grid[0][j];
        }


        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < columns; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }

        return dp[rows - 1][columns - 1];
    }

    public static void main(String[] args) {

        int[][] nums = new int[][]{{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};

        int res = minPathSum(nums);
        System.out.println(res);
    }
}
