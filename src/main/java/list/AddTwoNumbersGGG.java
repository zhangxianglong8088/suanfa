package list;

import java.util.Stack;

/**
 * @description：剑指 Offer II 025. 链表中的两数相加
 * https://leetcode.cn/problems/lMSNwu/
 * @author: zhangxianglong
 * @date: 2022/5/18
 */
public class AddTwoNumbersGGG {

    /**
     * 通过栈解决
     *
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        Stack<Integer> stack1 = new Stack<>();

        Stack<Integer> stack2 = new Stack<>();

        ListNode pre = new ListNode(-1);

        ListNode cur = pre;

        while (l1 != null) {
            stack1.add(l1.val);
            l1 = l1.next;
        }

        while (l2 != null) {
            stack2.add(l2.val);
            l2 = l2.next;
        }

        int carry = 0;
        int sum;
        while (!stack1.isEmpty() || !stack2.isEmpty()) {
            if (!stack1.isEmpty() && !stack2.isEmpty()) {
                int value1 = stack1.pop();
                int value2 = stack2.pop();
                sum = carry + value1 + value2;
            } else if (stack1.isEmpty()) {
                int value2 = stack2.pop();
                sum = carry + value2;
            } else {
                int value1 = stack1.pop();
                sum = carry + value1;

            }
            if (sum >= 10) {
                carry = 1;
                sum = sum - 10;
            } else {
                carry = 0;
            }
            cur.next = new ListNode(sum);
            cur = cur.next;
        }

        if (carry == 1) {
            sum = carry;
            cur.next = new ListNode(sum);
        }

        //反转pre.next 链表
        ListNode newCur = pre.next;
        ListNode newPre = null;

        while (newCur != null) {
            ListNode next = newCur.next;
            newCur.next = newPre;
            newPre = newCur;
            newCur = next;
        }

        return newPre;
    }


    /**
     * 链表两次反转
     *
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        //反转两个链表
        ListNode l1New = reverseList(l1);
        ListNode l2New = reverseList(l2);
        ListNode pre = new ListNode(-1);
        ListNode cur = pre;

        int carry = 0;
        int sum;
        while (l1New != null || l2New != null) {
            if (l1New != null && l2New != null) {
                sum = carry + l1New.val + l2New.val;
                l1New = l1New.next;
                l2New = l2New.next;
            } else if (l1New == null) {
                sum = carry + l2New.val;
                l2New = l2New.next;
            } else {
                sum = carry + l1New.val;
                l1New = l1New.next;
            }

            if (sum >= 10) {
                carry = 1;
                sum = sum - 10;
            } else {
                carry = 0;
            }
            ListNode tmp = new ListNode(sum);
            cur.next = tmp;
            cur = cur.next;
        }

        if (carry == 1) {
            sum = carry;
            cur.next = new ListNode(sum);
        }
        return reverseList(pre.next);
    }

    /**
     * 反转链表
     *
     * @param head
     * @return
     */
    static ListNode reverseList(ListNode head) {

        ListNode cur = head;
        ListNode pre = null;

        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }

        return pre;

    }


    public static void main(String[] args) {

        ListNode node4 = new ListNode(7);
        ListNode node3 = new ListNode(2);
        ListNode node2 = new ListNode(4);
        ListNode node1 = new ListNode(3);


        ListNode node7 = new ListNode(5);
        ListNode node6 = new ListNode(6);
        ListNode node5 = new ListNode(4);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = null;


        node5.next = node6;
        node6.next = node7;
        node7.next = null;

        ListNode res = addTwoNumbers2(node1, node5);

    }
}
