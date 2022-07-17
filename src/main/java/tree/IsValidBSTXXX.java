package tree;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @description：98. 验证二叉搜索树
 * https://leetcode.cn/problems/validate-binary-search-tree/
 * @author: zhangxianglong
 * @date: 2022/5/24
 */
public class IsValidBSTXXX {

    public static boolean isValidBST1(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();

        List<TreeNode> treeNodes = helper(root, list);

        for (int i = 0; i < treeNodes.size() - 1; i++) {
            if (list.get(i).val >= list.get(i + 1).val) {
                return false;
            }
        }
        return true;
    }


    public static List<TreeNode> helper(TreeNode root, List<TreeNode> list) {

        if (root == null) {
            return list;
        }

        helper(root.left, list);

        list.add(root);

        helper(root.right, list);

        return list;
    }

    public static void main(String[] args) {
        List<TreeNode> list = new ArrayList<>();
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);


        node5.left = node3;
        node5.right = node6;

        node3.left = node2;
        node3.right = node4;

        node2.left = node1;

        Boolean result = isValidBST2(node5);
    }

    /**
     * 递归解法
     *
     * @param root
     * @return
     */

    public static boolean isValidBST2(TreeNode root) {
        return validBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public static boolean validBST(TreeNode node, long lower, long upper) {
        if (node == null) {
            return true;
        }
        if (node.val <= lower || node.val >= upper) {
            return false;
        }
        return validBST(node.left, lower, node.val) && validBST(node.right, node.val, upper);
    }
}
