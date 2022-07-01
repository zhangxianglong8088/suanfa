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
        ListNode node2 = new ListNode(0);
        ListNode node3 = new ListNode(0);

        node1.next = node2;
        node2.next = node3;

        isPalindrome5(node1);

    }

    public static boolean isPalindrome1(ListNode head) {

        //找到中间结点
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode cur = slow;
        ListNode pre = null;

        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }

        while (pre != null) {
            if (head.val != pre.val) {
                return false;
            }
            pre = pre.next;
            head = head.next;
        }
        return true;
    }

    public static boolean isPalindrome5(ListNode head) {

        //快慢指针找到链表的中间结点
        ListNode fast = head;
        ListNode slow = head;
        if (fast.next == null) {
            return true;
        }

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        //反转slow链表
        ListNode halfRes = reverse(slow);
        while (halfRes != null) {
            if (halfRes.val != head.val) {
                return false;
            } else {
                head = head.next;
                halfRes = halfRes.next;
            }
        }
        return true;

    }
}
