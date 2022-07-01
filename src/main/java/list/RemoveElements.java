package list;

/**
 * @description：203. 移除链表元素
 * 给你一个链表的头节点 head 和一个整数 val ，请你删除链表中所有满足 Node.val == val 的节点，并返回 新的头节点 。
 * https://leetcode.cn/problems/remove-linked-list-elements/
 * @author: zhangxianglong
 * @date: 2022/5/17
 */
public class RemoveElements {
    static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    /**
     * @param head
     * @param val
     * @return
     */
    public static ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return null;
        }

        ListNode pre = new ListNode(-1);
        pre.next = head;
        ListNode curr = pre;

        while (curr.next != null) {
            if (curr.next.val == val) {
                curr.next = curr.next.next;
            } else {
                curr = curr.next;
            }
        }
        return pre.next;
    }

    /**
     * 借助 head和cur两个指针的思路
     *
     * @param head
     * @param val
     * @return
     */
    public static ListNode removeElements1(ListNode head, int val) {
        if (head == null) {
            return head;
        }
        ListNode pre = new ListNode(-1);
        pre.next = head;
        ListNode cur = pre;

        while (head != null) {
            if (head.val == val) {
                cur.next = head.next;
                head = head.next;
            } else {
                cur = cur.next;
                head = head.next;
            }
        }

        return pre.next;
    }


    public static void main(String[] args) {

        ListNode node1 = new ListNode(7);
        ListNode node2 = new ListNode(7);
        ListNode node3 = new ListNode(6);
        ListNode node4 = new ListNode(3);
        ListNode node5 = new ListNode(4);
        ListNode node6 = new ListNode(5);
        ListNode node7 = new ListNode(6);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        node7.next = null;

        ListNode head = removeElements1(node1, 7);

    }
}
