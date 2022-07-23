package arry;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 56. 合并区间
 *
 * @description：https://leetcode.cn/problems/merge-intervals/
 * @author: zhangxianglong
 * @date: 2022/7/20
 */
public class Merge {

    public static int[][] merge(int[][] intervals) {
        //对二维数组排序
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        List<int[]> outputs = new ArrayList<>();

        for (int i = 0; i < intervals.length; i++) {
            int[] current = intervals[i];
            //第一个区间直接放到结果集中
            if (outputs.isEmpty()) {
                outputs.add(current);
            } else {
                int[] outPutLast = outputs.get(outputs.size() - 1);
                //如果没有重叠 直接加入到outputs中
                if (current[0] > outPutLast[1]) {
                    outputs.add(current);
                } else {
                    outPutLast[1] = Math.max(current[1], outPutLast[1]);
                }
            }
        }
        //list 转为数组

        return outputs.toArray(new int[outputs.size()][]);
    }

    public static void main(String[] args) {
        int[][] nums = new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] res = merge(nums);
        System.out.println(res);
    }
}
