package list;

import java.util.Stack;

/**
 * @description：剑指 Offer II 025. 链表中的两数相加
 * https://leetcode.cn/problems/lMSNwu/
 * @author: zhangxianglong
 * @date: 2022/5/18
 */
public class AddTwoNumbers {
    static class ListNode {
        int val;
        ListNode next;

        public ListNode(int val) {
            this.val = val;
        }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

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

        addTwoNumbers2(node1, node5);

    }

    public static ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        if(l1==null){
            return l2;
        }
        if(l2==null){
            return l1;
        }
        Stack<ListNode> s1 = new Stack();
        Stack<ListNode> s2 = new Stack();

        while (l1 != null) {
            s1.add(l1);
            l1 = l1.next;
        }

        while (l2 != null) {
            s2.add(l2);
            l2 = l2.next;
        }

        int jw = 0;
        ListNode pre = new ListNode(-1);
        ListNode cur = pre;
        while (!s1.isEmpty() || !s2.isEmpty()) {
            int sum = jw;
            if (!s1.isEmpty()) {
                ListNode node1 = s1.pop();
                sum += node1.val;
            }

            if (!s2.isEmpty()) {
                ListNode node2 = s2.pop();
                sum += node2.val;
            }
            if (sum >= 10) {
                jw = 1;
                sum = sum - 10;
            } else {
                jw = 0;
            }
            cur.next = new ListNode(sum);
            cur = cur.next;
        }
        if(jw==1){
            ListNode node = new ListNode(1);
            cur.next = node;
        }

        ListNode res =  reverselist(pre.next);
        return  res;
    }


    public static  ListNode reverselist(ListNode l){
        ListNode pre=null;
        ListNode cur=l;
        while(cur!=null){
            ListNode temp=cur.next;
            cur.next=pre;
            pre=cur;
            cur=temp;
        }
        return pre;
    }
}
