package math;

/**
 * 43. 字符串相乘
 *
 * @description：https://leetcode.cn/problems/multiply-strings/solution/zi-fu-chuan-xiang-cheng-by-leetcode-solution/
 * @author: zhangxianglong
 * @date: 2022/7/29
 */
public class Multiply {


    public static void main(String[] args) {
        String s1 = "0";
        String s2 = "0";
        String res = multiply(s1, s2);
        System.out.println(res);

    }

    /**
     * 解法参考：https://leetcode.com/problems/multiply-strings/discuss/17605/Easiest-JAVA-Solution-with-Graph-Explanation
     *
     * @param num1
     * @param num2
     * @return
     */

    public static String multiply(String num1, String num2) {

        //定义数组存储结果
        int n1 = num1.length();
        int n2 = num2.length();

        //两个数相乘的结果最大的长度
        int[] mul = new int[n1 + n2];

        //双层循环遍历 num1和nums2
        for (int i = n1 - 1; i >= 0; i--) {
            for (int j = n2 - 1; j >= 0; j--) {

                //首先i位置和j位置的数相乘
                int bitmul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');

                // 结果先加低位判断是否有新的进位
                bitmul += mul[i + j + 1];
                //给低位重新赋值
                mul[i + j + 1] = bitmul % 10;
                //给高位赋值
                mul[i + j] += bitmul / 10;
            }
        }

        //返回结果
        StringBuilder s = new StringBuilder();

        //是否第一次遇到0
        boolean firstNoZero = false;

        for (int j : mul) {
            if (!firstNoZero && j == 0) {
                continue;
            }
            firstNoZero = true;
            s.append(j);

        }
        //如果最终一直没有遇到非0的数，那么结果就是0
        if (!firstNoZero) {
            return "0";
        }

        return s.toString();

    }
}
