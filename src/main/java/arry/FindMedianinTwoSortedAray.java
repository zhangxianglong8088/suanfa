package arry;

import java.util.Arrays;

/**
 * @description：
 * @author: zhangxianglong
 * @date: 2022/5/15
 */
public class FindMedianinTwoSortedAray {
    /**
     * https://www.nowcoder.com/practice/6fbe70f3a51d44fa9395cfc49694404f?tpId=196&tqId=37141&rp=1&ru=/exam/oj&qru=/exam/oj&sourceUrl=%2Fexam%2Foj%3Fpage%3D1%26pageSize%3D50%26search%3D%26tab%3D%25E7%25AE%2597%25E6%25B3%2595%25E7%25AF%2587%26topicId%3D196&difficulty=undefined&judgeStatus=undefined&tags=578&title=
     * 两个数组合并为一个新的数组，再排序后，取中间位置的数
     *
     * @param arr1
     * @param arr2
     * @return
     */
    static int findMedianinTwoSortedAray(int[] arr1, int[] arr2) {
        int[] sum = new int[arr1.length + arr2.length];
        for (int i = 0; i < arr1.length; i++) {
            sum[i] = arr1[i];
        }

        for (int j = sum.length - 1; j >= arr2.length; j--) {
            sum[j] = arr2[j - arr2.length];
        }
        Arrays.sort(sum);
        return sum[sum.length / 2 - 1];
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{1};
        int[] nums2 = new int[]{2};
        System.out.println(findMedianinTwoSortedAray(nums1, nums2));
    }
}
