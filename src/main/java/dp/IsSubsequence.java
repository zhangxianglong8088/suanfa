package dp;

/**
 * @description：
 * @author: zhangxianglong
 * @date: 2022/7/28
 */
public class IsSubsequence {


    /**
     * @return
     */
    public static boolean isSubsequence(String text1, String text2) {

        // 先对dp数组做初始化操作
        int[][] dp = new int[text1.length() + 1][text2.length() + 1];
        for (int i = 1; i <= text1.length(); i++) {
            char char1 = text1.charAt(i - 1);
            for (int j = 1; j <= text2.length(); j++) {
                char char2 = text2.charAt(j - 1);
                // 开始列出状态转移方程
                if (char1 == char2) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        int res = dp[text1.length()][text2.length()];
        return res == text1.length();
    }

    public static void main(String[] args) {
        String s = "abc";
        String t = "ahbgdc";
        boolean res = isSubsequence(s, t);
        System.out.println(res);
    }
}
