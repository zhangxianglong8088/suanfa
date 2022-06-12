package list;

/**
 * https://leetcode.cn/problems/he-bing-liang-ge-pai-xu-de-lian-biao-lcof/
 *
 * @description：输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。
 * @author: zhangxianglong
 * @date: 2022/5/17
 */
public class MergeTwoLists {

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        ListNode pre = new ListNode(-1);
        ListNode cur = pre;

        while (l1 != null || l2 != null) {

            if (l1 != null && l2 != null) {
                if (l1.val <= l2.val) {
                    cur.next = l1;
                    l1 = l1.next;
                    cur = cur.next;
                } else {
                    cur.next = l2;
                    l2 = l2.next;
                    cur = cur.next;
                }
            }

            if (l1 == null && l2 != null) {
                cur.next = l2;
                l2 = null;
            }

            if (l2 == null && l1 != null) {
                cur.next = l1;
                l1 = null;
            }
        }

        return pre.next;
    }

    public static void main(String[] args) {

        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(4);

        ListNode node4 = new ListNode(2);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);

        node1.next = node2;
        node2.next = node3;
        node3.next = null;

        node4.next = node5;
        node5.next = node6;
        node6.next = null;

        mergeTwoLists1(node1, node4);

    }

    /**
     * while条件
     *
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        ListNode pre = new ListNode(-1);
        ListNode cur = pre;

        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }

        if (l1 == null) {
            cur.next = l2;
        }
        if (l2 == null) {
            cur.next = l1;
        }
        return pre.next;
    }
}
