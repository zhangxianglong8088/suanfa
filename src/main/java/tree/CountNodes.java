package tree;

/**
 * @description：222. 完全二叉树的节点个数
 * https://leetcode.cn/problems/count-complete-tree-nodes/
 * @author: zhangxianglong
 * @date: 2022/6/5
 */
public class CountNodes {

    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = countNodes(root.left);
        int right = countNodes(root.right);

        return left + right + 1;
    }
}
