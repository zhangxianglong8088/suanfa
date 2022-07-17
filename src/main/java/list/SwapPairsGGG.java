package list;

/**
 * @description：24. 两两交换链表中的节点
 * https://leetcode.cn/problems/swap-nodes-in-pairs/
 * @author: zhangxianglong
 * @date: 2022/5/17
 */
public class SwapPairsGGG {

    /**
     * 递归解
     *
     * @param head
     * @return
     */
    public static ListNode swapPairs(ListNode head) {
        //递归终止条件 ***这里重点理解

        if (head == null || head.next == null) {
            return head;
        }

        ListNode reversHead = swapPairs(head.next.next);

        ListNode subHead = head.next;
        head.next.next = head;
        head.next = reversHead;

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
