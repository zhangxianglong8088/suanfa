package sliding;

import java.util.*;

/**
 * 567. 字符串的排列 滑动窗口
 *
 * @description： 给你两个字符串s1和s2 ，写一个函数来判断 s2 是否包含 s1的排列。如果是，返回 true ；否则，返回 false 。
 * <p>
 * 换句话说，s1 的排列之一是 s2 的 子串 。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/permutation-in-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: zhangxianglong
 * @date: 2022/5/23
 */
public class CheckInclusion {

    public static boolean checkInclusion(String s1, String s2) {
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();

        for (char c : s1.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        int left = 0;
        int right = 0;
        int valid = 0;

        while (right < s2.length()) {
            char c = s2.charAt(right);
            right++;
            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (need.get(c).equals(window.get(c))) {
                    valid++;
                }
            }

            //只有在right - left == need.size()的情况下才有可能有符合条件的解
            while (right - left >= s1.length()) {
                if (valid == need.size()) {
                    return true;
                }

                char d = s2.charAt(left);
                if (need.containsKey(d)) {
                    if (window.get(d).equals(need.get(d))) {
                        valid--;
                    }
                    window.put(d, window.get(d) - 1);
                }
                left++;
            }

        }
        return false;
    }

    public static void main(String[] args) {


        String s1 = "ab";
        String s2 = "eidboaoo";
        StringBuilder s =new StringBuilder();
        System.out.println(checkInclusion2(s1, s2));
    }

    /**
     * 自己理解的思路
     *
     * @param s1
     * @param s2
     * @return
     */
    public static boolean checkInclusion2(String s1, String s2) {
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();

        int left = 0;
        int right = 0;
        int valid = 0;

        for (Character c : s1.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        while (right < s2.length()) {
            Character c = s2.charAt(right);
            right++;
            if (need.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (Objects.equals(need.get(c), window.get(c))) {
                    valid++;
                }
            }

            //考虑缩小窗口 窗口开始缩小的条件
            while (right - left >= s1.length()) {
                if (valid == need.size()) {
                    return true;
                }
                Character d = s2.charAt(left);
                left++;
                if (window.containsKey(d)) {
                    if (Objects.equals(need.get(d), window.get(d))) {
                        valid--;
                    }
                    window.put(d, window.getOrDefault(d, 0) - 1);
                }
            }

        }
        return false;
    }
}
