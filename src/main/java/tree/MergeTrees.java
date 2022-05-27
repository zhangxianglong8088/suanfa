package tree;

/**
 * @description：617. 合并二叉树
 * https://leetcode.cn/problems/merge-two-binary-trees/
 * @author: zhangxianglong
 * @date: 2022/5/24
 */
public class MergeTrees {

    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {

        if (t1 == null) {
            return t2;
        }

        if (t2 == null) {
            return t1;
        }

        TreeNode treeNode = new TreeNode(t1.val + t1.val);


        TreeNode left = mergeTrees(t1.left, t2.left);

        TreeNode right = mergeTrees(t1.right, t2.right);

        treeNode.left = left;
        treeNode.right = right;

        return treeNode;
    }

}
