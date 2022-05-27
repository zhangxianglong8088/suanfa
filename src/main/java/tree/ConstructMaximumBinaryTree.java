package tree;

/**
 * 654. 最大二叉树 通过数组构造一个最大二叉树
 *
 * @description：https://leetcode.cn/problems/maximum-binary-tree/
 * @author: zhangxianglong
 * @date: 2022/5/19
 */
public class ConstructMaximumBinaryTree {

    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return build(nums, 0, nums.length - 1);
    }

    TreeNode build(int[] nums, int lo, int hi) {
        // base case
        if (lo > hi) {
            return null;
        }

        // 找到数组中的最大值和对应的索引
        int index = -1, maxVal = Integer.MIN_VALUE;
        for (int i = lo; i <= hi; i++) {
            if (maxVal < nums[i]) {
                index = i;
                maxVal = nums[i];
            }
        }

        TreeNode root = new TreeNode(maxVal);
        // 递归调用构造左右子树
        root.left = build(nums, lo, index - 1);

        root.right = build(nums, index + 1, hi);

        return root;
    }


    public static void main(String[] args) {
        int[] nums = new int[]{3, 2, 1, 6, 0, 5};

    }
}
