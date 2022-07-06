package list;

/**
 * @description：反转一个链表 迭代法
 * https://juejin.cn/post/6844904058562543623#heading-5
 * @author: zhangxianglong
 * @date: 2022/5/12
 */


public class ReverseList {
    /**
     * 迭代法-反转链表
     *
     * @param head
     * @return
     */
    public static ListNode reverse1(ListNode head) {
        //null->1->2->3->4->5->6->7->8
        ListNode pre = null;
        ListNode cur = head;

        if (head == null) {
            return null;
        }

        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    /**
     * 递归-反转链表
     *
     * @param head
     * @return
     */
    public static ListNode reverse2(ListNode head) {
        if (head == null) {
            return null;
        }

        if (head.next == null) {
            return head;
        }

        ListNode reverseHead = reverse2(head.next);
        //当前head变更为
        head.next.next = head;
        head.next = null;

        return reverseHead;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);

        ListNode node2 = new ListNode(2);

        ListNode node3 = new ListNode(3);

        ListNode node4 = new ListNode(4);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = null;

        ListNode pre = reverse2(node1);
    }
}
