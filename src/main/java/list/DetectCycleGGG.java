package list;

import java.util.HashSet;
import java.util.Set;

/**
 * 142. 环形链表 II 环形链表的入口
 *
 * @description： https://leetcode.cn/problems/linked-list-cycle-ii/
 * @author: zhangxianglong
 * @date: 2022/6/11
 */
public class DetectCycleGGG {

    /**
     * 第一个思路：
     * 通过快慢指针找到快指针和慢指针相等的位置，然后head从头开始走，slow指针继续走
     * slow和head相等的位置就是环形链表入环的第一个结点
     *
     * @param head
     * @return
     */
    public static ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        //定义快慢指针
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            if (fast == slow) {
                while (head != slow) {
                    head = head.next;
                    slow = slow.next;
                }
                return slow;

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

    public ListNode detectCycle3(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }

        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                break;
            }
        }

        ListNode cur = head;
        while (cur != slow && slow != null) {
            cur = cur.next;
            slow = slow.next;
        }
        return slow;
    }

    public static void main(String[] args) {

        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);

        node1.next = node2;
        node2.next = node1;

        ListNode res = detectCycle5(node1);

    }

    public static ListNode detectCycle5(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (fast == slow) {
                break;
            }
        }

        while (head != slow && slow != null) {
            head = head.next;
            slow = slow.next;
        }
        return slow;

    }
}
