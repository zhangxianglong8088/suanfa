package list;

/**
 * @description：删除数组中重复元素
 * @author: zhangxianglong
 * @date: 2022/5/18
 */
public class DeleteDuplicates11 {

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
     * 删除链表中重复的数字 递归解法
     *
     * @param head
     * @return
     */
    public ListNode deleteDuplicates(ListNode head) {
        // 没有节点或者只有一个节点，必然没有重复元素
        if (head == null || head.next == null) return head;

        // 当前节点和下一个节点，值不同，则head的值是需要保留的，对head.next继续递归
        if (head.val != head.next.val) {
            head.next = deleteDuplicates(head.next);
            return head;
        } else {
            // 当前节点与下一个节点的值重复了，重复的值都不能要。
            // 一直往下找，找到不重复的节点。返回对不重复节点的递归结果
            ListNode notDup = head.next.next;
            while (notDup != null && notDup.val == head.val) {
                notDup = notDup.next;
            }
            return deleteDuplicates(notDup);
        }
    }


    public static void main(String[] args) {
    }
}
