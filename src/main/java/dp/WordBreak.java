package dp;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * 139. 单词拆分
 *
 * @description：https://leetcode.cn/problems/word-break/comments/
 * @author: zhangxianglong
 * @date: 2022/7/23
 */
public class WordBreak {
    /**
     * @param s
     * @param wordDict
     * @return
     */
    public static boolean wordBreak(String s, List<String> wordDict) {
        // write code here
        HashSet<String> set = new HashSet<>();

        for (String word : wordDict) {
            //先移除重复字符串
            set.add(word);
        }

        //dp[i]表示s字符串中前i个字符是不是set的子集
        boolean[] dp = new boolean[s.length() + 1];
        //空串可以被词表中的词表示
        dp[0] = true;

        for (int end = 1; end <= s.length(); end++) {
            for (int start = 0; start < end; start++) {
                if (dp[start] && set.contains(s.substring(start, end))) {
                    //s[0:start]是set的子集，s[start:end]也是set的子集，所以s[0:end]是set的子集，dp[end]=true
                    dp[end] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }

    public static void main(String[] args) {
        String s = "leetcodehello";
        List<String> list = new ArrayList<>();
        list.add("leeet");
        list.add("code");
        list.add("helloworld");

        boolean res = wordBreak(s, list);

        System.out.println(res);
    }
}
