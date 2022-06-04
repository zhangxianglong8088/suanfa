package hash;

import jdk.nashorn.internal.ir.IdentNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 242. 有效的字母异位词
 *
 * @description：https://leetcode.cn/problems/valid-anagram/
 * @author: zhangxianglong
 * @date: 2022/6/4
 */
public class IsAnagram {


    public static boolean isAnagram(String s, String t) {

        Map<Character, Integer> map = new HashMap<>();
        char[] c = s.toCharArray();
        for (int i = 0; i < c.length; i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }

        for (char ch : t.toCharArray()) {
            Integer r = map.get(ch);
            if (r == null) {
                return false;
            } else {
                map.put(ch, map.get(ch) - 1);
            }
        }
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            Integer time = entry.getValue();
            if (time != 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "rat";
        String t = "car";
        isAnagram(s, t);
    }
}
