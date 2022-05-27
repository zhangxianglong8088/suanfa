package list;

/**
 * @description：24. 两两交换链表中的节点
 * https://leetcode.cn/problems/swap-nodes-in-pairs/
 * @author: zhangxianglong
 * @date: 2022/5/17
 */
public class SwapPairs {

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
     * 递归解
     *
     * @param head
     * @return
     */
    public static ListNode swapPairs(ListNode head) {
        //递归终止条件
        if (head == null || head.next == null) {
            return head;
        }

        ListNode subReverseResult = swapPairs(head.next.next);

        ListNode subHead = head.next;
        head.next.next = head;
        head.next = subReverseResult;

        return subHead;
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

        ListNode head = swapPairs(node1);

    }
}
