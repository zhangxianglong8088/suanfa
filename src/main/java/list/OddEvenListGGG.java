package list;


/**
 * @description：https://leetcode.cn/problems/odd-even-linked-list/ 328. 奇偶链表
 * @author: zhangxianglong
 * @date: 2022/6/12
 */
public class OddEvenListGGG {

    /**
     * 第一个思路 借助 n
     *
     * @param head
     * @return
     */
    public static ListNode oddEvenList1(ListNode head) {
        ListNode oddPre = new ListNode(-1);
        ListNode oddCur = oddPre;

        ListNode evenPre = new ListNode(-1);
        ListNode evenCur = evenPre;


        int n = 1;


        while (head != null) {

            if (n % 2 == 1) {
                oddCur.next = head;
                head = head.next;
                oddCur = oddCur.next;
            } else {
                evenCur.next = head;
                head = head.next;
                evenCur = evenCur.next;
                //这里判断一下 如果偶数位置为倒数第二个，则下一个结点致空
                if (head != null && head.next == null) {
                    evenCur.next = null;
                }
            }

            n++;
        }
        oddCur.next = evenPre.next;
        return oddPre.next;


    }

    /**
     * 第二个思路
     *
     * @param head
     * @return
     */
    public static ListNode oddEvenList2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        // oHead 为奇链表头结点，oTail 为奇链表尾节点
        ListNode oHead = head;
        ListNode oTail = head;

        // eHead 为偶链表头结点 eTail 为偶链表尾节点
        ListNode eHead = head.next;
        ListNode eTail = head.next;

        while (oTail.next != null && eTail.next != null) {
            oTail.next = eTail.next;
            oTail = oTail.next;

            eTail.next = oTail.next;
            eTail = eTail.next;
        }

        oTail.next = eHead;

        return oHead;
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


        ListNode res = oddEvenList1(node1);
    }
}
