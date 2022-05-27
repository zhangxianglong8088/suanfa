package list;

import java.util.HashSet;
import java.util.Set;

/**
 * @description：判断链表是否有环
 * @author: zhangxianglong
 * @date: 2022/5/15
 */
public class HasCycle {

    static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }
    }

    /**
     * 通过set判断
     *
     * @param head
     * @return
     */
    static Boolean hasCycle(ListNode head) {
        if (head == null) {
            return Boolean.FALSE;
        }
        Set<ListNode> set = new HashSet<>();

        while (head.next != null) {
            if (set.contains(head)) {
                return Boolean.TRUE;
            } else {
                set.add(head);
                head = head.next;
            }
        }
        return Boolean.FALSE;

    }

    /**
     * 通过快慢指针
     *
     * @param head
     * @return
     */
    static Boolean hasCycle1(ListNode head) {
        if (head == null) {
            return Boolean.FALSE;
        }
        ListNode slow = head;
        ListNode fast = head;


        while (fast != null && fast.next != null) {

            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                return Boolean.TRUE;
            }
        }
        return Boolean.FALSE;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        System.out.println(hasCycle1(node1));
    }
}
