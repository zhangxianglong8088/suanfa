package back;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.cn/problems/letter-combinations-of-a-phone-number/
 *
 * @description：17. 电话号码的字母组合
 * @author: zhangxianglong
 * @date: 2022/6/1
 */
public class LetterCombinations {


    public static List<String> letterCombinations(String digits) {
        String[] numString = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

        if (digits.isEmpty()) {
            return new ArrayList();
        }
        List<String> res = new ArrayList<>();
        StringBuilder path = new StringBuilder();

        backTracking(res, path, digits, numString, 0);
        return res;
    }

    //递归方法
    static void backTracking(List<String> res, StringBuilder path, String digits, String[] numString, int n) {

        //1、确定递归终止条件
        if (path.length() == digits.length()) {
            res.add(path.toString());
            return;
        }

        String str = numString[digits.charAt(n) - '0'];

        for (int i = 0; i < str.length(); i++) {
            path.append(str.charAt(i));
            backTracking(res, path, digits, numString, n + 1);
            path.deleteCharAt(path.length() - 1);
        }
    }

    public static void main(String[] args) {
        List<String> res = letterCombinations("");
    }
}
