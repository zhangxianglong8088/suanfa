package list;

/**
 * 109. 有序链表转换二叉搜索树
 * https://leetcode.cn/problems/convert-sorted-list-to-binary-search-tree/
 *
 * @description：
 * @author: zhangxianglong
 * @date: 2022/6/12
 */
public class SortedListToBSTXXX {

    public static TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }
        return builder(head, null);
    }

    public static TreeNode builder(ListNode head, ListNode tail) {
        if (head == tail) {
            return null;

        }
        ListNode fast = head;
        ListNode slow = head;

        while (fast != tail && fast.next != tail) {
            fast = fast.next.next;
            slow = slow.next;
        }
        TreeNode root = new TreeNode(slow.val);
        root.left = builder(head, slow);
        root.right = builder(slow.next, tail);

        return root;

    }


    public static void main(String[] args) {

        ListNode node1 = new ListNode(-10);
        ListNode node2 = new ListNode(-3);
        ListNode node3 = new ListNode(0);
        ListNode node4 = new ListNode(5);
        ListNode node5 = new ListNode(9);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        TreeNode treeNode = sortedListToBST(node1);
    }


    static class TreeNode {

        int val;
        TreeNode right;
        TreeNode left;

        public TreeNode(int val, TreeNode right, TreeNode left) {
            this.val = val;
            this.right = right;
            this.left = left;
        }

        public TreeNode(int val) {
            this.val = val;
        }
    }
}
