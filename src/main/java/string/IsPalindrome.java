package string;

/**
 * @description： 判断一个字符串是否是回文字符串
 * @author: zhangxianglong
 * @date: 2022/5/22
 */
public class IsPalindrome {

    static boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;

        while (left <= right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            } else {
                left++;
                right--;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "abcba";

        boolean result = isPalindrome(s);

        System.out.println(result);

    }
}
