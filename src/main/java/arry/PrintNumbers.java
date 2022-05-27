package arry;

/**
 * @description：剑指 Offer 17. 打印从1到最大的n位数
 * int end = (int) Math.pow(10, n) - 1;
 * https://leetcode.cn/problems/da-yin-cong-1dao-zui-da-de-nwei-shu-lcof/submissions/
 * @author: zhangxianglong
 * @date: 2022/5/16
 */
public class PrintNumbers {

    public static int[] printNumbers(int n) {
        int end = (int) Math.pow(10, n) - 1;
        int[] result = new int[end];

        for (int i = 1; i <= end; i++) {
            result[i - 1] = i;
        }
        return result;
    }

    public static void main(String[] args) {
        printNumbers(1);
    }
}
