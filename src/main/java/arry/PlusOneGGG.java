package arry;

/**
 * https://www.nowcoder.com/practice/e20d6e18e75941b6a5b7b33ffa7b8d4d?tpId=117&tqId=39347&rp=1&ru=/exam/oj&qru=/exam/oj&sourceUrl=%2Fexam%2Foj%3Fpage%3D4%26tab%3D%25E7%25AE%2597%25E6%25B3%2595%25E7%25AF%2587%26topicId%3D117&difficulty=undefined&judgeStatus=undefined&tags=&title=
 *
 * @description：给数组加一
 * @author: zhangxianglong
 * @date: 2022/7/29
 */
public class PlusOneGGG {

    public static int[] plusOne(int[] nums) {

        int n = nums.length;
        int carry = 0;
        int sum;
        for (int i = n - 1; i >= 0; i--) {

            if (i == n - 1) {
                sum = nums[i] + 1;
            } else {
                sum = carry + nums[i];
            }

            if (sum >= 10) {
                carry = 1;
                sum = sum - 10;
            } else {
                carry = 0;
            }
            nums[i] = sum;
        }
        if (carry == 1) {
            int[] res = new int[nums.length + 1];
            for (int i = 0; i < nums.length; i++) {
                res[i + 1] = nums[i];
            }
            res[0] = 1;
            return res;
        } else {
            return nums;
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 3};

        int[] res = plusOne2(nums);

        System.out.println(res);

    }

    public static int[] plusOne2(int[] nums) {
        // write code here
        int n = nums.length;
        int carry = 0;
        int sum;

        for (int i = n - 1; i >= 0; i--) {
            if (i == n - 1) {
                sum = nums[i] + carry + 1;
            } else {
                sum = nums[i] + carry;
            }
            if (sum >= 10) {
                nums[i] = sum - 10;
                carry = 1;
            } else {
                carry = 0;
                nums[i] = sum;
            }
        }

        if (carry == 1) {
            int[] res = new int[nums.length + 1];
            for (int i = 0; i < nums.length; i++) {
                res[i + 1] = nums[i];
            }
            res[0] = 1;
            return res;

        } else {
            return nums;
        }
    }
}
