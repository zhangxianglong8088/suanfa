package arry;

/**
 * https://leetcode.cn/problems/merge-sorted-array/
 *
 * @description：合并两个有序数组
 * @author: zhangxianglong
 * @date: 2022/5/28
 */
public class Merge {
    /**
     * 新建一个数组 挨个比较nums1 和nums2 填入 新数组 然后把新数组的值赋值到nums1中
     *
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public static void merge(int[] nums1, int m, int[] nums2, int n) {

        int[] arr = new int[m + n];

        int left = 0;
        int right = 0;

        for (int i = 0; i < m + n; i++) {
            if (left < m && right < n) {
                if (nums1[left] <= nums2[right]) {
                    arr[i] = nums1[left];
                    left++;
                } else {
                    arr[i] = nums2[right];
                    right++;
                }
            } else {
                //
                if (left > m - 1 && right <= n - 1) {
                    arr[i] = nums2[right];
                    right++;
                }
                if (right > n - 1 && left <= m - 1) {
                    arr[i] = nums1[left];
                    left++;
                }
            }
        }

        for (int i = 0; i != m + n; ++i) {
            nums1[i] = arr[i];
        }
    }


    public static void main(String[] args) {

        int[] nums1 = new int[]{1, 2, 3, 0, 0, 0};
        int[] nums2 = new int[]{2, 5, 6};

        merge(nums1, 3, nums2, 3);
    }
}
