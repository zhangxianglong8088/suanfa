package string;

/**
 * @description：旋转字符串 https://www.nowcoder.com/practice/95cb356556cf430f912e7bdf1bc2ec8f?tpId=117&tqId=37839&rp=1&ru=/exam/oj&qru=/exam/oj&sourceUrl=%2Fexam%2Foj%3Fpage%3D3%26tab%3D%25E7%25AE%2597%25E6%25B3%2595%25E7%25AF%2587%26topicId%3D117&difficulty=undefined&judgeStatus=undefined&tags=&title=
 * @author: zhangxianglong
 * @date: 2022/7/29
 */
public class RoateString {

    public static boolean solve(String A, String B) {
        // write code here
        return (A + A).contains(B) && A.length() == B.length();
    }

    public static void main(String[] args) {
        String s1 = "youzan";

        String s2 = "zanyou";

        boolean res = solve(s1, s2);

        System.out.println(res);
    }
}
