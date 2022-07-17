package tree;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @description：
 * @author: zhangxianglong
 * @date: 2022/6/16
 */
public class SolutionGGG {

    static List<TreeNode> count(TreeNode root, List<TreeNode> list) {

        count1(root, list);

        return list;

    }

    static void count1(TreeNode root, List<TreeNode> list) {
        if (root == null) {
            return;
        }

        count1(root.left, list);

        count1(root.right, list);

        if (root.left == null && root.right == null) {
            list.add(root);
        }
    }

    public static void main(String[] args) {
        TreeNode node0 = new TreeNode(0);
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        TreeNode node8 = new TreeNode(8);

        node3.left = node5;
        node3.right = node1;

        node5.left = node6;
        node5.right = node2;

        node2.left = node7;
        node2.right = node4;

        node1.left = node0;
        node1.right = node8;

        List<TreeNode> list = new ArrayList<>();

        List<TreeNode> list1 = count(node3, list);

    }
}
