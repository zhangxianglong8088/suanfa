package string;

/**
 * @description：旋转字符串 https://www.nowcoder.com/practice/80b6bb8797644c83bc50ac761b72981c?tpId=117&rp=1&ru=%2Fexam%2Foj&qru=%2Fexam%2Foj&sourceUrl=%2Fexam%2Foj%3Fpage%3D3%26tab%3D%25E7%25AE%2597%25E6%25B3%2595%25E7%25AF%2587%26topicId%3D117&difficulty=&judgeStatus=&tags=&title=%E6%97%8B%E8%BD%AC%E5%AD%97%E7%AC%A6%E4%B8%B2&gioEnter=menu
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
