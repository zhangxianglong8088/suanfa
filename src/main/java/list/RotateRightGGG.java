package list;

/**
 * https://leetcode.cn/problems/rotate-list/
 *
 * @description：给你一个链表的头节点 head ，旋转链表，将链表每个节点向右移动 k 个位置。
 * @author: zhangxianglong
 * @date: 2022/5/18
 */
public class RotateRightGGG {

    /**
     * * 记录原链表的长度，将原链表闭合为环，再在指定位置断开
     * 断开的位置为 l-k k可以大于l 所以 断开的位置为 l-k%l
     *
     * @param head
     * @param k
     * @return
     */
    public static ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return head;
        }

        //链表成环
        ListNode cur = head;
        int l = 1;
        while (cur.next != null) {
            cur = cur.next;
            l++;
        }
        cur.next = head;

        //head、headPre 往后走K步
        for (int i = 1; i <= l - k % l; i++) {
            head = head.next;
            cur = cur.next;
        }
        cur.next = null;
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

        rotateRight(node1, 1);
    }
}
