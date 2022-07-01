package list;


/**
 * @description：160. 相交链表
 * https://leetcode.cn/problems/intersection-of-two-linked-lists/
 * @author: zhangxianglong
 * @date: 2022/5/17
 */
public class GetIntersectionNode {

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

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode pA = headA;
        ListNode pB = headB;

        while (pA != pB) {
            if (pA == null) {
                pA = headB;
            } else {
                pA = pA.next;
            }

            if (pB == null) {
                pB = headA;
            } else {
                pB = pB.next;
            }
        }
        return pA;
    }

    /**
     * 第二个思路
     *
     * @param headA
     * @param headB
     * @return
     */
    public static ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        if (headB == headA) {
            return headB;
        }

        ListNode pA = headA;
        ListNode pB = headB;

        while (true) {
            if (pA != null) {
                pA = pA.next;
            } else {
                pA = headB;
            }
            if (pB != null) {
                pB = pB.next;
            } else {
                pB = headA;
            }

            if (pA == pB) {
                return pA;
            }
        }
    }


    public static void main(String[] args) {

        ListNode aHead = new ListNode(1);
        ListNode A1 = new ListNode(3);
        ListNode A2 = new ListNode(4);
        ListNode A3 = new ListNode(9);

        aHead.next = A1;
        A1.next = A2;
        A2.next = A3;
        A3.next = null;


        ListNode bHead = new ListNode(2);
        ListNode B1 = new ListNode(5);
        bHead.next = B1;
        B1.next = A2;
        getIntersectionNode(aHead, bHead);
    }
}
