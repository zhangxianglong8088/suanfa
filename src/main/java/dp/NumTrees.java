package dp;

/**
 * 96. 不同的二叉搜索树
 *
 * @description：不同的二叉搜索树 https://leetcode.cn/problems/unique-binary-search-trees/
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
        /**
         * 以j为头结点的树个数
         * dp[j - 1] * dp[i - j];
         * j不断增加，累加每一个j为头结点的搜索树个数
         */
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
