package dp;

/**
 * 509. 斐波那契数
 *
 * @description：https://leetcode.cn/problems/fibonacci-number/
 * @author: zhangxianglong
 * @date: 2022/5/25
 */
public class Fibonacci {

    public static int fibonacci(int n) {
        //1 、定义DP数组
        int[] arry = new int[n + 1];
        if (n <= 1) {
            return n;
        }
        //2、初始化元素
        arry[0] = 0;
        arry[1] = 1;

        //3、状态转移
        for (int i = 2; i < arry.length; i++) {
            arry[i] = arry[i - 1] + arry[i - 2];
        }

        //4、打印DP数组
        return arry[n];
    }

    public static void main(String[] args) {
        int result = fibonacci(0);
    }
}
