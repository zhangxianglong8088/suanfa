package string;

/**
 * NC103 反转字符串
 * https://www.nowcoder.com/practice/c3a6afee325e472386a1c4eb1ef987f3?tpId=117&tqId=37827&rp=1&ru=/exam/oj&qru=/exam/oj&sourceUrl=%2Fexam%2Foj%3Fpage%3D1%26tab%3D%25E7%25AE%2597%25E6%25B3%2595%25E7%25AF%2587%26topicId%3D117&difficulty=undefined&judgeStatus=undefined&tags=&title=
 *
 * @author: zhangxianglong
 * @date: 2022/5/28
 */
public class ReverseString {

    public static String reverseString(String s) {

        char[] ch = s.toCharArray();
        int left = 0;
        int right = ch.length - 1;

        while (left < right) {
            char tmp = ch[left];
            ch[left] = ch[right];
            ch[right] = tmp;
            left++;
            right--;
        }
        return String.valueOf(ch);
    }

    public static void main(String[] args) {
        String s = "hello";
        String res = reverseString(s);
        System.out.println(res);
    }
}
