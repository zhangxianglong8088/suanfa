package tree;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode.cn/problems/binary-tree-inorder-traversal/
 *
 * @description：给定一个二叉树的根节点 root ，返回 它的 中序 遍历 。
 * @author: zhangxianglong
 * @date: 2022/5/18
 */
public class TnorderTraversalGGG {

    public static void main(String[] args) {

    }

    /**
     * 二叉树【前】 序遍历
     *
     * @param root
     * @return
     */
    public static void pre(TreeNode root, List<Integer> list) {

        if (root == null) {
            return;
        }
        list.add(root.val);

        //左
        inorder(root.left, list);

        //右
        inorder(root.right, list);
    }


    /**
     * 二叉树【中】序遍历
     *
     * @param root
     * @return
     */
    public static void inorder(TreeNode root, List<Integer> list) {

        if (root == null) {
            return;
        }

        //左
        inorder(root.left, list);

        list.add(root.val);

        //右
        inorder(root.right, list);
    }


    /**
     * 二叉树【后】序遍历
     *
     * @param root
     * @return
     */
    public static void after(TreeNode root, List<Integer> list) {

        if (root == null) {
            return;
        }

        //左
        inorder(root.left, list);

        //右
        inorder(root.right, list);

        list.add(root.val);
    }
}
