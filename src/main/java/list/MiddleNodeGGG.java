package list;

/**
 * @description：876. 链表的中间结点
 * 给定一个头结点为 head 的非空单链表，返回链表的中间结点。
 * https://leetcode.cn/problems/middle-of-the-linked-list/
 * <p>
 * 如果有两个中间结点，则返回第二个中间结点。
 * @author: zhangxianglong
 * @date: 2022/5/17
 */
public class MiddleNodeGGG {

    public static ListNode middleNode(ListNode head) {

        ListNode left = head;
        ListNode right = head;

        while (right != null && right.next != null) {
            left = left.next;
            right = right.next.next;
        }
        return left;
    }

    public static void main(String[] args) {

        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(3);
        ListNode node5 = new ListNode(2);
        ListNode node6 = new ListNode(1);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = null;

        middleNode(node1);
    }
}
