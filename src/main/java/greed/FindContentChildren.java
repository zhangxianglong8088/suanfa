package greed;

import java.util.Arrays;

/**
 * @description：455. 分发饼干
 * https://leetcode.cn/problems/assign-cookies/
 * @author: zhangxianglong
 * @date: 2022/7/27
 */
public class FindContentChildren {

    public static int findContentChildren(int[] g, int[] s) {

        int count = 0;

        //1、g数组和s数组排序
        Arrays.sort(g);
        Arrays.sort(s);

        //g 表示小孩数组
        //s 表示饼干数组

        int sIndex = s.length - 1;
        int gIndex = g.length - 1;
        //从大到小遍历饼干数组，去满足胃口最大的小孩
        while (sIndex >= 0 && gIndex >= 0) {
            if (s[sIndex] >= g[gIndex]) {
                //如果当前饼干可以满足 当前小孩，则count++ 同时两个指针向左移动
                count++;
                sIndex--;
                gIndex--;
            } else {
                //如果当前饼干不满足当前小孩 则小孩数组向左移动 找下一个小孩
                gIndex--;
            }
        }
        return count;
    }


    public static void main(String[] args) {
        //孩子数组
        int[] g = new int[]{1, 2, 3};

        //饼干数组
        int[] s = new int[]{1, 1};
        int res = findContentChildren(g, s);

        System.out.println(res);
    }
}
