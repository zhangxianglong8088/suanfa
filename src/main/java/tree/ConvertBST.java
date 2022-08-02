package tree;

import common.TreeNode;

/**
 * 538. 把二叉搜索树转换为累加树
 *
 * @description：https://leetcode.cn/problems/convert-bst-to-greater-tree/
 * @author: zhangxianglong
 * @date: 2022/7/5
 */
public class ConvertBST {

    static int sum = 0;

    public static TreeNode convertBST(TreeNode root) {
        if (root != null) {
            convertBST(root.right);
            sum += root.val;
            root.val = sum;
            convertBST(root.left);
        }
        return root;
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


        node4.left = node1;
        node4.right = node6;

        node1.left = node0;
        node1.right = node2;

        node2.right = node3;

        node4.right = node6;

        node6.left = node5;
        node6.right = node7;

        node7.right = node8;


        TreeNode res = convertBST(node4);

        System.out.println(res);

    }
}
