package greed;

/**
 * 45. 跳跃游戏II
 * 假设可以跳跃到最后，求跳跃到最后一步需要的最少的跳跃步数
 *
 * @description： https://leetcode.cn/problems/jump-game-ii/
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
    public static int minJumpStep(int[] nums) {
        int n = nums.length;

        //当前所在位置
        int curIndex = 0;

        //跳跃到下一次的位置
        int nextIndex = 0;

        //最少的跳跃步数
        int steps = 0;

        // 倒数第二位，只要到倒数第二位就可以跳导终点
        while (curIndex < n - 1) {

            int begin = curIndex + 1;

            int end = curIndex + nums[curIndex];

            //从begin 到end之间取能够跳跃到的最大位置，然后更新nextIndex 这个，最终赋值给cur
            // 注意这里不是取 begin 到end 之间的最大值******
            //表示可以覆盖到的最大位置
            int maxCover = 0;

            for (int i = begin; i <= end && i < n; i++) {
                if (i == nums.length - 1) {
                    steps++; // 直接碰到了数组右边界
                    return steps;
                }

                if (nums[i] + i > maxCover) {
                    maxCover = nums[i] + i;
                    nextIndex = i;

                }
            }

            curIndex = nextIndex;
            steps++;
        }

        return steps;
    }


    public static void main(String[] args) {
        int[] nums = new int[]{2, 3, 1, 1, 4};
        int res = minJumpStep(nums);
        System.out.println(res);
    }
}
