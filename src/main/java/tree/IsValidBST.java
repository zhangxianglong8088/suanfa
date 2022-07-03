package tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @description：98. 验证二叉搜索树
 * https://leetcode.cn/problems/validate-binary-search-tree/
 * @author: zhangxianglong
 * @date: 2022/5/24
 */
public class IsValidBST {

    public static boolean isValidBST(TreeNode root) {
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

        Boolean result = isValidBST3(node5);
    }

    /**
     * 递归解法
     *
     * @param root
     * @return
     */

    public static boolean isValidBST2(TreeNode root) {

        //1、递归终止条件

        //2、如何判断

        return isValidBST2(root.left) && isValidBST(root.right);

    }

    /**
     * 中序遍历解法
     *
     * @param root
     * @return
     */
    public static boolean isValidBST3(TreeNode root) {

        List<TreeNode> list = new ArrayList<>();
        inorder(root, list);

        for (int i = 1; i < list.size(); i++) {
            if (list.get(i - 1).val >= list.get(i).val) {
                return false;
            }
        }
        return true;
    }

    /**
     * 中序遍历
     *
     * @param root
     * @param list
     */
    static void inorder(TreeNode root, List<TreeNode> list) {
        if (root == null) {
            return;
        }
        inorder(root.left, list);

        list.add(root);

        inorder(root.right, list);
    }
}
