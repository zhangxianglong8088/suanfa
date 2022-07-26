package dp;

/**
 * 221. 最大正方形
 *
 * @description：https://leetcode.cn/problems/maximal-square/
 * @author: zhangxianglong
 * https://leetcode.cn/problems/maximal-square/solution/li-jie-san-zhe-qu-zui-xiao-1-by-lzhlyle/
 * @date: 2022/7/22
 */
public class MaximalSquare {

    public int maximalSquare(char[][] matrix) {

        int maxSquare = 0;

        //特殊判断
        if (matrix == null || matrix.length < 1 || matrix[0].length < 1) {
            return maxSquare;
        }

        int rows = matrix.length;
        int columns = matrix[0].length;

        //定义dp数组 数组含义：表示以 i，j为右下角的最大正方形的边长
        int[][] dp = new int[rows][columns];


        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (matrix[i][j] == '1') {
                    if (i == 0 || j == 0) {
                        dp[i][j] = 1;
                    } else {
                        //体会这里为什么是 这三个的最小值，而不是最大值
                        //如果是 1，那么需要保证它的左，左上，上这三个地方都是 1，才能拓展最大正方形，对应 dp 就是取最小值
                        dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i - 1][j - 1]), dp[i][j - 1]) + 1;
                    }
                    maxSquare = Math.max(maxSquare, dp[i][j]);
                }

            }
        }
        return maxSquare * maxSquare;
    }

    /**
     * 自己的理解
     *
     * @param matrix
     * @return
     */
    public static int solve(char[][] matrix) {
        int max = 0;

        int rows = matrix.length;
        int colums = matrix[0].length;
        //表示 以 i ，j 为右下角的最大正方形的边长
        int[][] dp = new int[rows][colums];

        for (int i = 0; i < rows; i++) {
            if (matrix[i][0] == '1') {
                dp[i][0] = 1;
            }
        }

        for (int j = 0; j < colums; j++) {
            if (matrix[0][j] == '1') {
                dp[0][j] = 1;
            }
        }

        for (int i = 1; i < rows; i++) {

            for (int j = 1; j < colums; j++) {
                if (matrix[i][j] == '1') {
                    dp[i][j] = Math.min(Math.min(dp[i][j - 1], dp[i - 1][j - 1]), dp[i - 1][j]) + 1;

                    max = Math.max(max, dp[i][j]);
                }
            }
        }

        return max * max;

    }

    public static void main(String[] args) {
        char[][] s = new char[][]{{'1', '0', '1', '0', '0'}, {'1', '0', '1', '1', '1'}, {'1', '1', '1', '1', '1'}, {'1', '0', '0', '1', '0'}};

        int res = solve(s);

        System.out.println(res);
    }
}
