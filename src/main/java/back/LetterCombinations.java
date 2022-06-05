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

    static List<String> res = new ArrayList<>();
    static StringBuilder temp = new StringBuilder();

    public static List<String> letterCombinations(String digits) {
        String[] numString = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

        if (digits == null || digits.length() == 0) {
            return res;
        }
        backTracking(digits, numString, 0);
        return res;
    }

    //递归方法
    static void backTracking(String digits, String[] numString, int n) {

        //1、确定递归终止条件
        if (temp.length() == digits.length()) {
            res.add(temp.toString());
            return;
        }

        String str = numString[digits.charAt(n) - '0'];

        for (int i = 0; i < str.length(); i++) {
            temp.append(str.charAt(i));
            backTracking(digits, numString, n + 1);
            temp.deleteCharAt(temp.length() - 1);
        }
    }

    public static void main(String[] args) {
        List<String> res = letterCombinations("");
    }
}
