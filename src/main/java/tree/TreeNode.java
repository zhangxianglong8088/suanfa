package tree;

/**
 * @description：
 * @author: zhangxianglong
 * @date: 2022/5/18
 */
public class TreeNode {

    int val;
    TreeNode right;
    TreeNode left;

    public TreeNode(int val, TreeNode right, TreeNode left) {
        this.val = val;
        this.right = right;
        this.left = left;
    }

    public TreeNode(int val) {
        this.val = val;
    }
}
