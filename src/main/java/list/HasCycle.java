package list;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @description：判断链表是否有环 https://leetcode.cn/problems/linked-list-cycle/
 * @author: zhangxianglong
 * @date: 2022/5/15
 */
public class HasCycle {

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


    static ListNode hasCycle2(ListNode head) {
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
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = null;

        System.out.println(hasCycle3(node1));
    }

    static Boolean hasCycle3(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }
}
