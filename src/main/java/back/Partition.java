package back;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @description：131. 分割回文串  切割问题
 * https://leetcode.cn/problems/palindrome-partitioning/
 * @author: zhangxianglong
 * @date: 2022/6/26
 */
public class Partition {
    public static List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        Deque<String> path = new ArrayDeque<>();
        backtracking(0, s, res, path);
        return res;
    }

    /**
     * 递归函数
     */
    static void backtracking(int index, String s, List<List<String>> res, Deque<String> path) {
        //确定递归函数终止条件
        if (index >= s.length()) {
            res.add(new ArrayList<>(path));
            return;
        }

        //单层递归的逻辑
        for (int i = index; i < s.length(); i++) {
            //i和index之间是否是回文子串，如果是加入到path
            if (isPalindrome(s, index, i)) {
                String sub = s.substring(index, i + 1);
                path.add(sub);
            } else {
                continue;
            }
            backtracking(i + 1, s, res, path);
            path.removeLast();
        }
    }

    static boolean isPalindrome(String s, int startIndex, int end) {
        int left = startIndex;
        int right = end;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "aab";
        List<List<String>> res = partition(s);
        System.out.println(res);
    }
























}
