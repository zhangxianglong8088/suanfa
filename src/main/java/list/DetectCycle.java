package list;

import java.util.HashSet;
import java.util.Set;

/**
 * 142. 环形链表 II 环形链表的入口
 *
 * @description：https://leetcode.cn/problems/linked-list-cycle-ii/
 * @author: zhangxianglong
 * @date: 2022/6/11
 */
public class DetectCycle {

    /**
     * detectCycle
     *
     * @param head
     * @return
     */
    public ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode slow = head, fast = head;
        while (fast != null) {
            slow = slow.next;
            if (fast.next != null) {
                fast = fast.next.next;
            } else {
                return null;
            }
            if (fast == slow) {
                ListNode ptr = head;
                while (ptr != slow) {
                    ptr = ptr.next;
                    slow = slow.next;
                }
                return ptr;
            }
        }
        return null;
    }

    /**
     * 通过set来判断
     *
     * @param head
     * @return
     */
    public ListNode detectCycle2(ListNode head) {
        Set<ListNode> set = new HashSet();

        while (head != null) {
            if (set.contains(head)) {
                return head;
            }
            set.add(head);
            head = head.next;
        }
        return null;
    }
}
