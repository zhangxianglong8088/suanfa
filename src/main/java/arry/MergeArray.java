package arry;

/**
 * https://leetcode.cn/problems/merge-sorted-array/
 *
 * @description：合并两个有序数组
 * @author: zhangxianglong
 * @date: 2022/5/28
 */
public class MergeArray {
    /**
     * 新建一个数组 挨个比较nums1 和nums2 填入 新数组 然后把新数组的值赋值到nums1中
     *
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public static void merge1(int[] nums1, int m, int[] nums2, int n) {

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

        int[] nums1 = new int[]{1};
        int[] nums2 = new int[]{};

        merge1(nums1, 1, null, 0);
    }


    /**
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public static void merge2(int[] nums1, int m, int[] nums2, int n) {
        int[] merge = new int[m + n];
        int i = 0;
        int p1 = 0;
        int p2 = 0;


        while (p1 < m && p2 < n) {
            if (nums1[p1] < nums2[p2]) {
                merge[i] = nums1[p1];
                p1++;
                i++;
            } else {
                merge[i] = nums2[p2];
                p2++;
                i++;
            }
        }


        while (p1 > m - 1 && p2 <= n - 1) {
            merge[i] = nums2[p2];
            p2++;
            i++;
        }

        while (p2 > n - 1 && p1 <= m - 1) {
            merge[i] = nums1[p1];
            i++;
            p1++;
        }

        for (int j = 0; j < merge.length; j++) {
            nums1[j] = merge[j];
        }
    }

}
