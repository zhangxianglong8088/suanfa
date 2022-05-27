package arry;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @description：最接近的三数之和 nums = [-1,2,1,-4], target = 1
 * https://leetcode.cn/problems/3sum-closest/submissions/
 * @author: zhangxianglong
 * @date: 2022/5/14
 */
public class ThreeSumClosest {

    /**
     * 通过三层循环
     *
     * @param arr
     * @param target
     * @return
     */
    public static int threeSumClosest1(int[] arr, int target) {

        Map<Integer, Integer> map = new HashMap<>();

        int min = Integer.MAX_VALUE;
        int p = 0;

        for (int i = 0; i < arr.length - 2; i++) {

            for (int j = i + 1; j <= arr.length - 1; j++) {

                for (int m = j + 1; m <= arr.length - 1; m++) {

                    int tmp = Math.abs(target - (arr[i] + arr[j] + arr[m]));

                    if (tmp < min) {
                        min = Math.min(min, tmp);
                        map.put(min, (arr[i] + arr[j] + arr[m]));
                    }

                }
            }
        }
        return map.get(min);
    }


    /**
     * 排序
     *
     * @param arr
     * @param target
     * @return
     */
    static int threeSumClosest2(int[] arr, int target) {
        //nums = [-4,-1,1,2]
        Arrays.sort(arr);

        int ans = Integer.MAX_VALUE;
        int result = 0;
        int sum = 0;

        for (int i = 0; i < arr.length - 2; i++) {
            int left = i + 1;
            int right = arr.length - 1;
            while (left < right) {
                sum = arr[i] + arr[left] + arr[right];
                if (Math.abs(target - sum) < ans) {
                    ans = Math.abs(target - sum);
                    result = sum;
                }
                if (sum > target) {
                    right--;
                }
                if (sum < target) {
                    left++;
                }
            }
        }
        return result;
    }


    public static void main(String[] args) {
        int[] nums = new int[]{-1,2,1,-4,10000};
       System.out.println(threeSumClosest2(nums, 1));

    }
}
