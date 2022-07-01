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
public class DetectCycleXXX {

    /**
     * detectCycle
     *
     * @param head
     * @return
     */
    public static ListNode detectCycle(ListNode head) {
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
            //当 slow 与 fast 相遇时，我们再额外使用一个指针 ptr。起始，它指向链表头部；随后，它和 slow 每次向后移动一个位置。最终，它们会在入环点相遇。
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

    public static void main(String[] args) {

        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
//        ListNode node3 = new ListNode(0);
//        ListNode node4 = new ListNode(-4);

        node1.next = node2;
        node2.next = node1;
//        node3.next = node1;
//        node4.next = node2;

        ListNode res = detectCycle(node1);

    }
}
