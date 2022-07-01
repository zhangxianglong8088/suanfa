package list;

/**
 * @description Offer 22. 链表中倒数第k个节点
 * https://leetcode.cn/problems/lian-biao-zhong-dao-shu-di-kge-jie-dian-lcof/
 * @author: zhangxianglong
 * @date: 2022/5/17
 */
public class GetKthFromEnd {

    public static ListNode getKthFromEnd(ListNode head, int k) {

        //获取链表的长度
        ListNode cur = head;
        int l = 0;
        while (cur != null) {
            l++;
            cur = cur.next;
        }
        //如果k大于等于l 则返回head
        if (l <= k) {
            return head;
        }

        ListNode newCur = head;

        for (int i = 0; i < l - k - 1; i++) {
            newCur = newCur.next;
        }
        return newCur.next;
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
