package dp;

/**
 * @description：NC228 判断子序列
 * https://www.nowcoder.com/practice/39be6c2d0a9b4c30a7b04053d5960a84?tpId=117&rp=1&ru=%2Fexam%2Foj&qru=%2Fexam%2Foj&sourceUrl=%2Fexam%2Foj%3Fpage%3D2%26tab%3D%25E7%25AE%2597%25E6%25B3%2595%25E7%25AF%2587%26topicId%3D117&difficulty=&judgeStatus=&tags=&title=%E5%AD%90%E5%BA%8F%E5%88%97&gioEnter=menu
 * 给定两个字符串 S 和 T ，判断 S 是否是 T 的子序列。
 * 即是否可以从 T 删除一些字符转换成 S。
 * @author: zhangxianglong
 * @date: 2022/7/28
 */
public class IsSubsequence {


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
        String s = "nowef";
        String t = "nowcoder";
        boolean res = isSubsequence(s, t);
        System.out.println(res);
    }

}
