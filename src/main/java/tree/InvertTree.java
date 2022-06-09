package tree;

/**
 * @description： 给你一棵二叉树的根节点 root ，翻转这棵二叉树，并返回其根节点。
 * https://leetcode.cn/problems/invert-binary-tree/
 * @author: zhangxianglong
 * @date: 2022/5/19
 */
public class InvertTree {

    /**
     * 反转二叉树 看作是前序遍历 先处根节点
     *
     * @param root
     * @return
     */
    public TreeNode invertTree(TreeNode root) {

        if (root == null) {
            return root;
        }

        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;


        invertTree(root.left);

        invertTree(root.right);

        return root;
    }
}
