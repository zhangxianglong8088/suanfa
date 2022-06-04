package list;

/**
 * 19. 删除链表的倒数第 N 个结点
 *
 * @description：https://leetcode.cn/problems/remove-nth-node-from-end-of-list/
 * @author: zhangxianglong
 * @date: 2022/6/4
 */
public class RemoveNthFromEnd {


    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast = head;
        ListNode slow = head;
        int len = 0;

        while (fast != null) {
            fast = fast.next;
            len++;
        }
        //如果链表长度为1 删除倒数第一个结点
        if (len == 1 && n == 1) {
            return null;
        }
        //如果删除的是头结点
        if (len == n) {
            return head.next;
        }

        for (int i = 0; i < len - n - 1; i++) {
            slow = slow.next;
        }

        slow.next = slow.next.next;

        return head;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
//        ListNode node2 = new ListNode(2);
//        ListNode node3 = new ListNode(3);
//        ListNode node4 = new ListNode(4);
//        ListNode node5 = new ListNode(5);

//        node1.next = node2;
//        node2.next = node3;
//        node3.next = node4;
//        node4.next = node5;
//        node5.next = null;

        removeNthFromEnd(node1, 1);
    }

}
