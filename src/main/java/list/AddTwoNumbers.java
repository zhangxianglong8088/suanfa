package list;

import java.util.Stack;

/**
 * @description：剑指 Offer II 025. 链表中的两数相加
 * https://leetcode.cn/problems/lMSNwu/
 * @author: zhangxianglong
 * @date: 2022/5/18
 */
public class AddTwoNumbers {

    /**
     * 通过栈解决
     *
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        Stack<ListNode> s1 = new Stack<>();
        Stack<ListNode> s2 = new Stack<>();
        while (l1 != null) {
            s1.add(l1);
            l1 = l1.next;
        }

        while (l2 != null) {
            s2.add(l2);
            l2 = l2.next;
        }
        int carry = 0;
        int sum;
        int val;
        ListNode ans = null;
        while (!s1.empty() || !s2.empty()) {
            if (!s1.isEmpty() && !s2.isEmpty()) {
                sum = carry + s1.pop().val + s2.pop().val;
            } else if (!s1.empty() && s2.isEmpty()) {
                sum = carry + s1.pop().val;
            } else {
                sum = carry + s2.pop().val;
            }
            if (sum >= 10) {
                val = sum - 10;
                carry = 1;
            } else {
                val = sum;
                carry = 0;
            }
            ListNode cur = new ListNode(val);
            cur.next = ans;
            ans = cur;
        }
        if (carry == 1) {
            ListNode cur = new ListNode(1);
            cur.next = ans;
            ans = cur;
        }
        return ans;
    }


    public static ListNode reverselist(ListNode l) {
        ListNode pre = null;
        ListNode cur = l;
        while (cur != null) {
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }

    public static void main(String[] args) {

        ListNode node1 = new ListNode(7);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(4);
        ListNode node4 = new ListNode(3);


        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);
        ListNode node7 = new ListNode(4);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = null;


        node5.next = node6;
        node6.next = node7;
        node7.next = null;

        ListNode res = addTwoNumbers1(node1, node5);

    }

    public static ListNode addTwoNumbers1(ListNode l1, ListNode l2) {

        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();

        //1、list1 和list2 分别压入stack1和stack2
        while (l1 != null) {
            stack1.add(l1.val);
            l1 = l1.next;
        }

        while (l2 != null) {
            stack2.add(l2.val);
            l2 = l2.next;
        }

        int carry = 0;
        ListNode pre = new ListNode(-1);
        ListNode cur = pre;
        int nodeValue;
        int sum;


        //stack1和stack2都不为空
        while (!stack1.isEmpty() && !stack2.isEmpty()) {
            sum = carry + stack1.pop() + stack2.pop();
            if (sum >= 10) {
                carry = 1;
                nodeValue = sum - 10;
            } else {
                nodeValue = sum;
                carry = 0;
            }
            ListNode node = new ListNode(nodeValue);
            cur.next = node;
            cur = cur.next;
        }

        while (!stack2.isEmpty() && stack1.isEmpty()) {
            sum = stack2.pop() + carry;
            if (sum >= 10) {
                nodeValue = sum - 10;
                carry = 1;
            } else {
                nodeValue = sum;
                carry = 0;
            }
            ListNode node = new ListNode(nodeValue);
            cur.next = node;
            cur = cur.next;

        }

        while (stack2.isEmpty() && !stack1.isEmpty()) {
            sum = stack1.pop() + carry;
            if (sum >= 10) {
                nodeValue = sum - 10;
                carry = 1;
            } else {
                nodeValue = sum;
                carry = 0;
            }
            ListNode node = new ListNode(nodeValue);
            cur.next = node;
            cur = cur.next;
        }

        if (carry == 1) {
            cur.next = new ListNode(1);

        }
        return reverselist(pre.next);
    }
}
