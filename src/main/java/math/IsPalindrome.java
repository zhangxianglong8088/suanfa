package math;

/**
 * @description：9. 回文数
 * https://leetcode.cn/problems/palindrome-number/
 * @author: zhangxianglong
 * @date: 2022/7/12
 */
public class IsPalindrome {

    /**
     * 转化为字符串解决
     *
     * @param x
     * @return
     */
    public boolean isPalindrome1(int x) {
        if (x < 0) {
            return false;
        }
        String s = "" + x;
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    /**
     * 反转一个整数
     *
     * @param x
     * @return
     */
    public static boolean isPalindrome2(int x) {
        int orinal = x;

        long res = 0;

        while (x != 0) {
            res = res * 10 + x % 10;
            x = x / 10;
        }

        if (res > Integer.MAX_VALUE || res < Integer.MIN_VALUE) {
            return false;
        }
        return orinal == (int) res;
    }

    public static void main(String[] args) {
        int m = 121;
        boolean res = isPalindrome2(m);
        System.out.println(res);
    }
}
