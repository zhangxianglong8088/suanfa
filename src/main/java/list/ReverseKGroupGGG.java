package list;

/**
 * 25. K 个一组翻转链表
 * https://leetcode.cn/problems/reverse-nodes-in-k-group/
 *
 * @description：单链表K个一组反转
 * @author: zhangxianglong
 * @date: 2022/5/13
 */
public class ReverseKGroupGGG {

    public static ListNode reverseKGroup(ListNode head, int k) {

        //递归终止条件，当head为null时中止递归
        if (head == null) {
            return null;
        }
        //根据k寻找待翻转链表的尾
        ListNode end = head;

        for (int i = 0; i < k - 1; i++) {
            end = end.next;
            //如果不够k个节点 剩余的节点返回头节点
            if (end == null) {
                return head;
            }
        }

        //保存好下次翻转的链表的头
        ListNode nextListNode = end.next;

        //翻转[start , end]范围中的链表，并返回头节点
        ListNode newHead = reverseListNode(head, end);

        //此时head已经变成了链表的尾节点
        //本次翻转后的链表的尾节点连接上下一个待翻转链表的头节点，递归实现
        head.next = reverseKGroup(nextListNode, k);

        return newHead;
    }


    public static void main(String[] args) {

        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        ListNode node = reverseKGroup2(node1, 3);
    }

    /**
     * 头插法反转一个链表的区间
     *
     * @param start
     * @param end
     * @return
     */
    static ListNode reverseListNode(ListNode start, ListNode end) {
        end.next = null;
        ListNode pre = new ListNode(-1);
        pre.next = start;
        ListNode next;
        while (start.next != null) {
            next = start.next;
            start.next = next.next;
            next.next = pre.next;
            pre.next = next;

        }
        return pre.next;
    }


    public static ListNode reverseKGroup2(ListNode head, int k) {
        if (head == null) {
            return head;
        }

        //1、从头循环k次找到待反转的链表的头和尾部
        ListNode tail = head;
        for (int i = 0; i < k - 1; i++) {
            if (tail == null) {
                break;
            }
            tail = tail.next;
        }
        if (tail == null) {
            return head;
        }

        //找到下一次反转链表的头
        ListNode nextHead = tail.next;

        ListNode reverseHead = reverse2(head, tail);

        ListNode subHead = reverseKGroup2(nextHead, k);

        head.next = subHead;

        return reverseHead;

    }


    //反转链表
    public static ListNode reverse2(ListNode head, ListNode tail) {
        if (tail != null) {
            tail.next = null;
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
}
