package arry;

/**
 * NC200 移动 0 将数组这个的0移动到数组的末尾
 *
 * @description： https://www.nowcoder.com/practice/102586387caa4afcbad6f96affce9780?tpId=117&tqId=39389&rp=1&ru=/exam/oj&qru=/exam/oj&sourceUrl=%2Fexam%2Foj%3Fpage%3D5%26tab%3D%25E7%25AE%2597%25E6%25B3%2595%25E7%25AF%2587%26topicId%3D117&difficulty=undefined&judgeStatus=undefined&tags=&title=
 * @author: zhangxianglong
 * @date: 2022/7/26
 */
public class MoveZeroesGGG {

    public static int[] moveZeroes(int[] nums) {


        int left = 0;
        int right = 0;

        while (left < nums.length) {

            if (nums[left] == 0) {

                while (right < nums.length && nums[right] == 0) {
                    right++;
                }
                if (right < nums.length) {
                    int tmp = nums[left];
                    nums[left] = nums[right];
                    nums[right] = tmp;
                }
                left++;

            } else {
                left++;
                right++;
            }
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3};
        nums = moveZeroes3(nums);

    }

    public static int[] moveZeroes3(int[] nums) {
        int n = nums.length;
        int left = 0;
        int right = 0;

        while (right < n) {

            if (nums[right] != 0) {
                right++;
                left++;
            } else {
                while (right < n && nums[right] == 0) {
                    right++;
                }
                if (right < n) {

                    int tmp = nums[left];
                    nums[left] = nums[right];
                    nums[right] = tmp;
                    left++;
                }

            }
        }

        return nums;
    }
}
