package tree;

import common.TreeNode;

/**
 * @description：101. 对称二叉树
 * https://leetcode.cn/problems/symmetric-tree/
 * @author: zhangxianglong
 * @date: 2022/5/24
 */
public class IsSymmetric {

    public static boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return helper(root.left, root.right);

    }

    public static boolean helper(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }

        if (right == null) {
            return false;
        }

        if (left == null) {
            return false;
        }
        if (left.val != right.val) {
            return false;
        }

        return helper(left.left, right.right) && helper(left.right, right.left);
    }

    public static void main(String[] args) {

        TreeNode node0 = new TreeNode(1);

        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(2);

        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(1);

        TreeNode node5 = new TreeNode(4);
        TreeNode node6 = new TreeNode(3);


        node0.left = node1;
        node0.right = node2;

        node1.left = node3;
        node1.right = node4;

        node2.left = node5;
        node2.right = node6;

        Boolean result = isSymmetric(node0);

    }
}
