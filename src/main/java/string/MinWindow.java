package string;

import java.util.HashMap;
import java.util.Map;

/**
 * 最小覆盖子串 滑动窗口 76
 *
 * @description： https://leetcode.cn/problems/minimum-window-substring/
 * 思路：用左右两个指针遍历s字符串，当滑动窗口中的字符不能覆盖t中的字符时，右指针右移，扩大窗口，把右边的字符加入滑动窗口，当滑动窗口中的字符能覆盖t中的字符时，不断左移左指针，缩小窗口，直到窗口中的字符刚好能覆盖t中的字符，这个时候在左移就不能覆盖t中的字符了，在指针移动的过程中，不断更新最小覆盖子串
 * 复杂度：时间复杂度o(n)，n是s的长度，空间复杂度o(t)，t是字符集的大小
 * <p>
 * 作者：chen-wei-f
 * 链接：https://leetcode.cn/problems/minimum-window-substring/solution/76-zui-xiao-fu-gai-zi-chuan-hua-dong-chu-dvlt/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 * @author: zhangxianglong
 * @date: 2022/5/22
 */
public class MinWindow {

    public static String minWindow(String s, String t) {

        Map<Character, Integer> needMap = new HashMap<Character, Integer>();
        Map<Character, Integer> windowsMap = new HashMap<Character, Integer>();

        for (char c : t.toCharArray()) {
            needMap.put(c, needMap.getOrDefault(c, 0) + 1);
        }

        int left = 0, right = 0;
        int valid = 0;
        int start = 0, end = 0, len = Integer.MAX_VALUE;


        while (right < s.length()) {

            char c = s.charAt(right);
            right++;

            if (needMap.containsKey(c)) {
                windowsMap.put(c, windowsMap.getOrDefault(c, 0) + 1);
                if (windowsMap.get(c).equals(needMap.get(c))) {
                    valid++;
                }
            }

            //是否缩小窗口
            while (valid == needMap.size()) {
                if (right - left < len) {
                    len = right - left;
                    start = left;
                }
                char d = s.charAt(left);
                left++;
                if (windowsMap.containsKey(d)) {
                    if (windowsMap.get(d).equals(needMap.get(d))) {
                        valid--;
                    }
                    windowsMap.put(d, windowsMap.getOrDefault(d, 0) - 1);
                }
            }
        }
        return len == Integer.MAX_VALUE ? "" : s.substring(start, start + len);
    }
}
