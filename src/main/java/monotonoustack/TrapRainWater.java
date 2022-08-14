package monotonoustack;

import java.util.PriorityQueue;

/**
 * 给你一个 m x n 的矩阵，其中的值均为非负整数，代表二维高度图每个单元的高度，请计算图中形状最多能接多少体积的雨水。
 * * @author: zhangxianglong
 * 如果一个位置能装水 那么它的上下左右都是石头或者水
 *
 * @description： https://leetcode.cn/problems/trapping-rain-water-ii/
 * @date: 2022/8/11
 */
public class TrapRainWater {

    public static int trapRainWater(int[][] heightMap) {

        //特殊条件判断
        int row = heightMap.length;
        int col = heightMap[0].length;

        if (row < 3 || col < 3) {
            return 0;
        }

        //定义返回值
        int res = 0;

        //将最外圈放入优先级队列中 并将元素赋值为已访问
        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> (a[2] - b[2]));
        boolean[][] visited = new boolean[row][col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (i == 0 || i == row - 1 || j == 0 || j == col - 1) {
                    queue.offer(new int[]{i, j, heightMap[i][j]});
                    visited[i][j] = true;
                }
            }
        }

        while (!queue.isEmpty()) {
            //取出最外圈最小的一个元素
            int[] cur = queue.poll();
            int[] dir = new int[]{-1, 0, 1, 0, -1};

            //找到它的上下左右元素
            for (int i = 0; i < 4; i++) {
                int xn = cur[0] + dir[i];
                int yn = cur[1] + dir[i + 1];

                //判断是否是内部元素
                //如果是内部元素 并且没有访问过  则计算接雨水的量
                if (xn > 0 && xn < row && yn > 0 && yn < col && !visited[xn][yn]) {
                    //当前元素比内部的元素高，才有可能盛水
                    int temp = cur[2] - heightMap[xn][yn];
                    if (temp > 0) {
                        res += temp;
                    }
                    //满足条件的内部元素入队列 思考这里为什么取 cur[2], heightMap[xn][yn] 最大值 因为目前cur已经是队列里面最小的
                    queue.offer(new int[]{xn, yn, Math.max(cur[2], heightMap[xn][yn])});
                    visited[xn][yn] = true;
                }
            }

        }
        return res;
    }

    public static void main(String[] args) {

        int[][] nums = new int[][]{{1, 4, 3, 1, 3, 2}, {3, 2, 1, 3, 2, 4}, {2, 3, 3, 2, 3, 1}};

        int res = trapRainWater(nums);

        System.out.println(res);
    }
}
