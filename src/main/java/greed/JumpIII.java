package greed;

/**
 * NC205 跳跃游戏(三)
 * 这个题是前两个跳跃游戏的结合版
 * https://www.nowcoder.com/practice/14abdfaf0ec4419cbc722decc709938b?tpId=117&tqId=39394&rp=1&ru=/exam/oj&qru=/exam/oj&sourceUrl=%2Fexam%2Foj%3Fpage%3D5%26tab%3D%25E7%25AE%2597%25E6%25B3%2595%25E7%25AF%2587%26topicId%3D117&difficulty=undefined&judgeStatus=undefined&tags=&title= *
 */
public class JumpIII {


    /**
     * 贪心算法
     *
     * @param nums
     * @return
     */

    public static int minJumpStep(int[] nums) {
        // write code here
        if (nums.length == 0) {
            return -1;
        }
        int length = nums.length;
        int end = 0;
        int maxPosition = 0;
        int steps = 0;
        for (int i = 0; i < length - 1; i++) {
            //若该点位置大于maxPosition，则无法到达
            if (i > maxPosition) {
                return -1;
            }
            maxPosition = Math.max(maxPosition, i + nums[i]);
            //若i=end，说明此步数最多到达此，需要step++，并更新新的end
            if (i == end) {
                end = maxPosition;
                steps++;
            }
        }
        //重点不可达，返回-1
        if (maxPosition < length - 1) {
            return -1;
        }
        return steps;
    }


    public static void main(String[] args) {
        int[] nums = new int[]{2, 1, 3, 3, 0, 0, 100};
        int res = minJumpStep(nums);
        System.out.println(res);
    }
}
