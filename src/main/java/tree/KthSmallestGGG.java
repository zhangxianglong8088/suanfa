package tree;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 230. 二叉搜索树中第K小的元素
 *
 * @description：https://leetcode.cn/problems/kth-smallest-element-in-a-bst/
 * @author: zhangxianglong
 * @date: 2022/5/21
 */
public class KthSmallestGGG {

    public static int kthSmallest(TreeNode root, int k) {

        List<TreeNode> list = new ArrayList<>();

        middle(root, list);

        return list.get(k - 1).val;

    }


    public static void middle(TreeNode root, List<TreeNode> list) {
        if (root == null) {
            return;
        }

        middle(root.left, list);

        list.add(root);

        middle(root.right, list);
    }

    public static void main(String[] args) {

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

        System.out.println(kthSmallest(node5, 3));

    }
}
