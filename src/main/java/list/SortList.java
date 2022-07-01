package list;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @description：链表排序 https://leetcode.cn/problems/7WHec2/
 * @author: zhangxianglong
 * @date: 2022/5/26
 */
public class SortList {

    public static ListNode sortList(ListNode head) {

        if (head == null) {
            return head;
        }
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        while (head != null) {
            queue.offer(head.val);
            head = head.next;
        }

        ListNode pre = new ListNode();
        pre.val = -1;
        ListNode preHead = pre;

        while (!queue.isEmpty()) {
            ListNode tmp = new ListNode();
            tmp.val = queue.poll();
            pre.next = tmp;
            pre = pre.next;
        }

        return preHead.next;

    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(5);
        ListNode node3 = new ListNode(2);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(3);
        ListNode node6 = new ListNode(7);
        ListNode node7 = new ListNode(6);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        node7.next = null;

        ListNode head = sortList2(node1);
    }

    public static ListNode sortList2(ListNode head) {


        Queue<ListNode> queue = new PriorityQueue<>((node1, node2) -> (node1.val - node2.val));

        while (head != null) {
            queue.add(head);
            head = head.next;
        }
        ListNode pre = new ListNode(-1);
        ListNode cur = pre;


        while (!queue.isEmpty()) {
            ListNode tmp = queue.poll();
            tmp.next = null;
            cur.next = tmp;
            cur = cur.next;
        }

        return pre.next;
    }
}
