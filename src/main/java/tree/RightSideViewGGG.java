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
 * @description： https://leetcode.cn/problems/binary-tree-right-side-view/submissions/
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

    public static void main(String[] args) {
        TreeNode node0 = new TreeNode(0);
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        TreeNode node8 = new TreeNode(8);


        node3.left = node5;
        node3.right = node1;

        node5.left = node6;
        node5.right = node2;

        node2.left = node7;
        node2.right = node4;

        node1.left = node0;
        node1.right = node8;

        List<Integer> res = rightSideView2(node3);

        System.out.println(res);
    }

    public static List<Integer> rightSideView2(TreeNode root) {

        List<Integer> res = new ArrayList<>();

        Queue<TreeNode> queue = new ArrayDeque<>();

        queue.offer(root);


        while (!queue.isEmpty()) {

            int n = queue.size();

            for (int i = 0; i < n; i++) {
                TreeNode tmp = queue.poll();
                if (i == n - 1) {
                    res.add(tmp.val);
                }

                if (tmp.left != null) {
                    queue.offer(tmp.left);
                }

                if (tmp.right != null) {
                    queue.offer(tmp.right);
                }
            }

        }
        return res;

    }
}
