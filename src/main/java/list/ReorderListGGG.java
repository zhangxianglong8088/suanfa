package list;

/**
 * 143. 重排链表
 * https://leetcode.cn/problems/reorder-list/
 *
 * @description：
 * @author: zhangxianglong
 * @date: 2022/5/18
 */
public class ReorderListGGG {


    public static void reorderList(ListNode head) {
        //快慢指针找到中间位置
        ListNode mid = findMid(head);

        //反转链表的后半部分
        ListNode half = reverse(mid);

        //后半部分间隔插入到前部分

        ListNode next1;
        ListNode next2;

        ListNode head1 = head;
        ListNode head2 = half;

        while (head1 != null && head2 != null) {
            next1 = head1.next;
            next2 = head2.next;

            head1.next = head2;
            head1 = next1;

            head2.next = head1;
            head2 = next2;
        }
        if (head1 != null) {
            head1.next = null;
        }
    }

    static ListNode findMid(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow;
    }

    static ListNode reverse(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode cur = head;
        ListNode pre = null;
        ListNode next;

        while (cur != null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    public static void main(String[] args) {

        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        reorderList(node1);

    }
}
