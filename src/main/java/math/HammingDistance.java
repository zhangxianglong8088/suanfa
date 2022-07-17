package math;

/**
 * @description：461. 汉明距离
 * https://leetcode.cn/problems/hamming-distance/
 * @author: zhangxianglong
 * @date: 2022/7/11
 */
public class HammingDistance {

    public static int hammingDistance(int x, int y) {
        int res = 0;
        //将xy异或运算
        int s = x ^ y;

        //对异或的结果二进制计算有多少个1
        while (s != 0) {
            //这一步中 s&1 之后 s本身没有发生变化
            res += s & 1;
            s >>= 1;
        }
        return res;
    }

    public static void main(String[] args) {
        int x = 4;
        int y = 1;
        int res = hammingDistance(x, y);
        System.out.println(res);
    }
}
