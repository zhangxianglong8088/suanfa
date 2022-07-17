package tree;

import common.TreeNode;

/**
 * 108. 将有序数组转换为二叉搜索树
 *
 * @description： https://leetcode.cn/problems/convert-sorted-array-to-binary-search-tree/
 * @author: zhangxianglong
 * @date: 2022/6/8
 */
public class SortedArrayToBSTGGG {

    public static TreeNode sortedArrayToBST(int[] nums) {
        TreeNode treeNode = builder(nums, 0, nums.length - 1);

        return treeNode;

    }


    public static TreeNode builder(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }

        int middle = (right + left) / 2;

        TreeNode root = new TreeNode(nums[middle]);

        root.left = builder(nums, left, middle - 1);
        root.right = builder(nums, middle + 1, right);

        return root;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-10, -3, 0, 5, 9};
        TreeNode root = sortedArrayToBST(nums);
    }
}
