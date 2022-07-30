package greed;

/**
 * 55. 跳跃游戏
 * 动态规划思想
 * https://leetcode.cn/problems/jump-game/solution/55-tiao-yue-you-xi-by-chen-wei-f-d5t9/
 *
 * @description：https://leetcode.cn/problems/jump-game/
 * @author: zhangxianglong
 * @date: 2022/7/20
 */
public class JumpI {


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
     * 每次移动取最大跳跃步数（得到最大的覆盖范围），每移动一个单位，就更新最大覆盖范围。
     * 贪心算法局部最优解：每次取最大跳跃步数（取最大覆盖范围），整体最优解：最后得到整体最大覆盖范围，看是否能到终点。
     *
     * @param nums
     * @return
     */
    public static boolean canJump2(int[] nums) {
        //可以跳跃的最大位置
        int cover = 0;

        for (int x = 0; x < nums.length - 1; x++) {
            //如果当前索引位置大于可以跳跃的最大长度 说明不可能到最后一个位置
            if (x > cover) {
                return false;
            }
            // 更新最大可以跳跃位置
            cover = Math.max(cover, x + nums[x]);
        }
        return true;
    }


    public static void main(String[] args) {
        int[] nums = new int[]{2, 3, 1, 1, 4};
        boolean res = canJump2(nums);
        System.out.println(res);
    }
}
