package tree;

import java.util.HashMap;

/**
 * 通过中序和后序遍历构造二叉树
 * https://leetcode.cn/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 *
 * @author: zhangxianglong
 * @date: 2022/5/19
 */
public class ConstructFromInPost {

    static HashMap<Integer, Integer> valToIndex = new HashMap<>();

    /**
     * @param inorder
     * @param postorder
     * @return
     */
    public static TreeNode buildTree(int[] inorder, int[] postorder) {

        for (int i = 0; i < inorder.length; i++) {
            valToIndex.put(inorder[i], i);
        }

        TreeNode treeNode = builder(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);

        return treeNode;

    }


    static TreeNode builder(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd) {

        if (inStart > inEnd) {
            return null;
        }


        int rootVal = postorder[postEnd];
        TreeNode root = new TreeNode(rootVal);
        int index = valToIndex.get(rootVal);

        int leftSize = index - inStart;

        root.left = builder(inorder, inStart, index - 1, postorder, postStart, postStart + leftSize - 1);

        root.right = builder(inorder, index + 1, inEnd, postorder, postStart + leftSize, postEnd - 1);

        return root;
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

        node2.left = node5;
        node2.right = node4;

        node4.left = node6;
        node4.right = node7;

        node3.left = node8;
        node3.right = node9;

        int[] inorder = new int[]{5, 2, 6, 4, 7, 1, 8, 3, 9};
        int[] postorder = new int[]{5, 6, 7, 4, 2, 8, 9, 3, 1};
        //中序和后序
        TreeNode result = buildTree(inorder, postorder);

    }
}
