package arry;

/**
 * @description：寻找峰值 https://www.nowcoder.com/practice/fcf87540c4f347bcb4cf720b5b350c76?tpId=295&tqId=2227748&ru=/exam/oj&qru=/ta/format-top101/question-ranking&sourceUrl=%2Fexam%2Foj
 * @author: zhangxianglong
 * @date: 2022/5/26
 */
public class FindPeakElementXXX {
    /**
     * 二分查找
     *
     * @param nums
     * @return
     */
    public static int findPeakElement(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {

            int middle = (left + right) / 2;

            if (nums[middle] > nums[middle + 1]) {
                right = middle;
            } else {
                left = middle + 1;
            }
        }

        return right;

    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 4, 1, 2, 7, 8, 4};
        int index = findPeakElement(nums);
        System.out.println(index);
    }
}
