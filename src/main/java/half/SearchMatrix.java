package half;

/**
 * 240. 搜索二维矩阵 II
 *
 * @description：https://leetcode.cn/problems/search-a-2d-matrix-ii/
 * @author: zhangxianglong
 * @date: 2022/7/22
 */
public class SearchMatrix {

    /**
     * 二分查找比较慢
     *
     * @param matrix
     * @param target
     * @return
     */
    public static boolean searchMatrix(int[][] matrix, int target) {

        int res;
        for (int[] nums : matrix) {
            res = search(nums, target);
            if (res >= 0) {
                return true;
            }
        }
        return false;
    }

    /**
     * 二分查找
     *
     * @param nums
     * @param target
     * @return
     */

    static int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int middle = (left + right) / 2;

            if (target < nums[middle]) {
                right = middle - 1;
            }
            if (target == nums[middle]) {
                return middle;
            }
            if (target > nums[middle]) {
                left = middle + 1;
            }

        }
        return -1;
    }

    /**
     * 利用矩阵从左到右递增 从上倒下递增的性质
     * 从矩阵的右上角开始搜索
     *
     * @param matrix
     * @param target
     * @return
     */
    public static boolean searchMatrix2(int[][] matrix, int target) {
        int rows = matrix.length;
        int col = matrix[0].length;

        int curRow = 0;
        int curColum = col - 1;

        while (curRow < rows && curColum >= 0) {
            if (target < matrix[curRow][curColum]) {
                curColum--;
            } else if (target > matrix[curRow][curColum]) {
                curRow++;
            } else {
                return true;
            }
        }
        return false;

    }

    public static void main(String[] args) {
        int[][] nums = new int[][]{{1, 4, 7, 11, 15}, {2, 5, 8, 12, 19}, {3, 6, 9, 16, 22}, {10, 13, 14, 17, 24}, {18, 21, 23, 26, 30}};
        Boolean res = searchMatrix2(nums, 5);
        System.out.println(res);
    }
}
