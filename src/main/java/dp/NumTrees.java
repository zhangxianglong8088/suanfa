package dp;

/**
 * @description：
 * @author: zhangxianglong
 * @date: 2022/6/16
 */
public class NumTrees {

    public static int numTrees(int n) {
        //定义DP数组 dp[i] 表示 1到i个元素构成查找树的个数
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[0] = 1;
        //递推公式 dp[i] =

        for (int i = 2; i < n + 1; i++) {
            for (int j = 1; j < i + 1; j++) {
                dp[i] += dp[j - 1] * dp[i - j];
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        int res = numTrees(3);
        System.out.println(res);
    }
}
