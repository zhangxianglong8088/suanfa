package tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * @description：111. 二叉树的最小深度
 * https://leetcode.cn/problems/minimum-depth-of-binary-tree/
 * @author: zhangxianglong
 * @date: 2022/6/5
 */
public class MinDepthXXX {

    /**
     * 这个解法64%可以借鉴
     *
     * @param root
     * @return
     */
    public int minDepth1(TreeNode root) {
        if (root == null) {
            return 0;
        }

        if (root.left == null && root.right == null) {
            return 1;
        }

        int min_depth = Integer.MAX_VALUE;
        if (root.left != null) {
            min_depth = Math.min(minDepth1(root.left), min_depth);
        }
        if (root.right != null) {
            min_depth = Math.min(minDepth1(root.right), min_depth);
        }

        return min_depth + 1;
    }

    /**
     * DFS
     *
     * @param root
     * @return
     */
    public static int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = minDepth(root.left);

        int right = minDepth(root.right);

        if (root.left == null) {
            return right + 1;
        }
        if (root.right == null) {
            return left + 1;
        }
        return Math.min(left, right) + 1;
    }


    /**
     * BFS
     *
     * @param root
     * @return
     */
    public static int minDepth2(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);

        while (!queue.isEmpty()) {

            TreeNode treeNode = queue.poll();
            list.add(treeNode);

            if (treeNode.left != null) {
                queue.add(treeNode.left);
            }
            if (treeNode.right != null) {
                queue.add(treeNode.right);
            }
        }
        return list.size();
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

        int maxDepth = minDepth2(node3);

        System.out.println(maxDepth);
    }
}
