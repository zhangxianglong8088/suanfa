package list;

/**
 * https://leetcode.cn/problems/palindrome-linked-list/
 * 给你一个单链表的头节点 head ，请你判断该链表是否为回文链表。如果是，返回 true ；否则，返回 false 。
 *
 * @description：234. 回文链表
 * @author: zhangxianglong
 * @date: 2022/5/17
 */
public class IsPalindrome {

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

    public static boolean isPalindrome(ListNode head) {

        ListNode fast = head;
        ListNode slow = head;
        //快慢指针 找到链表的中间结点 half
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode pre = null;
        ListNode falf = slow;

        //反转后半部分链表
        while (falf != null) {

            ListNode tmp = falf.next;
            falf.next = pre;

            pre = falf;
            falf = tmp;
        }

        //同时遍历原始链表和反转之后的链表 比较是否相等 如果不相等则说明不是回文
        while (pre != null && head != null) {
            if (pre.val != head.val) {
                return Boolean.FALSE;
            }
            pre = pre.next;
            head = head.next;
        }

        return Boolean.TRUE;

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

    public static void main(String[] args) {

        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);

        node1.next = node2;
        node2.next = null;

        isPalindrome(node1);

    }
}
