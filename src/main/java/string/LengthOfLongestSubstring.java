package string;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @description：3. 无重复字符的最长子串
 * https://leetcode.cn/problems/longest-substring-without-repeating-characters/
 * @author: zhangxianglong
 * @date: 2022/5/20
 */
public class LengthOfLongestSubstring {

    public static int lengthOfLongestSubstring(String s) {
        if(Objects.equals(s, "")){
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
        int length = lengthOfLongestSubstring(s);
        System.out.println(length);

    }
}
