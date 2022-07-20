package dp;

/**
 * 55. 跳跃游戏
 * 动态规划思想
 * https://leetcode.cn/problems/jump-game/solution/55-tiao-yue-you-xi-by-chen-wei-f-d5t9/
 *
 * @description：https://leetcode.cn/problems/jump-game/
 * @author: zhangxianglong
 * @date: 2022/7/20
 */
public class CanJump {


    public static boolean canJump(int[] grid) {
        //定义DP数组 dp数组表示是否可以到达i位置
        //思路：dp[i]表示能否到达位置i，对每个位置i判断能否通过前面的位置跳跃过来，当前位置j能达到，并且当前位置j加上能到达的位置如果超过了i，
        //那dp[i]更新为ture，便是i位置也可以到达。
        //复杂度：时间复杂度O(n^2)，空间复杂度O(n)
        boolean[] dp = new boolean[grid.length];

        dp[0] = true;

        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && (grid[j] + j) >= i) {
                    dp[i] = true;
                }
            }
        }
        return dp[grid.length - 1];

    }

    /**
     * 贪心算法
     *
     * @param nums
     * @return
     */
    public static boolean canJump2(int[] nums) {

        //如果长度为1 直接到终点返回true
        if (nums.length == 1) {
            return true;
        }
        //可以覆盖的最大距离
        int cover = nums[0];

        for (int i = 0; i <= cover; i++) {
            //当前覆盖距离cover和当前位置加能条约的距离中取一个较大者
            cover = Math.max(cover, i + nums[i]);
            if (cover >= nums.length - 1) {
                //覆盖距离超过或者等于nums.length-1 说明能到达终点
                return true;
            }
        }
        //循环完成 还没返回true 就是不能到达终点
        return false;
    }


    public static void main(String[] args) {
        int[] nums = new int[]{3, 2, 1, 0, 4};
        boolean res = canJump2(nums);
        System.out.println(res);
    }
}
