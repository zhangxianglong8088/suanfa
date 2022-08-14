package tree;

import common.TreeNode;

/**
 * 124. 二叉树中的最大路径和
 * 题意：求：二叉树中和最大的一条路径对应的和
 *
 * @description： 路径 被定义为一条从树中任意节点出发，沿父节点-子节点连接，达到任意节点的序列。同一个节点在一条路径序列中 至多出现一次 。该路径 至少包含一个 节点，且不一定经过根节点。
 * <p>
 * 路径和 是路径中各节点值的总和。
 * <p>
 * 给你一个二叉树的根节点 root ，返回其 最大路径和 。
 * <p>
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/binary-tree-maximum-path-sum
 * 思路参考：
 * https://leetcode.cn/problems/binary-tree-maximum-path-sum/solution/shou-hui-tu-jie-hen-you-ya-de-yi-dao-dfsti-by-hyj8/
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: zhangxianglong
 * @date: 2022/5/20
 */
public class PathSumIIXXX {

    /**
     * 这里不能定义为0 因为 路径和有可能比0小
     */
    int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        maxGain(root);
        return maxSum;
    }

    public int maxGain(TreeNode node) {
        if (node == null) {
            return 0;
        }

        // 递归计算左右子节点的最大贡献值
        // 只有在最大贡献值大于 0 时，才会选取对应子节点
        int leftGain = Math.max(maxGain(node.left), 0);
        int rightGain = Math.max(maxGain(node.right), 0);

        // 节点的最大路径和取决于该节点的值与该节点的左右子节点的最大贡献值
        // 更新答案
        maxSum = Math.max(maxSum, node.val + leftGain + rightGain);

        // 返回节点的最大贡献值
        return node.val + Math.max(leftGain, rightGain);
    }
}
