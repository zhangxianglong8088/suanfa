package greed;

/**
 * https://leetcode.cn/problems/gas-station/
 *
 * @description：134. 加油站
 * @author: zhangxianglong
 * @date: 2022/7/29
 */
public class CanCompleteCircuit {


    /**
     * 1. 如果 gas[i] - cost[i] 的总和为负数，肯定不可能绕一圈。
     * 2. 如果总和为不为负数，那么肯定可以绕一圈：
     * 如果在区间 [0, j] 内，gas[i] - cost[i] 的总和为负数，
     * 那么区间内的加油站肯定不可能为起点，原因是车开到位置 j 时就没油了，不可能继续走。
     * 此时需要在下一个区间 [j + 1, gas.length - 1] 内找：
     * 如果下个区间的总和大于零，那么开始位置 j + 1 即为起点。
     * 此时，设区间 [0, j] 的总和为 sum1 ，区间 [j + 1, gas.length - 1] 的总和为 sum2 ，
     * 必有 sum1 + sum2 >= 0 ，又有 sum1 < 0 ，则 sum2 >= sum1 ，
     * 因此区间 2 的油量是一定能够弥补区间 1 不够的油量，可以绕一圈。
     */
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int curSum = 0;
        int totalSum = 0;
        int start = 0;
        for (int i = 0; i < gas.length; i++) {

            // 当前区间剩余的油量
            curSum += gas[i] - cost[i];
            // 总剩余油量
            totalSum += gas[i] - cost[i];

            if (curSum < 0) {
                start = i + 1;
                curSum = 0;
            }
        }
        // 总剩余油量为负数，肯定不可能绕一圈。
        if (totalSum < 0) {
            return -1;
        }
        return start;
    }
}
