package tree;

/**
 * 654. 最大二叉树 通过数组构造一个最大二叉树
 *
 * @description：https://leetcode.cn/problems/maximum-binary-tree/
 * @author: zhangxianglong
 * @date: 2022/5/19
 */
public class ConstructMaximumBinaryTree {

    public static TreeNode constructMaximumBinaryTree(int[] nums) {
        return build(nums, 0, nums.length - 1);

    }

    static TreeNode build(int[] nums, int lo, int hi) {
        if (lo > hi) {
            return null;
        }
        // 在lo 和hi区间中找到最大值的下标
        int maxValue = Integer.MIN_VALUE;
        int index = -1;
        for (int i = lo; i <= hi; i++) {
            if (nums[i] > maxValue) {
                maxValue = nums[i];
                index = i;
            }
        }
        //构造根结点
        TreeNode root = new TreeNode(maxValue);

        //递归构造左结点
        root.left = build(nums, lo, index - 1);
        //递归构造🈶右结点
        root.right = build(nums, index + 1, hi);

        return root;
    }


    public static void main(String[] args) {
        int[] nums = new int[]{3, 2, 1, 6, 0, 5};
        constructMaximumBinaryTree(nums);
    }
}
