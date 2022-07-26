package bit;

/**
 * @description： NC112 进制转换
 * https://www.nowcoder.com/practice/2cc32b88fff94d7e8fd458b8c7b25ec1?tpId=117&tqId=37836&rp=1&ru=/exam/oj&qru=/exam/oj&sourceUrl=%2Fexam%2Foj%3Fpage%3D1%26tab%3D%25E7%25AE%2597%25E6%25B3%2595%25E7%25AF%2587%26topicId%3D117&difficulty=undefined&judgeStatus=undefined&tags=&title=
 * @author: zhangxianglong
 * @date: 2022/7/24
 */
public class BitCovers {

    /**
     * 除 N 取余，然后倒序排列，高位补零
     * 进制转换
     *
     * @param M int整型 给定整数
     * @param N int整型 转换到的进制
     * @return string字符串
     */
    public static String solve(int M, int N) {
        // write code here
        int m = Math.abs(M);
        String s = "0123456789ABCDEF";
        StringBuilder sb = new StringBuilder();

        while (m > 0) {
            sb.append(s.charAt(m % N));
            m /= N;
        }
        if (M < 0) {
            sb.append("-");
        }

        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        int m = 7;
        int n = 2;

        String res = solve(m, n);

        System.out.println(res);

    }
}
