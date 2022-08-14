package tree;

import common.TreeNode;

/**
 * 112. 路径总和  从根节点到叶子节点 存不存在一条路径 路径和等于targetSum
 * https://leetcode.cn/problems/path-sum/
 */
public class PathSumIXXX {

    /**
     * 递归解法
     *
     * @param root
     * @return
     */
    public boolean hasPathSum(TreeNode root, int targetSum) {

        if (root == null) {
            return false;
        }

        if (root.left == null && root.right == null && root.val == targetSum) {
            return true;
        }

        int sum = targetSum - root.val;

        return hasPathSum(root.left, sum) || hasPathSum(root.right, sum);
    }

}
