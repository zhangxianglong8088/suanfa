package arry;

import java.util.*;

/**
 * 剑指 Offer 40. 最小的k个数
 *
 * @description：https://leetcode.cn/problems/zui-xiao-de-kge-shu-lcof/
 * @author: zhangxianglong
 * @date: 2022/5/16
 */
public class GetLeastNumbersGGG {

    /**
     * 通过大根堆
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

    /**
     * 小根堆实现
     *
     * @param arr
     * @param k
     * @return
     */
    public static int[] getLeastNumbers2(int[] arr, int k) {
        Queue<Integer> queue = new PriorityQueue<>(Comparator.comparingInt(v -> v));
        for (int i = 0; i < arr.length; i++) {
            queue.offer(arr[i]);
        }
        int[] nums = new int[k];
        for (int i = 0; i < k; i++) {
            nums[i] = queue.poll();
        }
        return nums;
    }


    /**
     * 快速排序
     */
    static int[] getLeastNumbers3(int[] arr, int k) {
        quickSort(arr, 0, arr.length - 1);

        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = arr[i];
        }
        return res;
    }

    static void quickSort(int[] nums, int start, int end) {
        if (start > end) {
            return;
        }
        int i = start;
        int j = end;
        int pivot = nums[start];

        while (i < j) {
            /**
             * 注意这里的序号一定是先判断j 再判断i否则出错
             */
            while (i < j && nums[j] >= pivot) {
                j--;
            }
            while (i < j && nums[i] <= pivot) {
                i++;
            }

            if (i < j) {
                //交换num[i] nums[j]
                swap(nums, i, j);
            }
        }
        swap(nums, start, i);
        quickSort(nums, start, i - 1);
        quickSort(nums, j + 1, end);
    }

    /**
     * 交换num[i] nums[j] 的值
     *
     * @param nums
     * @param i
     * @param j
     */
    public static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }


    public static void main(String[] args) {
        int[] nums = new int[]{0, 0, 0, 2, 0, 5};
        int k = 0;
        int[] result = getLeastNumbers(nums, k);
    }
}
