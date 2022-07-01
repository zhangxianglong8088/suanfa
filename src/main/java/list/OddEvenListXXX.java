package list;

/**
 * @description：https://leetcode.cn/problems/odd-even-linked-list/ 328. 奇偶链表
 * @author: zhangxianglong
 * @date: 2022/6/12
 */
public class OddEvenListXXX {

    public static ListNode oddEvenList(ListNode head) {

        ListNode pre1 = new ListNode(-1);
        ListNode cur1 = head;
        pre1.next = cur1;

        ListNode pre2 = new ListNode(-1);
        ListNode cur2 = head.next;
        pre2.next = cur2;


        while (cur1 != null && cur1.next != null) {
            cur1.next = cur1.next.next;
        }
        while (cur2 != null && cur2.next != null) {
            cur2.next = cur2.next.next;
        }
        cur1.next = pre2.next;

        return pre1.next;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = null;


        ListNode res = oddEvenList(node1);
    }
}
