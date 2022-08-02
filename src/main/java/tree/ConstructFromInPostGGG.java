package tree;

import common.TreeNode;

import java.util.HashMap;

/**
 * https://leetcode.cn/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
 * 通过中序和后序遍历构造二叉树
 *
 * @author: zhangxianglong
 * @date: 2022/5/19
 */
public class ConstructFromInPostGGG {

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

        int[] inorder = new int[]{9, 3, 15, 20, 7};
        int[] postorder = new int[]{9, 15, 7, 20, 3};
        //中序和后序
        TreeNode result = buildTree2(inorder, postorder);

    }


    public static TreeNode buildTree2(int[] inorder, int[] postorder) {
        //映射中序遍历的结果和下标
        for (int i = 0; i < inorder.length; i++) {
            valToIndex.put(inorder[i], i);
        }

        TreeNode res = build2(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);

        return res;

    }

    public static TreeNode build2(int[] inorder, int inStart, int inEnd, int[] postorder, int pStart, int pEnd) {

        if (inStart > inEnd) {
            return null;
        }

        int index = valToIndex.get(postorder[postorder.length - 1]);

        int rootValue = postorder[pEnd];
        TreeNode root = new TreeNode(rootValue);

        int leftSize = index - inStart;

        root.left = build2(inorder, inStart, index - 1, postorder, pStart, pStart + leftSize);

        root.right = build2(inorder, index + 1, inEnd, postorder, pStart + leftSize + 1, pEnd - 1);

        return root;

    }
}
