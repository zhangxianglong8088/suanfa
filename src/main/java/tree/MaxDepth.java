package tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * 104 二叉树的最大深度
 *
 * @description： https://leetcode.cn/problems/maximum-depth-of-binary-tree/
 * @author: zhangxianglong
 * @date: 2022/5/23
 */
public class MaxDepth {

    public static int maxDepth(TreeNode root) {

        if (root == null) {
            return 0;
        }

        int leftHigh = maxDepth(root.left);

        int rightHigh = maxDepth(root.right);

        return Math.max(leftHigh, rightHigh) + 1;

    }

    /**
     * 二叉树层序遍历解法
     *
     * @param root
     * @return
     */
    public static int maxDepthByLevel(TreeNode root) {
        if (root == null) {
            return 0;
        }
        List<List<Integer>> listAll = new ArrayList<>();

        Queue<TreeNode> queue = new ArrayDeque<>();

        queue.add(root);

        while (!queue.isEmpty()) {
            int n = queue.size();
            List<Integer> list = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                TreeNode treeNode = queue.poll();
                list.add(treeNode.val);
                if (treeNode.left != null) {
                    queue.add(treeNode.left);
                }
                if (treeNode.right != null) {
                    queue.add(treeNode.right);
                }
            }
            listAll.add(list);

        }
        return listAll.size();
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

        int maxDepth = maxDepth(node3);

        System.out.println(maxDepth);


    }
}
