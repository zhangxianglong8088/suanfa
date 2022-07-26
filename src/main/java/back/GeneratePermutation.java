package back;

import java.util.ArrayList;
import java.util.List;

/**
 * @description：
 * @author: zhangxianglong
 * @date: 2022/7/26
 */
public class GeneratePermutation {

    public static String[] generatePermutation(String s) {

        boolean[] flag = new boolean[s.length()];

        List<String> res = new ArrayList<>();

        StringBuilder path = new StringBuilder();

        backtracing(res, path, 0, s, flag);

        String[] strings = new String[res.size()];

        for (int i = 0; i < res.size(); i++) {
            strings[i] = res.get(i);
        }

        return strings;
    }


    static void backtracing(List<String> res, StringBuilder path, int index, String s, boolean[] flag) {

        res.add(path.toString());

        if (index >= s.length()) {
            return;
        }

        for (int i = index; i < s.length(); i++) {
            if (i > index && s.charAt(i) == s.charAt(i - 1) && !flag[i - 1]) {
                continue;
            }
            path.append(s.charAt(i));
            flag[i] = true;
            backtracing(res, path, i + 1, s, flag);
            path.deleteCharAt(path.length() - 1);
            flag[i] = false;

        }
    }


    public static void main(String[] args) {
        String s = "aba";
        String[] res = generatePermutation(s);

    }
}


