package half;

/**
 * 4. 寻找两个正序数组的中位数
 *
 * @description： https://leetcode.cn/problems/median-of-two-sorted-arrays/
 * @author: zhangxianglong
 * @date: 2022/7/5
 */
public class FindMedianSortedArraysXXX {
    public static void main(String[] args) {
        int[] nums1 = new int[]{1, 2, 4, 5, 6};
        int[] nums2 = new int[]{3, 4, 7, 8};

        double res = findMedianSortedArrays2(nums1, nums2);
        System.out.println(res);

    }

    /**
     * 解法1 新建m+n的数组，找到合并之后数组的中位数
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public static double findMedianSortedArrays1(int[] nums1, int[] nums2) {

        int[] nums = new int[nums1.length + nums2.length];

        int index1 = 0;
        int index2 = 0;
        int idx = 0;
        while (index1 < nums1.length || index2 < nums2.length) {
            if (index1 < nums1.length && index2 < nums2.length) {
                if (nums1[index1] < nums2[index2]) {
                    nums[idx] = nums1[index1];
                    idx++;
                    index1++;
                } else {
                    nums[idx] = nums2[index2];
                    idx++;
                    index2++;
                }
            } else if (index1 < nums1.length) {
                nums[idx] = nums1[index1];
                idx++;
                index1++;
            } else {
                nums[idx] = nums2[index2];
                idx++;
                index2++;
            }
        }
        if (nums.length % 2 == 1) {
            return nums[(nums.length) / 2];
        } else {
            return (nums[(nums.length + 1) / 2] + nums[(nums.length - 1) / 2]) / 2.0;
        }
    }


    /**
     * 解法二的思想是二分查找
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public static double findMedianSortedArrays2(int[] nums1, int[] nums2) {
        int length1 = nums1.length, length2 = nums2.length;
        int totalLength = length1 + length2;
        // 可以将两种情况合并,奇数会求两次同样的k
        if (totalLength % 2 == 1) {
            int midIndex = totalLength / 2;
            double median = getKthElement(nums1, nums2, midIndex + 1);
            return median;
        } else {
            int midIndex1 = totalLength / 2 - 1, midIndex2 = totalLength / 2;
            double median = (getKthElement(nums1, nums2, midIndex1 + 1) + getKthElement(nums1, nums2, midIndex2 + 1)) / 2.0;
            return median;
        }
    }

    public static int getKthElement(int[] nums1, int[] nums2, int k) {
        /* 主要思路：要找到第 k (k>1) 小的元素,那么就取 pivot1 = nums1[k/2-1] 和 pivot2 = nums2[k/2-1] 进行比较
         * 这里的 "/" 表示整除
         * nums1 中小于等于 pivot1 的元素有 nums1[0 .. k/2-2] 共计 k/2-1 个
         * nums2 中小于等于 pivot2 的元素有 nums2[0 .. k/2-2] 共计 k/2-1 个
         * 取 pivot = min(pivot1, pivot2),两个数组中小于等于 pivot 的元素共计不会超过 (k/2-1) + (k/2-1) <= k-2 个
         * 这样 pivot 本身最大也只能是第k-1小的元素
         * 如果 pivot = pivot1,那么 nums1[0 .. k/2-1] 都不可能是第 k 小的元素。把这些元素全部 "删除",剩下的作为新的 nums1 数组
         * 如果 pivot = pivot2,那么 nums2[0 .. k/2-1] 都不可能是第 k 小的元素。把这些元素全部 "删除",剩下的作为新的 nums2 数组
         * 由于我们 "删除" 了一些元素（这些元素都比第 k 小的元素要小）,因此需要修改 k 的值,减去删除的数的个数
         */

        int length1 = nums1.length, length2 = nums2.length;
        int index1 = 0, index2 = 0;
        int kthElement = 0;

        while (true) {
            // 特殊情况
            // 第二种特殊情况,一个数组为空
            if (index1 == length1) {
                return nums2[index2 + k - 1];
            }
            // 第二种特殊情况,一个数组为空
            if (index2 == length2) {
                return nums1[index1 + k - 1];
            }
            // 第三种特殊情况,k=1
            if (k == 1) {
                return Math.min(nums1[index1], nums2[index2]);
            }

            // 正常情况,index1,index2作为起始点,newindex1,newindex2作为比较点 在不停的更新
            int half = k / 2;
            //第一种特殊情况,发生越界,记录需要比较的位置
            int newIndex1 = Math.min(index1 + half, length1) - 1;
            //第一种特殊情况,发生越界,记录需要比较的位置
            int newIndex2 = Math.min(index2 + half, length2) - 1;
            //获取两个需要比较的数
            int pivot1 = nums1[newIndex1], pivot2 = nums2[newIndex2];
            // <=将两种情况合并
            if (pivot1 <= pivot2) {
                //两者相减后+1,这才是真正减去的长度
                k -= (newIndex1 - index1 + 1);
                //连同比较位置也一同删去了,所以新的开始是 比较位置 的后一位
                index1 = newIndex1 + 1;
            } else {
                k -= (newIndex2 - index2 + 1);
                index2 = newIndex2 + 1;
            }
        }
    }
}
