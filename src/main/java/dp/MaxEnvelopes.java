package dp;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 俄罗斯信封套娃
 *
 * @description：https://www.nowcoder.com/practice/9bf77b5b018d4d24951c9a7edb40408f?tpId=117&tqId=37863&rp=1&ru=/exam/oj&qru=/exam/oj&sourceUrl=%2Fexam%2Foj%3Fpage%3D1%26pageSize%3D50%26search%3D%25E4%25BF%25A1%25E5%25B0%2581%26tab%3D%25E7%25AE%2597%25E6%25B3%2595%25E7%25AF%2587%26topicId%3D117&difficulty=undefined&judgeStatus=undefined&tags=&title=%E4%BF%A1%E5%B0%81
 * @author: zhangxianglong
 * @date: 2022/7/27
 */
public class MaxEnvelopes {


    public static int maxEnvelopes(int[][] envelopes) {

        int n = envelopes.length;

        // 按宽度升序排列，如果宽度一样，则按高度降序排列
        Arrays.sort(envelopes, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                return a[0] == b[0] ? b[1] - a[1] : a[0] - b[0];
            }
        });
        //遍历数组赋值给一维数组
        int[] height = new int[n];

        for (int i = 0; i < n; i++) {
            height[i] = envelopes[i][1];
        }

        // 定义：dp[i] 表示以从0号位置到i号位置这个闭区间的最长递增子序列的长度
        int[] dp = new int[n];

        // base case：dp 数组全都初始化为 1
        Arrays.fill(dp, 1);
        //注意这里，如果求的是连续的递增序列 通过一次for循环就可以
        //如果求的是非连续的递增序列，需要通过两次for循环，用j指针取探，然后比最大值
        for (int i = 0; i < n; i++) {
            int max = Integer.MIN_VALUE;
            for (int j = 0; j < i; j++) {
                if (height[j] < height[i]) {
                    //体会这里dp[j]+1的含义
                    max = Math.max(dp[j] + 1, max);
                    dp[i] = max;
                }
            }
        }

        int res = 0;
        for (int i = 0; i < dp.length; i++) {
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] nums = new int[][]{{5, 4}, {6, 4}, {6, 7}, {2, 3}};
        int res = maxEnvelopes(nums);
    }

}
