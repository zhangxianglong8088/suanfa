package list;

/**
 * 25. K 个一组翻转链表
 * https://leetcode.cn/problems/reverse-nodes-in-k-group/
 *
 * @description：单链表K个一组反转
 * @author: zhangxianglong
 * @date: 2022/5/13
 */
public class ReverseKGroup {

    public static ListNode reverseKGroup(ListNode head, int k) {

        //递归终止条件，当head为null时中止递归
        if (head == null) {
            return null;
        }
        //根据k寻找待翻转链表的尾
        ListNode end = head;

        for (int i = 0; i < k - 1; i++) {
            end = end.next;
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

    static ListNode reverseListNode(ListNode start, ListNode end) {
        ListNode tmp = null;
        while (tmp != end) {
            ListNode next = start.next;
            start.next = tmp;
            tmp = start;
            start = next;
        }
        return tmp;
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

        ListNode node = reverseKGroup3(node1, 2);
    }

    public static ListNode reverseKGroup3(ListNode head, int k) {
        if (head == null) {
            return head;
        }
        //1、找到k个一组的头结点和尾结点
        ListNode end = head;

        for (int i = 0; i < k - 1; i++) {
            end = end.next;
            if (end == null) {
                return head;
            }
        }

        //2、记录下一个待反转的头结点
        ListNode nextHead = end.next;

        //3、反转K个一组的链表
        ListNode newHead = reverseListNode2(head, end);

        //4、递归调用reverseKGroup方法
        head.next = reverseKGroup3(nextHead, k);

        return newHead;
    }

    static ListNode reverseListNode2(ListNode cur, ListNode end) {
        ListNode pre = null;
        while (pre != end) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}
