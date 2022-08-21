package dp;

/**
 * https://leetcode.cn/problems/palindromic-substrings/
 * 这个题是求回文子串的个数
 *
 * @description：647. 回文子串
 * @author: zhangxianglong
 * @date: 2022/5/27
 */
public class CountSubstrings {

    public static int countSubstrings(String s) {
        //定义dp数组 dp数组的含义是 j到i之间 的字符串是否是回文字符串
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int count = 0;

        //遍历dp数组 abcdcba
        //1、 如果 nums[i]==nums[j] 并且 j-i<2 那么j到i之间一定是回文字符串
        //2、如果nums[i]!=nums[j] 就看 dp[i-1][j+1]是否是回文字符串
        for (int i = 0; i < n; i++) {
            char s1 = s.charAt(i);
            for (int j = 0; j <= i; j++) {
                char s2 = s.charAt(j);
                if (s1 == s2) {
                    if (i - j <= 2) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i - 1][j + 1];
                    }
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (dp[i][j]) {
                    count++;
                }
            }
        }
        return count;
    }


    /**
     * 我的第二个思路 为什么不行*******
     * 状态转移方程
     * <p>
     * for (int i = 0; i < n; i++) {
     * char s1 = s.charAt(i);
     * for (int j = 0; j <= i; j++) {
     * char s2 = s.charAt(j);
     * if (i == j) {
     * continue;
     * }
     * if (s1 == s2) {
     * dp[i][j] = dp[i - 1][j + 1];//这里为什么不对  因为当i和j的距离相差1 的时候有问题 j比i就大了
     * }else{
     * dp[i][j]  = false;
     * }
     * }
     * }
     *
     * @param s
     * @return
     */
    public static int countSubstrings2(String s) {
        //定义dp数组 dp数组的含义是 j到i之间 的字符串是否是回文字符串
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int count = 0;

        for (int i = 0; i < n; i++) {
            dp[i][i] = true;
        }

        //遍历dp数组 abcdcba
        //1、 如果 nums[i]==nums[j] 并且 j-i<2 那么j到i之间一定是回文字符串
        //2、如果nums[i]!=nums[j] 就看 dp[i-1][j+1]是否是回文字符串
        for (int i = 0; i < n; i++) {
            char s1 = s.charAt(i);
            for (int j = 0; j <= i; j++) {
                char s2 = s.charAt(j);
                if (i == j) {
                    continue;
                }
                if (s1 == s2) {
                    if (i - j <= 2) {
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = dp[i - 1][j + 1];
                    }
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (dp[i][j]) {
                    count++;
                }
            }
        }
        return count;
    }


    public static int countSubstrings3(String s) {

        int n = s.length();
        //dp[i][j] 表示ij之间是否为回文字符串
        boolean[][] dp = new boolean[n][n];

        for (int i = 0; i < n; i++) {
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
        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (dp[i][j]) {
                    res++;
                }

            }
        }
        return res;
    }


    public static void main(String[] args) {
        String s = "aaa";
        int res = countSubstrings3(s);
        System.out.println(res);
    }


}
