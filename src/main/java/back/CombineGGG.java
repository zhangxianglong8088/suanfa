package back;

import java.util.*;

/**
 * @description：77. 组合
 * https://leetcode.cn/problems/combinations/
 * @author: zhangxianglong
 * @date: 2022/5/29
 */
public class CombineGGG {

    public static List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        if (k <= 0 || n < k) {
            return res;
        }
        // 从 1 开始是题目的设定
        Deque<Integer> path = new ArrayDeque<>();
        dfs(n, k, 1, path, res);
        return res;
    }

    static void dfs(int n, int k, int begin, Deque<Integer> path, List<List<Integer>> res) {
        // 递归终止条件是：path 的长度等于 k
        if (path.size() == k) {
            res.add(new ArrayList<>(path));
            return;
        }

        // 遍历可能的搜索起点
        //如果不减枝 i<=n 就可以了
        //如果优化算法进行减枝操作 这里缩小i的取值范围 i<=n-(k-path.size())+1
        for (int i = begin; i <= n - (k - path.size()) + 1; i++) {
            // 向路径变量里添加一个数
            path.addLast(i);
            // 下一轮搜索，设置的搜索起点要加 1，因为组合数理不允许出现重复的元素
            dfs(n, k, i + 1, path, res);
            // 重点理解这里：深度优先遍历有回头的过程，因此递归之前做了什么，递归之后需要做相同操作的逆向操作
            path.removeLast();
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> result = combine3(4, 2);
    }

    public static List<List<Integer>> combine3(int n, int k) {

        List<List<Integer>> res = new ArrayList();

        Deque<Integer> path = new ArrayDeque();

        backtracing3(res, path, n, 1, k);

        return res;


    }

    static void backtracing3(List<List<Integer>> res, Deque<Integer> path, int n, int index, int k) {
        //递归终止条件
        if (path.size() == k) {
            res.add(new ArrayList(path));
            return;
        }

        //单层递归逻辑
        for (int i = index; i <= n; i++) {

            path.add(i);

            //递归
            backtracing3(res, path, n, i + 1, k);

            //回溯
            path.removeLast();

        }

    }
}
