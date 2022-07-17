package list;

/**
 * @description：反转链表的前N个节点
 * @author: zhangxianglong
 * @date: 2022/5/21
 */


public class ReversePreNGGG {

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
        ListNode node7 = new ListNode(7);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        node7.next = null;

        ListNode head = reverseN14(node1, 3);


    }

    static ListNode reverseN1(ListNode head, int n) {

        //找到链表的第n个结点
        ListNode cur = head;
        for (int i = 1; i < n; i++) {
            cur = cur.next;
        }
        //保存N+1 个结点
        ListNode half = cur.next;

        //n.netx = null
        cur.next = null;

        //反转前n个结点

        ListNode pre = null;
        ListNode preCur = head;

        while (preCur != null) {
            ListNode next = preCur.next;
            preCur.next = pre;
            pre = preCur;
            preCur = next;
        }
        //拼接反转后的n个结点和n+1个结点
        ListNode newPre = pre;

        while (pre.next != null) {
            pre = pre.next;
        }
        pre.next = half;

        return newPre;
    }

    static ListNode reverseN14(ListNode head, int n) {

        ListNode pre = new ListNode(-1);
        pre.next = head;
        ListNode cur = head;
        ListNode next;


        for (int i = 0; i < n - 1; i++) {
            next = cur.next;
            cur.next = next.next;
            next.next = pre.next;
            pre.next = next;
        }

        return pre.next;
    }

}
