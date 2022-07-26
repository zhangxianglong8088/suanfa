package tree;

import common.TreeNode;
import list.ListNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @description：二叉搜索树 转为 双向链表
 * @author: zhangxianglong
 * @date: 2022/7/26
 */
public class BSTConvertToList {


    public static TreeNode Convert(TreeNode root) {

        List<TreeNode> list = new ArrayList<>();
        inorder(root, list);

        TreeNode pre = new TreeNode(-1);

        for (int i = 0; i < list.size(); i++) {

            TreeNode cur = list.get(i);
            TreeNode next = list.get(i + 1);

            cur.left = pre;
            cur.right = next;
            pre = pre.right;
        }

        return root;

    }


    static void inorder(TreeNode root, List<TreeNode> list) {
        if (root == null) {
            return;
        }
        inorder(root.left, list);
        list.add(root);
        inorder(root.right, list);
    }

    public static void main(String[] args) {


    }
}
