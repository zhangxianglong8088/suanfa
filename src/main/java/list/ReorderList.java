package list;

/**
 * 143. 重排链表
 * https://leetcode.cn/problems/reorder-list/
 *
 * @description：
 * @author: zhangxianglong
 * @date: 2022/5/18
 */
public class ReorderList {

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
     * 链表存储到线性表
     *
     * @param head
     */
    public static void reorderList1(ListNode head) {

    }


    /**
     * 链表拆成两半，后半部分逆序 再合并成一个链表
     *
     * @param head
     */
    public void reorderList2(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;
        ListNode curr = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode secondHead = slow;
        slow.next = null;

        while (secondHead != null && curr != null) {

        }


    }

    public static void main(String[] args) {

        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);
        ListNode node7 = new ListNode(7);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        node7.next = null;


        reorderList1(node1);

    }
}
