package list;

/**
 * 83. 删除排序链表中的重复元素(1,2,2,3,3,4,5,5,6-->1,4,6)
 *
 * @description： https://www.nowcoder.com/practice/71cef9f8b5564579bf7ed93fbe0b2024?tpId=117&tqId=37729&rp=1&ru=/exam/oj&qru=/exam/oj&sourceUrl=%2Fexam%2Foj%3Fpage%3D1%26pageSize%3D50%26search%3D%25E9%2587%258D%25E5%25A4%258D%26tab%3D%25E7%25AE%2597%25E6%25B3%2595%25E7%25AF%2587%26topicId%3D117&difficulty=undefined&judgeStatus=undefined&tags=&title=%E9%87%8D%E5%A4%8D
 * @author: zhangxianglong
 * @date: 2022/5/17
 */
public class DeleteDuplicatesIIGGG {

    /**
     * @param head
     * @return
     */
    public static ListNode deleteDuplicates5(ListNode head) {

        ListNode pre = new ListNode(-1);
        pre.next = head;
        ListNode cur = pre;
        int tmp;

        while (head != null && head.next != null) {
            if (cur.next.val == head.next.val) {
                tmp = head.val;
                while (head != null && head.val == tmp) {
                    cur.next = head.next;
                    head = head.next;
                }

            } else {
                cur = cur.next;
                head = head.next;
            }

        }
        return pre.next;
    }

    public static void main(String[] args) {

        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(2);


        node1.next = node2;
        node2.next = node3;
        node3.next = null;


        ListNode res = deleteDuplicates5(node1);
    }

}
