package tree;

import common.TreeNode;

import java.util.*;

/**
 * 二叉树层序遍历
 *
 * @description： https://leetcode.cn/problems/binary-tree-level-order-traversal/
 * @author: zhangxianglong
 * @date: 2022/5/24
 */
public class LevelOrderGGG {

    public static List<List<Integer>> levelOrder(TreeNode root) {

        Queue<TreeNode> queue = new ArrayDeque<>();
        List<List<Integer>> list = new ArrayList<>();

        if (root != null) {
            queue.add(root);
        }

        while (!queue.isEmpty()) {

            int n = queue.size();
            List<Integer> treeNodes = new ArrayList<>();

            for (int i = 0; i < n; i++) {

                TreeNode node = queue.poll();
                treeNodes.add(node.val);

                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            list.add(treeNodes);
        }
        return list;
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


        List<List<Integer>> list = levelOrder4(node3);

    }

    public static List<List<Integer>> levelOrder4(TreeNode root) {

        List<List<Integer>> res = new ArrayList<>();

        Queue<TreeNode> queue = new ArrayDeque<>();

        queue.offer(root);

        while (!queue.isEmpty()) {

            int n = queue.size();

            List<Integer> sub = new ArrayList<>();

            for (int i = 0; i < n; i++) {

                TreeNode tmp = queue.poll();

                sub.add(tmp.val);

                if (tmp.left != null) {
                    queue.offer(tmp.left);
                }

                if (tmp.right != null) {
                    queue.offer(tmp.right);
                }
            }

            res.add(sub);

        }

        return res;

    }
}
