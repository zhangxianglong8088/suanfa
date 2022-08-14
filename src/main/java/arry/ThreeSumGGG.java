package arry;

import java.util.*;

public class ThreeSumGGG {

    /**
     * 排序+双指针
     * 「不重复」的本质是什么？我们保持三重循环的大框架不变，只需要保证：
     * <p>
     * 第二重循环枚举到的元素不小于当前第一重循环枚举到的元素；
     * <p>
     * 第三重循环枚举到的元素不小于当前第二重循环枚举到的元素。
     * <p>
     * 链接：https://leetcode.cn/problems/3sum/solution/san-shu-zhi-he-by-leetcode-solution/
     *
     * @param nums
     * @return
     */
    public static List<List<Integer>> threeSum(Integer[] nums) {
        //定义一个结果集
        List<List<Integer>> res = new ArrayList<>();
        //数组的长度
        int len = nums.length;
        //当前数组的长度为空，或者长度小于3时，直接退出
        if (len < 3) {
            return res;
        }
        //将数组进行排序
        Arrays.sort(nums);
        //遍历数组中的每一个元素
        for (int i = 0; i < len; i++) {
            //如果遍历的起始元素大于0，就直接退出
            //原因，此时数组为有序的数组，最小的数都大于0了，三数之和肯定大于0
            if (nums[i] > 0) {
                break;
            }
            //去重，当起始的值等于前一个元素，那么得到的结果将会和前一次相同
            if (i > 0 && Objects.equals(nums[i], nums[i - 1])) {
                continue;
            }
            int l = i + 1;
            int r = len - 1;
            //当 l 不等于 r时就继续遍历
            while (l < r) {
                //将三数进行相加
                int sum = nums[i] + nums[l] + nums[r];
                //如果等于0，将结果对应的索引位置的值加入结果集中
                if (sum == 0) {
                    // 将三数的结果集加入到结果集中
                    res.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    //在将左指针和右指针移动的时候，先对左右指针的值，进行判断
                    //如果重复，直接跳过。
                    //去重，因为 i 不变，当此时 l取的数的值与前一个数相同，所以不用再计算，直接跳
                    while (l < r && Objects.equals(nums[l], nums[l + 1])) {
                        l++;
                    }
                    //去重，因为 i不变，当此时 r 取的数的值与前一个相同，所以不用再计算
                    while (l < r && Objects.equals(nums[r], nums[r - 1])) {
                        r--;
                    }
                    //将 左指针右移，将右指针左移。
                    l++;
                    r--;
                    //如果结果小于0，将左指针右移
                } else if (sum < 0) {
                    l++;
                    //如果结果大于0，将右指针左移
                } else {
                    r--;
                }
            }
        }
        return res;
    }


    public static List<List<Integer>> threeSum6(int[] nums) {

        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);

        if (nums[0] > 0) {
            return res;
        }

        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int left = i + 1;
            int right = nums.length - 1;


            while (left < right) {

                int sum = nums[i] + nums[left] + nums[right];

                if (sum == 0) {

                    res.add(Arrays.asList(nums[i], nums[left], nums[right]));

                    while (left < right && nums[left] == nums[left + 1]) {
                        left++;
                    }

                    while (left < right && nums[right] == nums[right - 1]) {
                        right--;
                    }
                    left++;
                    right--;
                } else if (sum > 0) {
                    right--;
                } else {
                    left++;
                }
            }
        }

        return res;

    }

    public static void main(String[] args) {
        int[] arr = new int[]{-1, 0, 1, 2, -1, -4};
        List<List<Integer>> result = threeSum6(arr);
    }
}
