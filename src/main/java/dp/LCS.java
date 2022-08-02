package dp;

/**
 * https://www.nowcoder.com/practice/f33f5adc55f444baa0e0ca87ad8a6aac?tpId=117&tqId=37799&rp=1&ru=/exam/oj&qru=/exam/oj&sourceUrl=%2Fexam%2Foj%3Fpage%3D1%26tab%3D%25E7%25AE%2597%25E6%25B3%2595%25E7%25AF%2587%26topicId%3D117&difficulty=undefined&judgeStatus=undefined&tags=&title=
 *
 * @description：NC127 最长公共子串
 * @author: zhangxianglong
 * @date: 2022/7/29
 */
public class LCS {

    /**
     * @param str1
     * @param str2
     * @return
     */
    public static String LCS(String str1, String str2) {

        //定义dp数组

        //dp[i][j] ：以下标i - 1为结尾的A，和以下标j - 1为结尾的B，最长重复子数组长度为dp[i][j]。

        int[][] dp = new int[str1.length() + 1][str2.length() + 1];

        //初始化dp数组
        int result = 0;
        int maxI = 0;
        int maxJ = 0;

        //遍历dp数组
        for (int i = 1; i <= str1.length(); i++) {
            for (int j = 1; j <= str2.length(); j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    if (dp[i][j] > result) {
                        result = dp[i][j];
                        maxI = i;
                    }
                }
            }
        }
        //返回
        return str1.substring(maxI - result, maxI);

    }

    public static void main(String[] args) {
        String str1 = "1AB2345CD";
        String str2 = "12345EF";

        String res = LCS2(str1, str2);

        System.out.println(res);
    }


    public static String LCS2(String str1, String str2) {
        // write code here
        int n1 = str1.length();
        int n2 = str2.length();

        // i结尾的 Str1 和j结尾的Str2的最长公共子串的长度
        int[][] dp = new int[n1 + 1][n2 + 1];

        int maxI = 0;
        int maxJ = 0;
        int maxLen = 0;

        for (int i = 1; i <= n1; i++) {

            for (int j = 1; j <= n2; j++) {

                if (str1.charAt(i-1) == str2.charAt(j-1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    if (dp[i][j] > maxLen) {
                        maxI = i;
                        maxJ = j;
                        maxLen = dp[i][j];
                    }
                }
            }

        }
        return str1.substring(maxI - maxLen,maxI );
    }
}
