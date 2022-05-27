package arry;

/**
 * @description：寻找峰值 https://www.nowcoder.com/practice/fcf87540c4f347bcb4cf720b5b350c76?tpId=295&tqId=2227748&ru=/exam/oj&qru=/ta/format-top101/question-ranking&sourceUrl=%2Fexam%2Foj
 * @author: zhangxianglong
 * @date: 2022/5/26
 */
public class FindPeakElement {

    public static int findPeakElement(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }

        if (nums.length == 2) {
            if(nums[0]>nums[1]){
                return 0;
            }else {
                return 1;
            }
        }


        for (int i = 1; i < nums.length - 1; i++) {
            if (nums[i] > nums[i - 1] && nums[i] > nums[i + 1]) {
                return i;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2};
        int index = findPeakElement(nums);
    }
}
