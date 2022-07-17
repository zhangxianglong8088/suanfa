package list;

/**
 * https://leetcode.cn/problems/he-bing-liang-ge-pai-xu-de-lian-biao-lcof/
 *
 * @description：输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。
 * @author: zhangxianglong
 * @date: 2022/5/17
 */
public class MergeTwoListsGGG {
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


    /**
     * 这个写法需要建临时结点  不太建议
     *
     * @param head1
     * @param head2
     * @return
     */
    public static ListNode merger6(ListNode head1, ListNode head2) {

        ListNode pre = new ListNode(-1);
        ListNode cur = pre;

        ListNode p1 = head1;
        ListNode p2 = head2;


        while (p1 != null || p2 != null) {

            if (p1 != null && p2 != null) {
                if (p1.val <= p2.val) {
                    ListNode tmp = new ListNode(p1.val);
                    cur.next = tmp;
                    cur = cur.next;
                    p1 = p1.next;
                } else {
                    ListNode tmp = new ListNode(p2.val);
                    cur.next = tmp;
                    cur = cur.next;
                    p2 = p2.next;
                }
            } else if (p1 != null) {
                cur.next = p1;
                break;
            } else {
                cur.next = p2;
                break;
            }
        }
        return pre.next;

    }


    public static void main(String[] args) {

        ListNode node1 = new ListNode(-9);
        ListNode node2 = new ListNode(3);

        ListNode node4 = new ListNode(5);
        ListNode node5 = new ListNode(7);

        node1.next = node2;

        node4.next = node5;


        ListNode res = merger6(node1, node4);

    }


}
