package dp;

/**
 * 647. 回文子串
 * 给你一个字符串 s ，请你统计并返回这个字符串中 回文子串 的数目。
 *
 * @description：https://leetcode.cn/problems/palindromic-substrings/
 * @author: zhangxianglong
 * @date: 2022/6/25
 */
public class CountSubstringsXXX {
    public static int countSubstrings(String s) {
        //定义dp数组
        int len = s.length();
        boolean[][] dp = new boolean[len][len];

        //初始化dp数组
        int count = 0;
        //遍历dp数组
        //从字符串尾部开始遍历
        for (int i = len - 1; i >= 0; i--) {
            for (int j = i; j < len; j++) {
                //如果i位置和j位置的值不相同，一定不是回文字符串
                if (s.charAt(i) != s.charAt(j)) {
                    dp[i][j] = false;
                } else {
                    //如果i和j位置的字符相同，并且i和j位置相差不超过2 说明 aba这种情况
                    if (j - i <= 2) {
                        dp[i][j] = true;
                        count++;
                    } else {
                        //如果i位置和j位置字符相同，位置差超过2 则需要判断 i+1和j-1位置是否是回文字符串
                        if (dp[i + 1][j - 1]) {
                            count++;
                            dp[i][j] = true;
                        }
                    }
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int count = countSubstrings("adbc");
        System.out.println(count);
    }

}
