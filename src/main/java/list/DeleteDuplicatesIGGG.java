package list;

import java.util.HashSet;
import java.util.Set;

/**
 * 83. 删除排序链表中的重复元素(1 2,2,3,4, ----> 1,2,3,4)
 *
 * @description： https://leetcode.cn/problems/remove-duplicates-from-sorted-list/
 * @author: zhangxianglong
 * @date: 2022/5/17
 */
public class DeleteDuplicatesIGGG {


    /**
     * 链表是排序好的，那么重复的元素是相邻的
     *
     * @param head
     * @return
     */
    public static ListNode deleteDuplicates1(ListNode head) {
        ListNode pre = new ListNode(-1);
        pre.next = head;
        //注意当前指针的定义 如果是删除相邻重复的元素，则cur = pre.next
        //如果是删除指定的元素，cur = pre

        ListNode cur = pre.next;

        while (cur != null && cur.next != null) {

            if (cur.val == cur.next.val) {
                cur.next = cur.next.next;

            } else {
                cur = cur.next;
            }
        }
        return pre.next;
    }

    /**
     * 第二个思路
     *
     * @param head
     * @return
     */
    public static ListNode deleteDuplicates2(ListNode head) {

        ListNode pre = new ListNode(-1);
        ListNode cur = pre;
        pre.next = head;

        while (head != null && head.next != null) {

            if (cur.next.val == head.next.val) {
                cur.next = cur.next.next;
                head.next = head.next.next;
            } else {
                cur = cur.next;
                head = head.next;
            }
        }
        return pre.next;
    }


    /**
     * 如果链表不是排序的，可以通过hash表辅助
     *
     * @param head
     * @return
     */

    public static ListNode deleteDuplicates3(ListNode head) {

        if (head == null) {
            return null;
        }
        Set<Integer> set = new HashSet<>();
        ListNode cur = head;
        set.add(head.val);

        while (cur.next != null) {
            if (set.contains(cur.next.val)) {
                cur.next = cur.next.next;
            } else {
                set.add(cur.next.val);
                cur = cur.next;
            }
        }
        return head;
    }


    public static void main(String[] args) {

        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(1);
        ListNode node3 = new ListNode(2);
        ListNode node4 = new ListNode(3);
        ListNode node5 = new ListNode(4);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = null;

        deleteDuplicates2(node1);
    }
}
