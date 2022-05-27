package list;

import java.util.PriorityQueue;

/**
 * @description：
 * @author: zhangxianglong
 * @date: 2022/5/26
 */
public class SortList {

    public ListNode sortList(ListNode head) {

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
}
