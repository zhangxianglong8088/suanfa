package arry;

import java.util.*;

/**
 * @description：
 * @author: zhangxianglong
 * @date: 2022/5/16
 */
public class GetLeastNumbers {

//    public int[] getLeastNumbers(int[] arr, int k) {
//        Arrays.sort(arr);
//        int[] result = new int[k];
//        Set<Integer> set = new HashSet<>();
//        for (int i = 0; i < arr.length; i++) {
//            set.add(arr[i]);
//            if (set.size() == k) {
//                break;
//            }
//        }
//    }

    /**
     * 求top k 最小的K个数 的算法，
     * 如果求一堆数中最小的前K个数，通过da顶堆，如果加进来的数，比da顶堆的顶还小，则替换，如果比小顶堆的顶大，则忽略
     * <p>
     * 求top k 最大的K个数 的算法
     * 如果求一堆数中最大的前K个数，通过小顶堆，如果加进来的数，比小顶堆的顶大，则替换，如果比小顶堆的顶大，则忽略
     *
     * @param arr
     * @param k
     * @return
     */
    public static int[] getLeastNumbers(int[] arr, int k) {
        if (k == 0 || arr.length == 0) {
            return new int[0];
        }
        // 默认是小根堆，实现大根堆需要重写一下比较器。
        Queue<Integer> pq = new PriorityQueue<>((v1, v2) -> v2 - v1);
        for (int num : arr) {
            if (pq.size() < k) {
                pq.offer(num);
            } else if (num < pq.peek()) {
                pq.poll();
                pq.offer(num);
            }
        }

        // 返回堆中的元素
        int[] res = new int[pq.size()];
        int idx = 0;
        for (int num : pq) {
            res[idx++] = num;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0, 0, 0, 2, 0, 5};
        int k = 2;
        int[] result = getLeastNumbers(nums, k);
    }
}
