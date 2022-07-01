package arry;

/**
 * @description：https://leetcode.cn/problems/find-first-and-last-position-of-element-in-sorted-array/
 * @author: zhangxianglong
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 * <p>
 * 如果数组中不存在目标值 target，返回 [-1, -1]。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/find-first-and-last-position-of-element-in-sorted-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @date: 2022/5/17
 */
public class SearchRange {


    public static int[] searchRange(int[] nums, int target) {

        int[] result = new int[2];
        int start = -1;
        int end = -1;


        for (int i = 0; i <= nums.length - 1; i++) {
            if (nums[i] == target) {
                start = i;
                break;
            }
        }

        for (int i = nums.length - 1; i >= 0; i--) {
            if (nums[i] == target) {
                end = i;
                break;
            }
        }

        result[0] = start;
        result[1] = end;
        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{5, 7, 7, 8, 8, 10};
        int[] result = searchRange(nums, 8);
    }
}
