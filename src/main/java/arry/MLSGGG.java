package arry;

import java.util.HashSet;
import java.util.Set;

/**
 * NC95 数组中的最长连续子序列
 * https://www.nowcoder.com/practice/eac1c953170243338f941959146ac4bf?tpId=117&tqId=37810&rp=1&ru=/exam/oj&qru=/exam/oj&sourceUrl=%2Fexam%2Foj%3Fpage%3D2%26tab%3D%25E7%25AE%2597%25E6%25B3%2595%25E7%25AF%2587%26topicId%3D117&difficulty=undefined&judgeStatus=undefined&tags=&title=
 *
 * @description：
 * @author: zhangxianglong
 * @date: 2022/7/29
 */
public class MLSGGG {

    public static int MLS(int[] arr) {

        Set<Integer> set = new HashSet<>();
        for (int num : arr) {
            set.add(num);
        }
        int maxLen = 0;

        for (int i = 0; i < arr.length; i++) {

            if (!set.contains(arr[i] - 1)) {
                int subMax = 0;
                int cur = arr[i];
                while (set.contains(cur)) {
                    subMax++;
                    cur++;
                }
                maxLen = Math.max(maxLen, subMax);
            }
        }
        return maxLen;
    }


    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 1};
        int res = MLS(nums);
        System.out.println(res);
    }
}
