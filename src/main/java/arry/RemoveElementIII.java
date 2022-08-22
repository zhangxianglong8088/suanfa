package arry;

import java.util.*;

/**
 * @description： 京东物流面试 一个数组 array 和一个数 k ，从数组中移除 k 个元素，找出移除后数组中剩余不同数的最少数量
 * @author: zhangxianglong
 * @date: 2022/8/22
 */
public class RemoveElementIII {

    public static void main(String[] args) {

        int[] arr = new int[]{5, 1, 7, 7, 7, 6, 6};

        int k = 2;

        System.out.println(find(arr, k));

    }

    public static int find(int[] arr, int k) {

        Map<Integer, Integer> map = new HashMap<>();

        for (int i : arr) {
            int count = map.getOrDefault(i, 0) + 1;
            map.put(i, count);
        }

        int n = map.size();
        int[] cur = new int[n];

        int i = 0;
        for (int val : map.values()) {
            cur[i++] = val;
        }

        Arrays.sort(cur);

        int res = n;

        for (int m = 0; m < n; m++) {
            if (k >= cur[m]) {
                res--;
                k = k - cur[m];
            } else {
                break;
            }

        }

        return res;
    }
}
