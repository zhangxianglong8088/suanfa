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

        int[] nums1 = new int[]{0};

        int[] nums2 = new int[]{1};

        merge(nums1, 0, nums2, 1);
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


    public static void merge(int[] nums1, int m, int[] nums2, int n) {

        for (int i = 0; i < n; ++i) {
            nums1[m + i] = nums2[i];
        }

        quickSort(nums1, 0, nums1.length - 1);

    }

    static void quickSort(int[] nums, int start, int end) {
        if (start > end) {
            return;
        }
        int i = start;
        int j = end;
        int pivot = nums[start];

        while (i < j) {
            /**
             * 注意这里的序号一定是先判断j 再判断i否则出错
             */
            while (i < j && nums[j] >= pivot) {
                j--;
            }
            while (i < j && nums[i] <= pivot) {
                i++;
            }

            if (i < j) {
                //交换num[i] nums[j]
                swap(nums, i, j);
            }
        }
        swap(nums, start, i);
        quickSort(nums, start, i - 1);
        quickSort(nums, j + 1, end);
    }

    public static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

}
