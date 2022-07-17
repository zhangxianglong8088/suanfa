package list;

/**
 * 19. 删除链表的倒数第 N 个结点
 *
 * @description： https://leetcode.cn/problems/remove-nth-node-from-end-of-list/
 * @author: zhangxianglong
 * @date: 2022/6/4
 */
public class RemoveNthFromEndGGG {


    public static ListNode removeNthFromEnd(ListNode head, int n) {
        int len = 0;
        ListNode cur = head;

        while (cur != null) {
            cur = cur.next;
            len++;
        }
        /**
         * 如果删除的结点为第一个结点
         */
        if (len == n) {
            return head.next;
        }

        ListNode curNew = head;
        for (int i = 0; i < len - n - 1; i++) {
            curNew = curNew.next;
        }
        if (curNew.next != null) {
            curNew.next = curNew.next.next;
        }

        return head;

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

        removeNthFromEnd(node1, 3);
    }
}
