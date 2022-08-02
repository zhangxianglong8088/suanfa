package tree;

import common.TreeNode;

/**
 * 112. 路径总和
 * https://leetcode.cn/problems/path-sum/
 */
public class PathSumIXXX {

    /**
     * 递归解法
     *
     * @param root
     * @param sum
     * @return
     */
    public boolean hasPathSum(TreeNode root, int sum) {

        if (root == null) {
            return false;
        }

        if (root.left == null && root.right == null) {
            return sum == root.val;

        }
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);

    }

    public static void main(String[] args) {

    }

}
