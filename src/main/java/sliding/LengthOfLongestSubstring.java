package sliding;

import java.util.*;

/**
 * @description：3. 无重复字符的最长子串
 * https://leetcode.cn/problems/longest-substring-without-repeating-characters/
 * @author: zhangxianglong
 * @date: 2022/5/20
 */
public class LengthOfLongestSubstring {

    /**
     * 滑动窗口思路
     * https://www.bilibili.com/video/BV113411v7Ak?spm_id_from=333.337.search-card.all.click&vd_source=33330ceec8563c17ba9362183caf534a
     *
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring(String s) {
        // write code here
        int left = 0;
        int right = 0;
        int n = s.length();
        int maxLen = 0;

        Set<Character> set = new HashSet<>();

        while (right < n) {

            while (set.contains(s.charAt(right))) {
                set.remove(s.charAt(left));
                left++;

            }
            set.add(s.charAt(right));
            right++;
            maxLen = Math.max(maxLen, set.size());
        }

        return maxLen;


    }

    public static void main(String[] args) {

        String s = "pwwkew";
        int length = lengthOfLongestSubstring(s);
        System.out.println(length);

    }
}
