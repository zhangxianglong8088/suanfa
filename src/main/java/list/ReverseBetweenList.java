package list;

import java.util.List;

/**
 * https://leetcode.cn/problems/reverse-linked-list-ii/
 * 92
 *
 * @description：反转链表的一部分
 * @author: zhangxianglong
 * @date: 2022/5/12
 */
public class ReverseBetweenList {


    /**
     * 思路
     * https://www.cnblogs.com/treasury/p/12751395.html
     *
     * @param head
     * @param m
     * @param n
     * @return
     */
    static ListNode reverseBetween2(ListNode head, int m, int n) {
        // base case
        if (m == 1) {
            return reverseN(head, n);
        }
        // 前进到反转的起点触发 base case
        head.next = reverseBetween2(head.next, m - 1, n - 1);
        return head;
    }

    /**
     * 反转链表的前N个节点
     */
    static ListNode next = null;

    static ListNode reverseN(ListNode head, int n) {
        if (n == 1) {
            next = head.next;
            return head;
        }

        ListNode last = reverseN(head.next, n - 1);

        head.next.next = head;
        head.next = next;

        return last;
    }


    public static void main(String[] args) {

        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = null;

        ListNode node = reverseBetween3(node1, 3, 5);
    }

    /**
     * 头插法
     *
     * @param head
     * @param left
     * @param right
     * @return
     */
    public static ListNode reverseBetween3(ListNode head, int left, int right) {
        //定义虚拟结点 用于返回链表
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;

        //定义前驱结点
        ListNode pre = dummyNode;
        //1 、找到pre指针 pre.next 指向待反转部分的第一个结点
        for (int i = 0; i < left - 1; i++) {
            pre = pre.next;
        }
        //2、定义cur结点 指向pre的下一个指针
        ListNode cur = pre.next;
        ListNode next;

        for (int i = 0; i < right - left; i++) {
            next = cur.next;
            cur.next = next.next;
            next.next = pre.next;
            pre.next = next;
        }

        return dummyNode.next;
    }
}
