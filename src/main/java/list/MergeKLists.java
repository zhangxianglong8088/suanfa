package list;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 合并K个有序链表
 * https://leetcode.cn/problems/merge-k-sorted-lists/
 *
 * @description：
 * @author: zhangxianglong
 * @date: 2022/5/21
 */
public class MergeKLists {
    /**
     * 合并K个有序链表
     * 通过优先级队列
     *
     * @param lists
     * @return
     */
    public static ListNode mergeKLists(ListNode[] lists) {

        Queue<ListNode> queue = new PriorityQueue<>((p1, p2) -> (p1.val - p2.val));

        for (ListNode node : lists) {
            while (node != null) {
                queue.offer(node);
                node = node.next;
            }
        }

        ListNode pre = new ListNode(-1);
        ListNode cur = pre;

        while (!queue.isEmpty()) {
            ListNode node = queue.poll();
            node.next = null;
            cur.next = node;
            cur = cur.next;
        }
        return pre.next;
    }


    public static void main(String[] args) {
        ListNode node1 = new ListNode(-2);
        ListNode node2 = new ListNode(-1);
        ListNode node3 = new ListNode(-1);
        ListNode node4 = new ListNode(-1);

//        ListNode node4 = new ListNode(2);
        ListNode node5 = null;
//        ListNode node6 = new ListNode(8);
//
//
//        ListNode node7 = new ListNode(3);
//        ListNode node8 = new ListNode(6);
//        ListNode node9 = new ListNode(9);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = null;

//        node.next = null;

//        node4.next = node5;
//        node5.next = node6;
//        node6.next = null;
//
//        node7.next = node8;
//        node8.next = node9;
//        node9.next = null;

        ListNode[] list = new ListNode[]{node1, node5};

        mergeKLists(list);

    }
}
