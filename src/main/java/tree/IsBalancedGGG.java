package tree;

import common.TreeNode;

/**
 * 110. 平衡二叉树
 *
 * @description： https://leetcode.cn/problems/balanced-binary-tree/submissions/
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

        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(9);
        TreeNode node3 = new TreeNode(20);
        TreeNode node4 = new TreeNode(15);
        TreeNode node5 = new TreeNode(7);

        node1.left = node2;
        node1.right = node3;

        node3.left = node4;
        node3.right = node5;


        boolean result = isBalanced(node1);

    }

}
