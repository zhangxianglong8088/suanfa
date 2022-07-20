package hash;

import java.util.*;

/**
 * 49. 字母异位词分组
 * 排序相同的字符串放到一起
 *
 * @description：https://leetcode.cn/problems/group-anagrams/
 * @author: zhangxianglong
 * @date: 2022/5/24
 */
public class GroupAnagramsGGG {

    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> listList = new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();

        for (int i = 0; i < strs.length; i++) {
            char[] c = strs[i].toCharArray();
            Arrays.sort(c);
            String key = String.valueOf(c);
            List<String> list = map.getOrDefault(key, new ArrayList<>());
            list.add(strs[i]);
            map.put(key, list);
        }
        listList.addAll(map.values());
        return listList;
    }

    public static void main(String[] args) {
        String[] strs = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};

        List<List<String>> list = groupAnagrams3(strs);
    }

    public static List<List<String>> groupAnagrams3(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (int i = 0; i < strs.length; i++) {
            String s = strs[i];
            char[] c = s.toCharArray();
            Arrays.sort(c);
            List<String> list = map.get(String.valueOf(c));

            if (list == null) {
                List<String> subList = new ArrayList<>();
                subList.add(strs[i]);
                map.put(String.valueOf(c), subList);
            } else {
                map.get(String.valueOf(c)).add(strs[i]);
            }
        }
        return new ArrayList<>(map.values());
    }
}
