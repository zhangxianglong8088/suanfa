package tree;

import common.TreeNode;

/**
 * 543. 二叉树的直径
 *
 * @description： https://leetcode.cn/problems/diameter-of-binary-tree/
 * @author: zhangxianglong
 * @date: 2022/5/27
 */
public class DiameterOfBinaryTreeGGG {

    /**
     * 记录最大直径的长度
     * 解决这题的关键在于，每一条二叉树的「直径」长度，就是一个节点的左右子树的最大深度之和。
     */
    static int maxDiameter = 0;

    public static int diameterOfBinaryTree(TreeNode root) {
        // 对每个节点计算直径，求最大直径
        maxDepth(root);
        return maxDiameter;
    }

    /**
     * 遍历二叉树 注意这里必需是后序遍历，因为要先求子结点的长度信息
     *
     * @param root
     * @return
     */
    static int maxDepth(TreeNode root) {
        //后序遍历求root结点左右结点的最大深度
        if (root == null) {
            return 0;
        }

        int leftMax = maxDepth(root.left);

        int rigthMax = maxDepth(root.right);

        //在这里计算最大直径

        maxDiameter = Math.max(maxDiameter, leftMax + rigthMax);

        return Math.max(leftMax, rigthMax) + 1;

    }


    public static void main(String[] args) {

        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        TreeNode node8 = new TreeNode(8);
        TreeNode node9 = new TreeNode(9);


        node1.left = node2;
        node1.right = node3;

        node2.left = node4;
        node2.right = node5;

        node4.left = node9;

        node5.left = node7;
        node5.right = node6;

        node7.left = node8;


        int res = diameterOfBinaryTree(node1);

        System.out.println(res);

    }
}
