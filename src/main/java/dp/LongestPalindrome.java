package dp;

/**
 * 最长回文子串
 * https://leetcode.cn/problems/longest-palindromic-substring/solution/zui-chang-hui-wen-zi-chuan-by-leetcode-solution/
 *
 * @description： 给你一个字符串 s，找到 s 中最长的回文子串。
 * @author: zhangxianglong
 * @date: 2022/5/22
 */
public class LongestPalindrome {

    public String longestPalindrome(String s) {
        String res = "";
        for (int i = 0; i < s.length(); i++) {
            // 以 s[i] 为中心的最长回文子串
            String s1 = palindrome(s, i, i);
            // 以 s[i] 和 s[i+1] 为中心的最长回文子串
            String s2 = palindrome(s, i, i + 1);
            // res = longest(res, s1, s2)
            res = res.length() > s1.length() ? res : s1;
            res = res.length() > s2.length() ? res : s2;
        }
        return res;


    }

    // 在 s 中寻找以 s[l] 和 s[r] 为中心的最长回文串
    String palindrome(String s, int l, int r) {
        // 防止索引越界
        while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
            // 双指针，向两边展开
            l--;
            r++;
        }
        // 返回以 s[l] 和 s[r] 为中心的最长回文串
        return s.substring(l + 1, r);
    }

    /**
     * 动态规划
     *
     * @param s
     * @return
     */
    public static String longestPalindrome2(String s) {
        int len = s.length();
        boolean[][] dp = new boolean[len][len];

        for (int i = 0; i < s.length(); i++) {
            dp[i][i] = true;
        }

        for (int i = 0; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    if (i - j <= 2) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i - 1][j + 1];
                    }
                }
            }
        }
        int maxLen = 0;
        String huinwe = "";
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j <= i; j++) {
                if (dp[i][j] && (i - j + 1) > maxLen) {
                    maxLen = i - j + 1;
                    huinwe = s.substring(j, i + 1);
                }
            }
        }
        return huinwe;
    }

    public static void main(String[] args) {
        String res = longestPalindrome3("bb");
        System.out.println(res);
    }

    public static String longestPalindrome3(String s) {

        int n = s.length();

        //dp[i,j] 区间是否是一个回文子串
        boolean[][] dp = new boolean[n][n];

        for (int i = 0; i < s.length(); i++) {
            dp[i][i] = true;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    if (i - j <= 2) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i - 1][j + 1];
                    }
                }
            }
        }
        int max = 0;
        int maxI = 0;
        int maxJ = 0;
        for (int i = 0; i < n; i++) {

            for (int j = 0; j < i; j++) {
                if (dp[i][j] && i - j > max) {
                    max = i - j;
                    maxI = i;
                    maxJ = j;
                }
            }
        }

        return s.substring(maxJ, maxI + 1);

    }

}
