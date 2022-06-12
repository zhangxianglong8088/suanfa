package list;

/**
 * 143. 重排链表
 * https://leetcode.cn/problems/reorder-list/
 *
 * @description：
 * @author: zhangxianglong
 * @date: 2022/5/18
 */
public class ReorderListXXXX {

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
     * 放入线性表
     *
     * @param head
     */
    public static void reorderList(ListNode head) {



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

        reorderList1(node1);

    }

    public static void reorderList1(ListNode head) {
        if (head == null) {
            return;
        }

        ListNode mid = findMid(head);

        //获取中间结点的后部分
        ListNode head2 = mid.next;
        mid.next = null;

        //前半部分的头
        ListNode head1 = head;
        ListNode next1 = null;
        //后半部分的头
        head2 = reverse(head2);
        ListNode next2 = null;

        //后半部分间隔的插入到前半部分中
        while (head1 != null && head2 != null) {
            next1 = head1.next;
            next2 = head2.next;

            head1.next = head2;
            head1 = next1;

            head2.next = head1;
            head2 = next2;
        }
    }

    /**
     * 获取链表中间结点
     *
     * @param head
     * @return
     */
    static ListNode findMid(ListNode head) {
        //获取链表的后半部分
        ListNode slow = head;
        ListNode fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    /**
     * 获取链表中间结点
     *
     * @param head
     * @return
     */
    static ListNode reverse(ListNode head) {
        //获取链表的后半部分
        ListNode pre = null;
        ListNode cur = head;

        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}
