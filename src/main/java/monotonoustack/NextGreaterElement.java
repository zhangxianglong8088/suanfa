package monotonoustack;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @description：496. 下一个更大元素
 * https://leetcode.cn/problems/next-greater-element-i/
 * @author: zhangxianglong
 * @date: 2022/6/27
 */
public class NextGreaterElement {


    /**
     * 暴力解法
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public static int[] nextGreaterElement1(int[] nums1, int[] nums2) {

        int[] res = new int[nums1.length];
        Arrays.fill(res, -1);
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            int n1 = nums1[i];
            for (int j = 0; j < nums2.length; j++) {
                if (n1 == nums2[j]) {
                    map.put(nums1[i], j);
                }
            }
        }

        for (int i = 0; i < nums1.length; i++) {
            int n1 = nums1[i];
            for (int j = map.get(n1); j < nums2.length; j++) {
                if (n1 < nums2[j]) {
                    res[i] = nums2[j];
                    break;
                }
            }

        }
        return res;
    }

    /**
     * 单调栈思路
     *
     * @param nums1
     * @param nums2
     * @return
     */
    public static int[] nextGreaterElement2(int[] nums1, int[] nums2) {

        int[] res = new int[nums1.length];
        Arrays.fill(res, -1);

        Map<Integer, Integer> map = new HashMap<>();
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < nums1.length; i++) {
            map.put(nums1[i], i);
        }
        stack.push(0);
        for (int j = 1; j < nums2.length; j++) {
            if (nums2[j] < nums2[stack.peek()]) {
                stack.push(j);
            } else {
                while (!stack.isEmpty() && nums2[stack.peek()] < nums2[j]) {
                    if (map.containsKey(nums2[stack.peek()])) {
                        res[map.get(nums2[stack.peek()])] = nums2[j];
                    }
                    stack.pop();
                }
                stack.push(j);
            }
        }
        return res;
    }


    public static void main(String[] args) {
        int[] nums1 = new int[]{4, 1, 2};
        int[] nums2 = new int[]{1, 3, 4, 2};

        int[] res = nextGreaterElement2(nums1, nums2);
    }

}
