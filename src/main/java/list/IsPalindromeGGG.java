package list;

/**
 * https://leetcode.cn/problems/palindrome-linked-list/
 * 给你一个单链表的头节点 head ，请你判断该链表是否为回文链表。如果是，返回 true ；否则，返回 false 。
 *
 * @description：234. 回文链表
 * @author: zhangxianglong
 * @date: 2022/5/17
 */
public class IsPalindromeGGG {


    public static void main(String[] args) {

        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(2);
        ListNode node4 = new ListNode(1);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        isPalindrome(node1);

    }

    public static boolean isPalindrome(ListNode head) {
        //找到链表的中间结点 断开
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }


        //反转链表的后半部分
        ListNode half = reverse(slow);
        ListNode pre = head;

        while (half != null) {
            if (half.val != pre.val) {
                return false;
            }
            pre = pre.next;
            half = half.next;

        }
        return true;
    }

    /**
     * 翻转链表
     *
     * @param head
     * @return
     */
    static ListNode reverse(ListNode head) {

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
}
