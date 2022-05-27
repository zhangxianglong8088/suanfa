package list;

/**
 * @description Offer 22. 链表中倒数第k个节点
 * https://leetcode.cn/problems/lian-biao-zhong-dao-shu-di-kge-jie-dian-lcof/
 * @author: zhangxianglong
 * @date: 2022/5/17
 */
public class GetKthFromEnd {

    static class ListNode {
        int value;
        ListNode next;

        public ListNode(int value) {
            this.value = value;
        }
    }


    public static ListNode getKthFromEnd(ListNode head, int k) {
        ListNode countCur = head;
        int total = 0;

        while (countCur != null) {
            total++;
            countCur = countCur.next;
        }

        ListNode cur = head;


        for (int i = 0; i <= total - k - 1; i++) {
            cur = cur.next;
        }
        return cur;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = null;


        getKthFromEnd(node1, 0);

    }
}
