package math;

/**
 * 反转一个整数
 *
 * @description：https://leetcode.cn/problems/reverse-integer/
 * @author: zhangxianglong
 * @date: 2022/5/28
 */
public class ReverseNum {

    /**
     * 初始状态：123        res = 0
     * 第一步：123        res = 0*10+3
     * 第 而步：123        res = 3*10+2
     * 第一步：123        res = 32*10+1
     *
     * @param x
     * @return
     */
    public static int reverse(int x) {

        long res = 0;

        while (x != 0) {
            int m = x % 10;
            x = x / 10;
            res = res * 10 + m;
        }

       if(res > Integer.MAX_VALUE){
           return 0;
       }

        if(res < Integer.MIN_VALUE){
            return 0;
        }

        return  (int) res;
    }

    public static void main(String[] args) {
        System.out.println(reverse(123456789));
    }
}
