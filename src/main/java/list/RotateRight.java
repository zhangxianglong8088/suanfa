package list;

/**
 * https://leetcode.cn/problems/rotate-list/
 *
 * @description：给你一个链表的头节点 head ，旋转链表，将链表每个节点向右移动 k 个位置。
 * @author: zhangxianglong
 * @date: 2022/5/18
 */
public class RotateRight {

    static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    /**
     * 记录原链表的长度，将原链表闭合为环，再在指定位置断开
     *
     * @param head
     * @return
     */
    public static ListNode rotateRight(ListNode head, int k) {
        if (k == 0 || head == null || head.next == null) {
            return head;
        }

        int l = 1;
        ListNode cur = head;
        while (cur.next != null) {
            l++;
            cur = cur.next;
        }
        cur.next = head;
        //判断
        for (int i = 1; i < l - k % l; i++) {
            head = head.next;
        }
        ListNode pre = head.next;
        head.next = null;
        return pre;
    }

    public static void main(String[] args) {

        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = null;

        rotateRight(node1, 1);
    }
}
