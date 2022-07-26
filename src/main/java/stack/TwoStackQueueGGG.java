package stack;

import java.util.Stack;

/**
 * 两个栈实现一个队列
 *
 * @description： https://www.nowcoder.com/practice/54275ddae22f475981afa2244dd448c6?tpId=117&tqId=37774&rp=1&ru=/exam/oj&qru=/exam/oj&sourceUrl=%2Fexam%2Foj%3Fpage%3D1%26tab%3D%25E7%25AE%2597%25E6%25B3%2595%25E7%25AF%2587%26topicId%3D117&difficulty=undefined&judgeStatus=undefined&tags=&title=
 * @author: zhangxianglong
 * @date: 2022/7/23
 */
public class TwoStackQueueGGG {

    Stack<Integer> stack1 = new Stack<Integer>();

    Stack<Integer> stack2 = new Stack<Integer>();

    /**
     * push 数据的时候push到stack1中
     *
     * @param node
     */
    public void push(int node) {
        stack1.push(node);
    }

    /**
     * pop操作
     * 如果stack2 中有数据，则直接从stack2中弹出栈顶元素
     * 如果Stack2为空，先把stack1的数据全部移动到stack2中，然后从stack2中栈顶元素
     *
     * @return
     */
    public int pop() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }
}
