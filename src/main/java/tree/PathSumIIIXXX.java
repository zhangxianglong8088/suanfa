package tree;

import common.TreeNode;

/**
 * 437. 路径总和 III
 *
 * @description： https://leetcode.cn/problems/path-sum-iii/
 * @author: zhangxianglong
 * 一个朴素的做法是搜索以每个节点为根的（往下的）所有路径，并对路径总和为 targetSumtargetSum 的路径进行累加统计。
 * <p>
 * 使用 dfs1 来搜索所有节点，复杂度为 O(n)O(n)；在 dfs1 中对于每个当前节点，使用 dfs2 搜索以其为根的所有（往下的）路径，同时累加路径总和为 targetSumtargetSum 的所有路径，复杂度为 O(n)O(n)。
 * <p>
 * 作者：AC_OIer
 * 链接：https://leetcode.cn/problems/path-sum-iii/solution/gong-shui-san-xie-yi-ti-shuang-jie-dfs-q-usa7/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 * @date: 2022/7/5
 */
public class PathSumIIIXXX {

    int ans, t;

    public int pathSum(TreeNode root, int _t) {
        t = _t;
        dfs1(root);
        return ans;
    }

    /**
     * 前序遍历
     *
     * @param root
     */
    void dfs1(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs2(root, root.val);
        dfs1(root.left);
        dfs1(root.right);
    }

    /**
     * 以root为起点的路径和为t的路径数量
     *
     * @param root
     * @param val
     */
    void dfs2(TreeNode root, int val) {
        if (val == t) {
            ans++;
        }
        if (root.left != null) {
            dfs2(root.left, val + root.left.val);
        }
        if (root.right != null) {
            dfs2(root.right, val + root.right.val);
        }
    }
}
