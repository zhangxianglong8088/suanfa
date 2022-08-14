package string;

/**
 * https://www.nowcoder.com/practice/11ae12e8c6fe48f883cad618c2e81475?tpId=117&tqId=37842&rp=1&ru=/exam/oj&qru=/exam/oj&sourceUrl=%2Fexam%2Foj%3Fpage%3D1%26tab%3D%25E7%25AE%2597%25E6%25B3%2595%25E7%25AF%2587%26topicId%3D117&difficulty=undefined&judgeStatus=undefined&tags=&title=
 *
 * @description： 两个字符串相加
 * @author: zhangxianglong
 * @date: 2022/5/15
 */
public class StringAddGGG {

    static String solve(String s, String t) {

        if (s.length() <= 0) {
            return t;
        }

        if (t.length() <= 0) {
            return s;
        }

        if (s.length() < t.length()) {
            String tmp = t;
            t = s;
            s = tmp;
        }
        int carry = 0;
        String tmp = "";

        for (int i = s.length() - 1; i >= 0; i--) {
            int stmp = s.charAt(i) - '0';
            int j = i - s.length() + t.length();
            if (j >= 0) {
                int ttmp = t.charAt(j) - '0';
                if ((ttmp + stmp + carry) >= 10) {
                    tmp = ((carry + ttmp + stmp) - 10) + tmp;
                    carry = 1;
                } else {
                    tmp = ((carry + ttmp + stmp)) + tmp;
                    carry = 0;
                }
            } else {
                if (carry + stmp >= 10) {
                    tmp = ((carry + stmp) - 10) + tmp;
                    carry = 1;

                } else {
                    tmp = ((carry + stmp)) + tmp;
                    carry = 0;
                }
            }

        }
        if (carry == 1) {
            tmp = carry + tmp;
        }
        return tmp;
    }

    static String solve2(String s, String t) {

        int carry = 0;
        StringBuilder tmp = new StringBuilder();

        StringBuilder sBuilder = new StringBuilder(s);
        while (sBuilder.length() < t.length()) {
            sBuilder.insert(0, "0");
        }
        s = sBuilder.toString();

        StringBuilder tBuilder = new StringBuilder(t);
        while (s.length() > tBuilder.length()) {
            tBuilder.insert(0, "0");
        }
        t = tBuilder.toString();
        for (int i = s.length() - 1; i >= 0; i--) {
            int stmp = s.charAt(i) - '0';
            int ttmp = t.charAt(i) - '0';

            if (carry + stmp + ttmp >= 10) {
                int sum = carry + stmp + ttmp;
                carry = 1;
                tmp.insert(0, (sum - 10));

            } else {
                int sum = carry + stmp + ttmp;
                carry = 0;
                tmp.insert(0, sum);

            }
        }

        if (carry == 1) {
            tmp.insert(0, carry);
        }

        return tmp.toString();

    }


    public static String solve3(String s, String t) {

        //补齐前缀0
        StringBuilder tBuilder = new StringBuilder(t);

        while (s.length() > tBuilder.length()) {
            tBuilder.insert(0, "0");
        }
        t = tBuilder.toString();

        StringBuilder sBuilder = new StringBuilder(s);
        while (sBuilder.length() < t.length()) {
            sBuilder.insert(0, "0");
        }
        s = sBuilder.toString();

        //s 和t的长度相等定义进位置
        int len = s.length();
        int carry = 0;
        int sum;
        StringBuilder res = new StringBuilder();
        for (int i = len - 1; i >= 0; i--) {
            sum = carry + s.charAt(i) - '0' + t.charAt(i) - '0';
            if (sum >= 10) {
                sum = sum - 10;
                carry = 1;
            } else {
                carry = 0;
            }
            res.insert(0, sum);
        }

        if (carry == 1) {
            res.insert(0, 1);
        }
        return res.toString();
    }


    public static void main(String[] args) {
        String s = "114514";
        String t = "";
        System.out.println(solve3(s, t));

    }

}
