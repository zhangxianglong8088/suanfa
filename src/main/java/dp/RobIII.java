package dp;


import common.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @description： https://leetcode.cn/problems/house-robber-iii/solution/dai-ma-sui-xiang-lu-337-da-jia-jie-she-i-j60v/
 * @author: zhangxianglong
 * @date: 2022/7/14
 */
public class RobIII {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param root TreeNode类
     * @return int整型
     */
    public int rob(TreeNode root) {
        int[] res = robAction1(root);
        return Math.max(res[0], res[1]);
    }

    int[] robAction1(TreeNode root) {
        //定义dp数组 长度为2 第一个值表示不偷当前节点拿到的前，第二个值表示偷当前节点拿到的前
        int[] res = new int[2];

        if (root == null) {
            return res;
        }

        int[] left = robAction1(root.left);
        int[] right = robAction1(root.right);
        //不偷当前节点 我们可以选择偷左右字节点（左右字节点 又有 偷 和 不偷 两种选择）
        res[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);

        //偷当前节点 里面包含了不偷左右字节点状态的时候带来的金额
        res[1] = root.val + left[0] + right[0];

        return res;
    }


}
