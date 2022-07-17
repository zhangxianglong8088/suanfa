package list;

import java.util.PriorityQueue;

/**
 * 合并K个有序链表
 * 通过优先级队列
 * https://leetcode.cn/problems/merge-k-sorted-lists/
 *
 * @description：
 * @author: zhangxianglong
 * @date: 2022/5/21
 */
public class MergeKListsGGG {

    /**
     * 用容量为K的最小堆优先队列，把链表的头结点都放进去，然后出队当前优先队列中最小的，挂上链表，，
     * 然后让出队的那个节点的下一个入队，再出队当前优先队列中最小的，直到优先队列为空。
     *
     * @param lists
     * @return
     */
    public static ListNode mergeKLists(ListNode[] lists) {

        if (lists.length == 0) {
            return null;
        }

        ListNode dummyHead = new ListNode(0);
        ListNode curr = dummyHead;
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> (a.val - b.val));

        for (ListNode list : lists) {
            if (list == null) {
                continue;
            }
            pq.add(list);
        }

        while (!pq.isEmpty()) {
            ListNode nextNode = pq.poll();
            curr.next = nextNode;
            curr = curr.next;
            if (nextNode.next != null) {
                pq.add(nextNode.next);
            }
        }
        return dummyHead.next;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(-2);
        ListNode node2 = new ListNode(-1);
        ListNode node3 = new ListNode(-1);


        ListNode node4 = new ListNode(2);
        ListNode node5 = new ListNode(3);
        ListNode node6 = new ListNode(8);

        ListNode node7 = new ListNode(3);
        ListNode node8 = new ListNode(6);
        ListNode node9 = new ListNode(9);

        node1.next = node2;
        node2.next = node3;
        node3.next = null;


        node4.next = node5;
        node5.next = node6;
        node6.next = null;

        node7.next = node8;
        node8.next = node9;
        node9.next = null;

        ListNode[] list = new ListNode[]{node1, node4, node7};

        ListNode res = mergeKLists(list);
    }
}
