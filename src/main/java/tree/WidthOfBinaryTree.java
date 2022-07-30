package tree;

import common.TreeNode;

import java.util.LinkedList;

/**
 * @description：662. 二叉树最大宽度
 * https://leetcode.cn/problems/maximum-width-of-binary-tree/
 * @author: zhangxianglong
 * @date: 2022/7/27
 */
public class WidthOfBinaryTree {

    public static int widthOfBinaryTree(TreeNode root) {
        int max = 1;
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();

        root.val = 1;
        queue.offer(root);

        while (!queue.isEmpty()) {
            //当前层的宽度
            int width = queue.getLast().val - queue.getFirst().val + 1;

            int n = queue.size();

            for (int i = 0; i < n; i++) {
                TreeNode tmp = queue.poll();

                if (tmp.left != null) {
                    //节点值修改的目的是从根节点到子结点连续  用左右边减去最左边 就是当前层的最大节点数
                    //改变当前结点的值 左边结点为 其根结点的2倍
                    tmp.left.val = tmp.val * 2;
                    queue.offer(tmp.left);
                }

                if (tmp.right != null) {
                    //改变当前结点的值 右边结点 其根结点的2倍+1
                    tmp.right.val = tmp.val * 2 + 1;
                    queue.offer(tmp.right);
                }
            }
            max = Math.max(width, max);
        }
        return max;
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


        int res = widthOfBinaryTree(node3);

        System.out.println(res);
    }
}


