package list;

/**
 * https://leetcode.cn/problems/reverse-linked-list-ii/
 * 92
 *
 * @description：反转链表的一部分
 * @author: zhangxianglong
 * @date: 2022/5/12
 */
public class ReverseBetweenList {

    static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }


    /**
     * 反转指定位置的链表
     *
     * @param head
     * @return
     */
    public static ListNode reverseBetween(ListNode head, int m, int n) {
        //1、设置虚拟头节点
        ListNode dummyNode = new ListNode(-1);

        //2、虚拟头节点的next指向head
        dummyNode.next = head;

        //3、pre 指向m位置节点的前一个节点 pre 是中间链表的起始节点
        ListNode pre = dummyNode;

        for (int i = 0; i < m - 1; i++) {
            pre = pre.next;
        }

        ListNode cur = pre.next;
        ListNode currNext;

        for (int i = 0; i < n - m; i++) {
            currNext = cur.next;
            cur.next = currNext.next;
            currNext.next = pre.next;
            pre.next = currNext;
        }

        return dummyNode;
    }

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

        ListNode node = reverseBetween2(node1, 3, 5);
    }
}
