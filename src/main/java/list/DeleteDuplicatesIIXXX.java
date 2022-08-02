package list;

/**
 * 83. 删除排序链表中的重复元素(1,2,2,3,3,4,5,5,6-->1,4,6)
 *
 * @description：https://leetcode.cn/problems/remove-duplicates-from-sorted-list/
 * @author: zhangxianglong
 * @date: 2022/5/17
 */
public class DeleteDuplicatesIIXXX {

    public static ListNode deleteDuplicates(ListNode head) {
        //空链表
        if (head == null) {
            return null;
        }
        ListNode res = new ListNode(0);
        //在链表前加一个表头
        res.next = head;
        ListNode cur = res;
        while (cur.next != null && cur.next.next != null) {
            //遇到相邻两个节点值相同
            if (cur.next.val == cur.next.next.val) {
                int temp = cur.next.val;
                //将所有相同的都跳过
                while (cur.next != null && cur.next.val == temp) {
                    cur.next = cur.next.next;
                }
            } else {
                cur = cur.next;
            }
        }
        //返回时去掉表头
        return res.next;
    }


    public static void main(String[] args) {

        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(1);
        ListNode node3 = new ListNode(2);
        ListNode node4 = new ListNode(2);
        ListNode node5 = new ListNode(4);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = null;

        ListNode res = deleteDuplicates3(node1);
    }

    public static ListNode deleteDuplicates3(ListNode head) {
        ListNode pre = new ListNode(-1);
        ListNode cur = pre;
        pre.next = head;

        while (cur.next != null) {

            if (cur.next.next != null && cur.next.val == cur.next.next.val) {

                int tmp = cur.next.val;

                while (cur.next != null && cur.next.val == tmp) {
                    cur.next = cur.next.next;
                }
            } else {
                cur = cur.next;
            }
        }
        return pre.next;
    }
}
