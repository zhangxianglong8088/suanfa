package dp;

/**
 * 01背包问题
 * https://labuladong.github.io/algo/3/25/80/
 * https://mp.weixin.qq.com/s/xmgK7SrTnFIM3Owpk-emmg
 * https://www.bilibili.com/video/BV1U5411s7d7?spm_id_from=333.337.search-card.all.click
 *
 * @description：
 * @author: zhangxianglong
 * @date: 2022/5/26
 */
public class Package {

    /**
     * N 表示物品的总数量
     * C C表示总容量
     * v  表示每一个物品的体积
     * W 表示每一个物品的价值
     *
     * @return
     */

    static int packagePro(int N, int C, int[] v, int[] w) {
        //定义DP数组 i 表示放第i个物品，背包容量为j时 最大价值
        int[][] dp = new int[N][C + 1];
        //初始化DP数组
        for (int i = 0; i <= C; i++) {
            dp[0][i] = i >= v[0] ? w[0] : 0;
        }

        //状态转移方程
        //1、遍历背包
        for (int i = 1; i < N; i++) {
            //2、遍历容积
            for (int j = 0; j < C + 1; j++) {
                //背包装不下i物品
                if (j < v[i]) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    //最大的
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - v[i]] + w[i]);
                }
            }
        }

        return dp[N - 1][C];
    }


    public static void main(String[] args) {

        int N = 3;

        int C = 5;

        //体积
        int[] v = new int[]{2, 1, 3};

        //价值
        int[] w = new int[]{4, 2, 3};

        System.out.println(packagePro(3, 5, v, w));

    }
}
