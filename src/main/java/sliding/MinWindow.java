package sliding;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

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

        int left = 0;
        int right = 0;

        //这里valid的含义是 满足条件的字符个数，也就是说need中需要的字符以及这个字符的数量 window已经足够了 valid++
        int valid = 0;

        int start = 0;
        int len = Integer.MAX_VALUE;


        while (right < s.length()) {
            char c = s.charAt(right);
            right++;

            if (needMap.containsKey(c)) {
                windowsMap.put(c, windowsMap.getOrDefault(c, 0) + 1);
                //当前字符需要的个数和出现的个数相同 就说明满足条件了
                if (windowsMap.get(c).equals(needMap.get(c))) {
                    valid++;
                }
            }

            //找到了一个满足条件的窗口 这时候开始考虑缩小窗口 判断缩小窗口后是否还有最优解
            while (valid == needMap.size()) {
                //right-left <len 表示找到了一个最小值
                if (right - left < len) {
                    //重新给len赋值长度
                    len = right - left;
                    //用start记录当前满足条件字符的开始位置
                    start = left;
                }
                char d = s.charAt(left);
                left++;
                //判断窗口变小之后的影响
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

    public static void main(String[] args) {
        String s = "a";
        String t = "aa";

        String res = minWindow2(s, t);
        System.out.println(res);
    }


    /**
     * 自己理解的思路
     *
     * @param s
     * @param t
     * @return
     */
    public static String minWindow2(String s, String t) {
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();

        //将t字符串装入need map中
        for (Character c : t.toCharArray()) {
            need.put(c, need.getOrDefault(c, 0) + 1);
        }

        //定义左右指针
        int left = 0;
        int right = 0;
        int valid = 0;

        int len = Integer.MAX_VALUE;
        int start = 0;

        while (right < s.length()) {

            //不断增加窗口的大小 找到一个解
            if (need.containsKey(s.charAt(right))) {
                window.put(s.charAt(right), window.getOrDefault(s.charAt(right), 0) + 1);
                if (Objects.equals(need.get(s.charAt(right)), window.get(s.charAt(right)))) {
                    valid++;
                }
            }

            right++;
            //开始考虑缩小窗口
            while (valid == need.size()) {
                if (right - left < len) {
                    len = right - left;
                    start = left;
                }
                //这里必需要用d保存 s.charAt(left); 因为left的指已经变了
                char d = s.charAt(left);
                left++;
                //判断缩小窗口的影响
                if (window.containsKey(d)) {
                    if (Objects.equals(need.get(d), window.get(d))) {
                        valid--;
                    }
                    window.put(d, window.getOrDefault(d, 0) - 1);
                }

            }
        }

        return len == Integer.MAX_VALUE ? "" : s.substring(start, start + len);
    }

}
