package sort;

/**
 * @description： 快速排序
 * @author: zhangxianglong
 * @date: 2022/6/29
 */
public class QuickSortGGG {

    static void quickSort(int[] nums, int start, int end) {
        if (start > end) {
            return;
        }
        int i = start;
        int j = end;
        int pivot = nums[start];

        while (i < j) {
            //这里选择左边的第一个数为 pivot 所有 需要先判断j
            while (i < j && nums[j] > pivot) {
                j--;
            }
            while (i < j && nums[i] < pivot) {
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

    /**
     * 交换num[i] nums[j] 的值
     *
     * @param nums
     * @param i
     * @param j
     */
    public static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 3, 5, 3, 1};
        quickSort(nums, 0, nums.length - 1);
        System.out.println(nums);
    }
}