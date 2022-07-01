package tree;

import java.util.HashMap;

/**
 * 105. 从前序与中序遍历序列构造二叉树
 * https://leetcode.cn/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 *
 * @description：通过前序和中序构造二叉树 思路：用前序的根结点去切中序数组 找到中序中的跟结点的位置 计算出左右个有多少个
 * @author: zhangxianglong
 * @date: 2022/6/9
 */
public class ConstructFromPreIn {

    // 存储 inorder 中值到索引的映射
    static HashMap<Integer, Integer> valToIndex = new HashMap<>();

    /**
     * @param inorder
     * @param preorder
     * @return
     */
    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            valToIndex.put(inorder[i], i);
        }
        return build(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }


    static TreeNode build(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {

        if (preStart > preEnd) {
            return null;
        }

        // root 节点对应的值就是前序遍历数组的第一个元素
        int rootVal = preorder[preStart];

        // rootVal 在中序遍历数组中的索引
        int index = valToIndex.get(rootVal);

        //左边元素的个数
        int leftSize = index - inStart;

        // 先构造出当前根节点
        TreeNode root = new TreeNode(rootVal);

        // 递归构造左右子树
        root.left = build(preorder, preStart + 1, preStart + leftSize, inorder, inStart, index - 1);

        root.right = build(preorder, preStart + leftSize + 1, preEnd, inorder, index + 1, inEnd);
        return root;
    }

    public static void main(String[] args) {
        int[] preOrder = new int[]{1, 2, 5, 4, 6, 7, 3, 8, 9};
        int[] inorder = new int[]{5, 2, 6, 4, 7, 1, 8, 3, 9};

        TreeNode root = buildTree(preOrder, inorder);

    }
}
