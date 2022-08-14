package tree;

import common.TreeNode;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 判断一棵树是否为完全二叉树
 * 思路：由于判断完全二叉树，当遍历当前层时如果遇到空节点，如果该空节点右侧还有节点，说明该树一定不是完全二叉树，直接返回false，
 * 遍历完返回true；
 *
 * @description： https://www.nowcoder.com/practice/f31fc6d3caf24e7f8b4deb5cd9b5fa97?tpId=117&tqId=37822&rp=1&ru=/exam/oj&qru=/exam/oj&sourceUrl=%2Fexam%2Foj%3Fpage%3D2%26tab%3D%25E7%25AE%2597%25E6%25B3%2595%25E7%25AF%2587%26topicId%3D117&difficulty=undefined&judgeStatus=undefined&tags=&title=
 * @author: zhangxianglong
 * @date: 2022/7/25
 */
public class IsCompleteTree {

    public static boolean isCompleteTree(TreeNode root) {

        //标记第一次遇到了空节点
        boolean flag = false;

        if (root == null) {
            return true;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode nowNode = queue.poll();
            //说明当前节点是空节点
            if (nowNode == null) {
                //表示第一次遇到了空节点 则持续尝试队列后面的结点是不是全是空节点，如果是 则说明是完全二叉树，
                //如果不是 则说明不是完全二叉树
                flag = true;
                continue;
            }

            // 遇到空节点直接返回false
            if (flag) {
                return false;
            }
            queue.offer(nowNode.left);
            queue.offer(nowNode.right);
        }
        return true;
    }


    public static void main(String[] args) {

        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);

        node1.left = node2;
        node1.right = node3;

        node2.left = node4;
        node2.right = node5;

        Boolean res = isCompleteTree(node1);

        System.out.println(res);

    }
}
