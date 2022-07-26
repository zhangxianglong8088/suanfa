package tree;

import common.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * 199. 二叉树的右视图
 * 保存层序遍历的最后一个元素
 *
 * @description：https://leetcode.cn/problems/binary-tree-right-side-view/submissions/
 * @author: zhangxianglong
 * @date: 2022/7/24
 */
public class RightSideViewGGG {

    public List<Integer> rightSideView(TreeNode root) {

        Queue<TreeNode> queue = new ArrayDeque<>();
        List<Integer> res = new ArrayList();
        if (root != null) {
            queue.add(root);
        }

        while (!queue.isEmpty()) {

            int n = queue.size();

            for (int i = 0; i < n; i++) {

                TreeNode node = queue.poll();
                if (i == n - 1) {
                    res.add(node.val);
                }

                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }
        return res;
    }
}
