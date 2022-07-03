package tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @description：114. 二叉树展开为链表
 * 给你二叉树的根结点 root ，请你将它展开为一个单链表：
 * <p>
 * 展开后的单链表应该同样使用 TreeNode ，其中 right 子指针指向链表中下一个结点，而左子指针始终为 null 。
 * 展开后的单链表应该与二叉树 先序遍历 顺序相同。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/flatten-binary-tree-to-linked-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author: zhangxianglong
 * @date: 2022/5/19
 */
public class Flatten {

    /**
     * @param root
     */
    public static void flatten(TreeNode root) {

        if (root == null) {
            return;
        }

        TreeNode left = root.left;
        TreeNode right = root.right;

        flatten(left);

        flatten(right);


        root.right = left;
        right.left = null;

        // 3、将原先的右子树接到当前右子树的末端
        TreeNode p = root;
        while (p.right != null) {
            p = p.right;
        }
        p.right = right;

    }


    public static void main(String[] args) {

        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode nod3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);


        node1.left = node2;
        node1.right = node5;

        node2.left = nod3;
        node2.right = node4;

        node5.right = node6;


        flatten2(node1);


    }

    public static void flatten2(TreeNode root) {
        List<TreeNode> list = new ArrayList();
        pre(root, list);
        for (int i = 0; i < list.size() - 1; i++) {
            TreeNode node1 = list.get(i);
            TreeNode node2 = list.get(i + 1);
            node1.left = null;
            node1.right = node2;
        }
    }

    public static void pre(TreeNode root, List<TreeNode> list) {
        if (root == null) {
            return;
        }

        list.add(root);
        pre(root.left, list);
        pre(root.right, list);
    }























}
