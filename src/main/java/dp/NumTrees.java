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
         /*
        dp五部曲:
        1.状态定义:dp[i]为当有i个节点时,一共可以组成的二叉搜索树数目
        2.状态转移:dp[3]=dp[0]*dp[2]+dp[1]*dp[1]+dp[2]*dp[0]
            可以比喻成前面一项是左子树情况数,后面一项是右子树情况数,相加即可
            即:dp[i]=∑dp[j]*dp[i-1-j],其中j∈[0,i-1]
        3.初始化:dp[0]=1,dp[1]=dp[0]*dp[0]=1
        4.遍历顺序:正序
        5.返回形式:返回dp[n]
         */
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= i - 1; j++) {
                dp[i] += dp[j] * dp[i - 1 - j];
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        int res = numTrees(3);
        System.out.println(res);
    }
}
