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
    public static int lengthOfLongestSubstring3(String s) {

        if (Objects.equals(s, "")) {
            return 0;
        }
        int left = 0;
        int right = 0;
        int curLen = 0;
        int maxLen = 0;

        Set<Character> set = new HashSet<>();


        while (right < s.length()) {

            if (!set.contains(s.charAt(right))) {
                set.add(s.charAt(right));
                curLen++;
                maxLen = Math.max(curLen, maxLen);
                right++;
            } else {
                while (set.contains(s.charAt(right))) {
                    set.remove(s.charAt(left));
                    left++;
                    curLen--;
                }
                set.add(s.charAt(right));
                curLen++;
                right++;
            }
        }
        return maxLen;
    }

    /**
     * 第二个思路
     *
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring(String s) {
        if (Objects.equals(s, "")) {
            return 0;
        }
        int left = 0;
        int right = 0;
        int length = Integer.MIN_VALUE;

        Map<Character, Integer> map = new HashMap<>();

        while (right < s.length()) {
            char c = s.charAt(right);
            right++;
            map.put(c, map.getOrDefault(c, 0) + 1);

            //是否需要缩短窗口
            while (map.get(c) > 1) {
                char d = s.charAt(left);
                left++;
                map.put(d, map.getOrDefault(d, 0) - 1);
            }

            length = Math.max(right - left, length);
        }
        return length;
    }


    public static void main(String[] args) {

        String s = "pwwkew";
        int length = lengthOfLongestSubstring3(s);
        System.out.println(length);

    }


}
