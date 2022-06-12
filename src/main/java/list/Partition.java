package list;

/**
 * 给你一个链表的头节点 head 和一个特定值 x ，请你对链表进行分隔，使得所有 小于 x 的节点都出现在 大于或等于 x 的节点之前。
 * <p>
 * 你应当 保留 两个分区中每个节点的初始相对位置。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/partition-list
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @description：86. 分隔链表
 * @author: zhangxianglong
 * @date: 2022/5/18
 */
public class Partition {

    static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    /**
     * @param head
     * @param x
     * @return
     */
    public static ListNode partition(ListNode head, int x) {

        ListNode samll = new ListNode(-1);
        ListNode preSamall = samll;

        ListNode larager = new ListNode(-2);
        ListNode preLarager = larager;

        ListNode curr = head;
        while (curr != null) {
            if (curr.val < x) {
                samll.next = curr;
                samll = samll.next;
            } else {
                larager.next = curr;
                larager = larager.next;
            }
            curr = curr.next;
        }
        larager.next = null;
        samll.next = preLarager.next;
        return preSamall.next;
    }

    public static void main(String[] args) {

        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(4);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(2);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(2);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = null;

        partition2(node1, 3);

    }

    /**
     * 思路：先把原来的链表拆分为两个一大一小的链表 然后再拼接起来
     * @param head
     * @param x
     * @return
     */
    public static ListNode partition2(ListNode head, int x) {

        ListNode small = new ListNode(-1);
        ListNode smallPre = small;

        ListNode larger = new ListNode(-1);
        ListNode largerPre = larger;

        ListNode cur = head;

        while (cur != null) {
            if (cur.val < x) {
                small.next = new ListNode(cur.val);
                cur = cur.next;
                small = small.next;

            } else {
                larger.next = new ListNode(cur.val);
                cur = cur.next;
                larger = larger.next;

            }
        }
        small.next = largerPre.next;

        return smallPre.next;

    }
}
