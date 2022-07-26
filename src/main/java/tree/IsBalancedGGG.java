package tree;

import common.TreeNode;

/**
 * 110. 平衡二叉树
 *
 * @description：https://leetcode.cn/problems/balanced-binary-tree/submissions/
 * @author: zhangxianglong
 * @date: 2022/6/8
 */
public class IsBalancedGGG {


    /**
     * 前序遍历
     *
     * @param root
     * @return
     */
    public static boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        //分别求出左右子树的高度
        int leftDepth = depth(root.left);

        int rightDepth = depth(root.right);

        if (Math.abs(leftDepth - rightDepth) > 1) {
            return false;
        }

        return isBalanced(root.left) && isBalanced(root.right);
    }

    /**
     * 求一个结点的高度
     *
     * @param root
     * @return
     */
    public static int depth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(depth(root.left), depth(root.right)) + 1;
    }


    public static void main(String[] args) {

        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);

        node1.left = node2;
        node1.right = node3;

        node2.left = node4;
        node2.right = node5;

        node4.left = node6;
        node4.right = node7;


        boolean result = isBalanced(node1);

    }
}
