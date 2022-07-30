package arry;

/**
 * @description：剑指 Offer 11. 旋转数组的最小数字 找到数组中比后面大的那个数的下一个数
 * https://leetcode.cn/problems/xuan-zhuan-shu-zu-de-zui-xiao-shu-zi-lcof/
 * @author: zhangxianglong
 * @date: 2022/5/16
 */
public class MinArrayGGG {

    public int minArray(int[] numbers) {
        for (int i = 0; i < numbers.length - 1; i++) {
            if (numbers[i] > numbers[i + 1]) {
                return numbers[i + 1];
            }
        }
        return numbers[0];
    }

    public static void main(String[] args) {


    }
}
