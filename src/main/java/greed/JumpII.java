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
public class JumpII {


    /**
     * 贪心算法
     *
     * @param nums
     * @return
     */
    public static int jump(int[] nums) {
        //当前位置
        int index = 0;

        //应该选择的下一个位置
        int nextIndex = 0;

        //最少的跳跃次数
        int steps = 0;

        //index 和 nextIndex 之间的最大值
        int max = 0;

        // 倒数第二位，只要到倒数第二位就可以跳导终点
        while (index < nums.length - 1) {
            int step = nums[index];
            // 从index的下一步开始走
            for (int i = index + 1; i < nums.length && i <= index + step; i++) {
                if (i == nums.length - 1) {
                    steps++; // 直接碰到了数组右边界
                    return steps;
                }
                // 从i 出发能到达最远的地方
                int cover = i + nums[i];

                if (cover > max) {
                    max = cover;
                    // 如果大于最远的地方，更新nextIndex
                    nextIndex = i;
                }
            }
            // 找到了下一个index
            index = nextIndex;
            steps++;
        }
        return steps;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{3, 2, 1};
        int res = jump(nums);
        System.out.println(res);
    }
}
