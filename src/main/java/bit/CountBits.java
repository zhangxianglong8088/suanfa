package bit;

/**
 * 338. 比特位计数
 * https://leetcode.cn/problems/counting-bits/
 *
 * @description： 解题思路：
 * <p>
 * 假设x二进制是1101101000
 * 那么x-1二进制就是1101100111
 * 将x和x-1做按位与运算
 * 1101101000
 * & 1101100111
 * ——————————————
 * 1101100000
 * 我们发现x与x-1运算后少了一个1
 * 即可得：f(x) = f(x & (x - 1)) + 1
 * @author: zhangxianglong
 * @date: 2022/7/23
 */
public class CountBits {

    static int[] countBits(int n) {
        int[] res = new int[n + 1];

        res[0] = 0;
        for (int i = 1; i <= n; i++) {
            res[i] = res[(i & i - 1)] + 1;
        }
        return res;
    }

    public static void main(String[] args) {
        int n = 5;
        int[] res = countBits(n);
        System.out.println(res);
    }

    /**
     * 求一个整数有多少个1
     *
     * @param n
     * @return
     */
    public int NumberOf1(int n) {

        int count = 0;

        while (n != 0) {
            n = n & (n - 1);
            count++;
        }
        return count;
    }


}
