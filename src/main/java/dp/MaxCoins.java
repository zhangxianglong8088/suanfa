package dp;

/**
 * @description：312. 戳气球
 * https://leetcode.cn/problems/burst-balloons/
 * @author: zhangxianglong
 * @date: 2022/7/23
 */
public class MaxCoins {
    public static int maxCoins(int[] nums) {
        int length = nums.length;
        int newLength = length + 2;
        // 数组首尾加1，方便计算
        int[] newArry = new int[newLength];
        newArry[0] = 1;
        newArry[length + 1] = 1;
        // 放入新数组中
        for (int i = 0; i < length; i++) {
            newArry[i + 1] = nums[i];
        }
        // 定义dp数组，dp[i][j] 表示区间(i,j)范围内可以获得的最大金币
        // 假设最后一个被戳爆的是第k个气球，那么，dp[i][j] = dp[i][k] + newArray[i]*newArray[k]*newArray[k] + dp[k][j]
        // 也就是说和他两边区间被戳吧气球获得的最大金币有关
        int[][] dp = new int[newLength][newLength];

        // (i,j)区间的范围从3开始，慢慢递增一直到最大(就是newArray的大小)，范围是[3,newLength]，闭区间
        for (int range = 3; range <= newLength; range++) {
            // 区间从左往右移动，进行初始化，也就i移动的范围是[0,newLength - range]，这是闭区间
            for (int i = 0; i <= newLength - range; i++) {
                // 知道i和rang可以确定j
                int j = i + range - 1;
                // 找出(i,j)这个区间内的最大值，就是依次试着去戳破，然后记录最大值
                int maxValue = 0;
                // 在(i,j)区间内尝试依次去戳破气球，并记录每次获得的金币
                for (int k = i + 1; k < j; k++) {
                    // 区间(i,k)区间内戳气球能获得的最大金币
                    int leftRangeValu = dp[i][k];
                    // 区间(k,j)区间内戳气球能获得的最大金币
                    int rightRangeValue = dp[k][j];
                    maxValue = Math.max(maxValue, leftRangeValu + newArry[i] * newArry[k] * newArry[j] + rightRangeValue);
                }
                // 将最大值保存到dp数组中
                dp[i][j] = maxValue;
            }
        }
        return dp[0][length + 1];
    }

    public static void main(String[] args) {

        int[] nums = new int[]{3, 1, 5, 8};
        int res = maxCoins(nums);
        System.out.println(res);

    }
}
