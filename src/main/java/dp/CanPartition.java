package dp;

/**
 * 416. 分割等和子集
 * 参考思路：https://labuladong.github.io/algo/3/25/80/
 * dp[i][j] = x 表示，对于前 i 个物品（i 从 1 开始计数），当前背包的容量为 j 时，若 x 为 true，则说明可以恰好将背包装满，若 x 为 false，则说明不能恰好将背包装满。
 * <p>
 * 比如说，如果 dp[4][9] = true，其含义为：对于容量为 9 的背包，若只是用前 4 个物品，可以有一种方法把背包恰好装满。
 * <p>
 * 或者说对于本题，含义是对于给定的集合中，若只对前 4 个数字进行选择，存在一个子集的和可以恰好凑出 9。
 * <p>
 * 根据这个定义，我们想求的最终答案就是 dp[N][sum/2]，base case 就是 dp[..][0] = true 和 dp[0][..] = false，因为背包没有空间的时候，就相当于装满了，而当没有物品可选择的时候，肯定没办法装满背包。
 * <p>
 * 第三步，根据「选择」，思考状态转移的逻辑。
 * <p>
 * 回想刚才的 dp 数组含义，可以根据「选择」对 dp[i][j] 得到以下状态转移：
 * <p>
 * 如果不把 nums[i] 算入子集，或者说你不把这第 i 个物品装入背包，那么是否能够恰好装满背包，取决于上一个状态 dp[i-1][j]，继承之前的结果。
 * <p>
 * 如果把 nums[i] 算入子集，或者说你把这第 i 个物品装入了背包，那么是否能够恰好装满背包，取决于状态 dp[i-1][j-nums[i-1]]。
 * <p>
 * PS：由于 dp 数组定义中的 i 是从 1 开始计数，而数组索引是从 0 开始的，所以第 i 个物品的重量应该是 nums[i-1]，这一点不要搞混。
 * <p>
 * dp[i - 1][j-nums[i-1]] 也很好理解：你如果装了第 i 个物品，就要看背包的剩余重量 j - nums[i-1] 限制下是否能够被恰好装满。
 * <p>
 * 换句话说
 *
 * @description：https://leetcode.cn/problems/partition-equal-subset-sum/
 * @author: zhangxianglong
 * @date: 2022/6/16
 */
public class CanPartition {

    public static boolean canPartition(int[] nums) {
        //定义dp数组 dp[i][j] i表示0-i个数，j表示剩余容积
        int sum = 0;
        //1、计算数组总和
        for (int i = 0; i < nums.length; i++) {
            sum = sum + nums[i];
        }
        if (sum % 2 == 1) {
            return false;
        }
        int target = sum / 2;
        int n = nums.length;

        //定义dp数组
        boolean[][] dp = new boolean[n + 1][target + 1];

        //初始化dp数组 背包容量为0
        for (int i = 0; i < n; i++) {
            dp[i][0] = true;
        }
        //遍历物品 这里的关键是 i必须从1开始
        for (int i = 1; i <= n; i++) {
            //遍历背包重量
            for (int j = 1; j <= target; j++) {
                //容量不足
                if (nums[i - 1] > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i - 1]];
                }
            }
        }
        return dp[n - 1][target];
    }

    public static void main(String[] args) {
        int[] nusm = new int[]{1, 5, 11, 5};

        boolean res = canPartition(nusm);
        System.out.println(res);
    }
}
