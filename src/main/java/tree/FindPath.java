package tree;

import common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * NC8 二叉树中和为某一值的路径(二)
 *
 * @description： https://www.nowcoder.com/practice/b736e784e3e34731af99065031301bca?tpId=117&tqId=37718&rp=1&ru=/exam/oj&qru=/exam/oj&sourceUrl=%2Fexam%2Foj%3Fpage%3D2%26tab%3D%25E7%25AE%2597%25E6%25B3%2595%25E7%25AF%2587%26topicId%3D117&difficulty=undefined&judgeStatus=undefined&tags=&title=
 * @author: zhangxianglong
 * @date: 2022/7/25
 */
public class FindPath {

    private ArrayList<ArrayList<Integer>> ret = new ArrayList<>();
    private LinkedList<Integer> path = new LinkedList<>();


    public ArrayList<ArrayList<Integer>> findPath(TreeNode root, int expectNumber) {
        dfs(root, expectNumber);
        return ret;
    }

    void dfs(TreeNode root, int number) {
        // 处理树为空
        if (root == null) {
            return;
        }
        // 路径更新
        path.add(root.val);
        // number更新
        number -= root.val;
        // 如果递归当前节点为叶子节点且该条路径的值已经达到了expectNumber，则更新ret
        if (root.left == null && root.right == null && number == 0) {
            ret.add(new ArrayList<>(path));
        }
        // 左右子树递归
        dfs(root.left, number);

        dfs(root.right, number);

        path.removeLast();
    }

}
