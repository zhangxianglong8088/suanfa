package tree;

import common.TreeNode;

import java.util.*;

/**
 * BM27 按之字形顺序打印二叉树
 *
 * @description：https://www.nowcoder.com/practice/91b69814117f4e8097390d107d2efbe0?tpId=295&tqId=23454&ru=/exam/oj&qru=/ta/format-top101/question-ranking&sourceUrl=%2Fexam%2Foj
 * @author: zhangxianglong
 * @date: 2022/5/26
 */
public class PrintZGGG {

    public static List<List<Integer>> printZ(TreeNode pRoot) {

        List<List<Integer>> res = new ArrayList<>();
        //如果是空，则直接返回空list
        if (pRoot == null) {
            return res;
        }

        //队列存储，进行层次遍历
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(pRoot);

        TreeNode p;
        boolean flag = true;
        while (!queue.isEmpty()) {
            //记录二叉树的某一行
            List<Integer> rows = new ArrayList<>();
            int n = queue.size();

            //奇数行反转，偶数行不反转
            flag = !flag;

            //因先进入的是根节点，故每层节点多少，队列大小就是多少
            for (int i = 0; i < n; i++) {
                p = queue.poll();
                rows.add(p.val);
                //若是左右孩子存在，则存入左右孩子作为下一个层次
                if (p.left != null) {
                    queue.offer(p.left);
                }
                if (p.right != null) {
                    queue.offer(p.right);
                }
            }
            //奇数行反转，偶数行不反转
            if (flag) {
                Collections.reverse(rows);
            }
            res.add(rows);
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode node0 = new TreeNode(0);
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        TreeNode node8 = new TreeNode(8);


        node3.left = node5;
        node3.right = node1;

        node5.left = node6;
        node5.right = node2;

        node2.left = node7;
        node2.right = node4;

        node1.left = node0;
        node1.right = node8;


        List<List<Integer>> levelOrder = printZ(node3);

    }


    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root==null){
            return new ArrayList<>();
        }
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        boolean flag= true;

        queue.add(root);

        while(!queue.isEmpty()){
            int n = queue.size();
            List<Integer> sub = new ArrayList<>();
            for(int i = 0 ;i<n;i++){
                TreeNode tmp = queue.poll();
                if(tmp.left!=null){
                    queue.add(tmp.left);
                }

                if(tmp.right!=null){
                    queue.add(tmp.right);
                }

                sub.add(tmp.val);

            }
            flag=!flag;
            if(flag){
                Collections.reverse(sub);
            }
            res.add(sub);
        }
        return res;

    }
}
