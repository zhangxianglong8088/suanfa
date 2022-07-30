package math;

import java.util.Arrays;

/**
 * 三数最大的乘积
 *
 * @description： https://www.nowcoder.com/practice/8ae05c2913fe438b8b14f3968f64fc0b?tpId=117&tqId=37830&rp=1&ru=/exam/oj&qru=/exam/oj&sourceUrl=%2Fexam%2Foj%3Fpage%3D3%26tab%3D%25E7%25AE%2597%25E6%25B3%2595%25E7%25AF%2587%26topicId%3D117&difficulty=undefined&judgeStatus=undefined&tags=&title=
 * @author: zhangxianglong
 * @date: 2022/7/29
 */
public class ThreeNumsMultiply {


    public long solve(int[] A) {
        int n = A.length;

        Arrays.sort(A);
        // write code here

        return Math.max((long) A[0] * A[1] * A[n - 1], (long) A[n - 1] * A[n - 2] * A[n - 3]);
    }

}
