package list;

import java.util.PriorityQueue;

/**
 * @description：链表排序 https://leetcode.cn/problems/7WHec2/
 * @author: zhangxianglong
 * @date: 2022/5/26
 */
public class SortListGGG {

    public static ListNode sortList1(ListNode head) {

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

    /**
     * 归并排序思路
     *
     * @param head
     * @return
     */
    public static ListNode sortList2(ListNode head) {
        return sort(head, null);
    }


    /**
     * 归并排序
     *
     * @param head
     * @param tail
     * @return
     */
    public static ListNode sort(ListNode head, ListNode tail) {
        //递归终止条件(重点理解这里)
        if (head == null) {
            return head;
        }
        if (head.next == tail) {
            head.next = null;
            return head;
        }

        //1、找到链表的中间位置
        ListNode fast = head;
        ListNode slow = head;

        while (fast != tail && fast.next != tail) {
            fast = fast.next.next;
            slow = slow.next;
        }

        //2、中间位置断开 形成两个链表
        ListNode middle = slow;

        //3、对两个链表进行排序
        ListNode node1 = sort(head, middle);
        ListNode node2 = sort(middle, tail);


        //4、合并两个排序链表
        return merger(node1, node2);
    }


    /**
     * 合并两个排序链表
     *
     * @param l1
     * @param l2
     * @return
     */
    static ListNode merger(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        ListNode pre = new ListNode(-1);
        ListNode cur = pre;

        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }

        if (l1 == null) {
            cur.next = l2;
        }
        if (l2 == null) {
            cur.next = l1;
        }
        return pre.next;
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
}
