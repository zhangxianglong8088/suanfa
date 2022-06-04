package hash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @description：349. 两个数组的交集
 * https://leetcode.cn/problems/intersection-of-two-arrays/
 * 给定两个数组 nums1 和 nums2 ，返回 它们的交集 。输出结果中的每个元素一定是 唯一 的。我们可以 不考虑输出结果的顺序 。
 * @author: zhangxianglong
 * @date: 2022/6/4
 */
public class Intersection {

    public static int[] intersection(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < nums1.length; i++) {
            map.put(nums1[i], nums1[i]);
        }

        for (int i = 0; i < nums2.length; i++) {
            Integer res = map.get(nums2[i]);
            if (res != null && !list.contains(nums2[i])) {
                list.add(nums2[i]);
            }
        }
        int[] arr = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            arr[i] = list.get(i);
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{4, 9, 5};
        int[] nums2 = new int[]{9, 4, 9, 8, 4};
        intersection(nums1, nums2);

    }
}
