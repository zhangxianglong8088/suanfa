//package back;
//
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * @description：93. 复原 IP 地址
// * https://leetcode.cn/problems/restore-ip-addresses/
// * @author: zhangxianglong
// * @date: 2022/6/26
// */
//public class RestoreIpAddresses {
//
//    public List<String> restoreIpAddresses(String s) {
//        List<String> res = new ArrayList<>();
//        int num = 0;
//        backtracking();
//    }
//
//    void backtracking(List<String> res, String s, int num, int index) {
//        //确认递归终止条件
//        if (num == 3) {
//            res.add(s);
//            return;
//        }
//
//        for (int i = index; i < s.length(); i++) {
//            if (isValid(s, index, i)) {
//                s = s.substring(0, i + 1) + "." + s.substring(i + 1);
//            }
//            //path.add()
//            backtracking();
//            //path.removeLast
//        }
//    }
//
//    // 判断字符串s在左闭⼜闭区间[start, end]所组成的数字是否合法
//    private Boolean isValid(String s, int start, int end) {
//        if (start > end) {
//            return false;
//        }
//        if (s.charAt(start) == '0' && start != end) { // 0开头的数字不合法
//            return false;
//        }
//        int num = 0;
//        for (int i = start; i <= end; i++) {
//            if (s.charAt(i) > '9' || s.charAt(i) < '0') { // 遇到⾮数字字符不合法
//                return false;
//            }
//            num = num * 10 + (s.charAt(i) - '0');
//            if (num > 255) { // 如果⼤于255了不合法
//                return false;
//            }
//        }
//        return true;
//    }
//}
