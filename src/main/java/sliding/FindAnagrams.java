package sliding;

import java.util.*;

/**
 * 438. 找到字符串中所有字母异位词
 *
 * @description： https://leetcode.cn/problems/find-all-anagrams-in-a-string/
 * @author: zhangxianglong
 * @date: 2022/7/5
 */
public class FindAnagrams {

    /**
     * 滑动窗口
     *
     * @param s
     * @param p
     * @return
     */
    public static List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();

        int left = 0;
        int right = 0;
        int valid = 0;

        for (Character c : p.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        while (right < s.length()) {
            Character c = s.charAt(right);
            right++;
            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (Objects.equals(need.get(c), window.get(c))) {
                    valid++;
                }
            }

            //考虑缩小窗口 窗口开始缩小的条件
            while (right - left >= p.length()) {
                if (valid == need.size()) {
                    res.add(left);
                }
                Character d = s.charAt(left);
                left++;
                if (window.containsKey(d)) {
                    if (Objects.equals(need.get(d), window.get(d))) {
                        valid--;
                    }
                    window.put(d, window.getOrDefault(d, 0) - 1);
                }
            }

        }
        return res;
    }

    public static void main(String[] args) {
        String s = "cbaebabacd";
        String p = "abc";

        List<Integer> res = findAnagrams(s, p);

    }
}
