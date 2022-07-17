package tree;

import common.TreeNode;

/**
 * @description：617. 合并二叉树
 * https://leetcode.cn/problems/merge-two-binary-trees/
 * @author: zhangxianglong
 * @date: 2022/5/24
 */
public class MergeTreesGGG {


    /**
     * 解法一 效率不高
     *
     * @param root1
     * @param root2
     * @return
     */
    public TreeNode mergeTrees1(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return null;
        }

        int rootValue = (root1 == null ? 0 : root1.val) + (root2 == null ? 0 : root2.val);

        TreeNode root = new TreeNode(rootValue);

        root.left = mergeTrees1(root1 == null ? null : root1.left, root2 == null ? null : root2.left);

        root.right = mergeTrees1(root1 == null ? null : root1.right, root2 == null ? null : root2.right);

        return root;
    }

    /**
     * 解法二 超过100%
     *
     * @param t1
     * @param t2
     * @return
     */
    public TreeNode mergeTrees2(TreeNode t1, TreeNode t2) {
        if (t1 == null) {
            return t2;
        }
        if (t2 == null) {
            return t1;
        }
        TreeNode merged = new TreeNode(t1.val + t2.val);

        merged.left = mergeTrees2(t1.left, t2.left);

        merged.right = mergeTrees2(t1.right, t2.right);
        return merged;

    }


    public static void main(String[] args) {

    }

    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {

        if (root1 == null && root2 == null) {
            return null;
        }
        int rootValue = (root1 != null ? root1.val : 0) + (root2 != null ? root2.val : 0);
        TreeNode root = new TreeNode(rootValue);

        root.left = mergeTrees(root1 == null ? null : root1.left, root2 == null ? null : root2.left);

        root.right = mergeTrees(root1 == null ? null : root1.right, root2 == null ? null : root2.right);

        return root;
    }


}
