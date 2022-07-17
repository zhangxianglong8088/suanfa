package arry;

/**
 * @description：581. 最短无序连续子数组
 * https://leetcode.cn/problems/shortest-unsorted-continuous-subarray/
 * @author: zhangxianglong
 * @date: 2022/7/11
 */

/**
 * 一次遍历
 * 正常排序(1 2 3 4 5): 左边所有元素的最大值(2) <= 每个元素(例如3) <= 右边所有元素的最小值(4)
 * 求解: 2  6  8  10  4  9  15
 * 其中: 从左到右 9是最后一个小于 (左边所有元素最大值)的
 * 从右到左 6是最后一个大于 (右边所有元素最小值)的
 * 故解为求:
 * 从左到右遍历, 记录当前遍历数的最大值, 最后一个小于最大值的即 需要倒置数组的右边索引
 * 从右到左遍历, 记录当前遍历数的最小值, 最后一个大于最小值的即 需要倒置数组的左边索引
 */
public class FindUnsortedSubarrayXXX {

    public int findUnsortedSubarray(int[] nums) {
        int length = nums.length;
        int leftDiff = -1;
        int rightDiff = -1;
        //最大值是顺序遍历使用的(求需排序数组的右边索引rightDiff), 也可以取Integer.MIN_VALUE
        int max = nums[0];
        //最小值是倒序遍历使用的(求需排序数组的左边索引leftDiff), 也可以取Integer.MAX_VALUE
        int min = nums[length - 1];
        for (int i = 0; i < length; i++) {
            //顺序执行, 判断 当前值是否小于 已遍历的最大值, 是的话属于需排序的数组元素, 替换rightDiff; 否就更新最大值
            if (nums[i] < max) {
                rightDiff = i;
            } else {
                max = nums[i];
            }
            //倒序执行, 判断 当前值是否大于 已遍历的最小值, 是的话属于需排序的数组元素, 替换leftDiff; 否就更新最小值
            int index = length - 1 - i;
            if (nums[index] > min) {
                leftDiff = index;
            } else {
                min = nums[index];
            }
        }
        return leftDiff != -1 ? rightDiff - leftDiff + 1 : 0;
    }


    /**
     * @param nums
     * @return
     */
    public static int findUnsortedSubarray2(int[] nums) {

        if (nums == null || nums.length < 2) {
            return 0;
        }

        //定义最大值和最小值
        int max = nums[0];
        int min = nums[nums.length-1];

        int r = 0;
        int l = 0;

        //从左到右寻找最后一个比最大值小的数
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < max) {
                r = i;
            } else {
                max = nums[i];
            }
        }

        //从右到左寻找最后一个比最小值大得数
        for (int j = nums.length - 1; j >= 0; j--) {
            if (nums[j] > min) {
                l = j;
            } else {
                min = nums[j];
            }
        }

        return r == l ? 0 : r - l + 1;

    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 6, 4, 8, 10, 9, 15};
        int res = findUnsortedSubarray2(nums);
        System.out.println(res);
    }

}
