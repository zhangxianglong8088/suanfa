package back;

import java.util.ArrayList;
import java.util.List;

/**
 * 51. N 皇后
 * https://www.bilibili.com/video/BV1bb4y1B74L?vd_source=33330ceec8563c17ba9362183caf534a
 *
 * @description： https://leetcode.cn/problems/n-queens/
 * @author: zhangxianglong
 * @date: 2022/7/23
 */
public class SolveNQueens {

    static List<List<String>> res = new ArrayList<>();

    public static void main(String[] args) {
        List<List<String>> res = solveNQueens(4);
        System.out.println(res);
    }


    public static List<List<String>> solveNQueens(int n) {

        char[][] board = new char[n][n];

        //棋盘初始化
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        backtracing(n, 0, board);
        return res;

    }

    static void backtracing(int n, int row, char[][] board) {
        //递归终止条件
        if (row == n) {
            res.add(convert2board(board));
            return;
        }
        for (int col = 0; col < n; col++) {

            if (isValid(row, col, n, board)) {
                board[row][col] = 'Q';
                backtracing(n, row + 1, board);
                board[row][col] = '.';
            }
        }
    }


    static List<String> convert2board(char[][] board) {

        List<String> res = new ArrayList<>();

        for (int i = 0; i < board.length; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < board.length; j++) {
                sb.append(board[i][j]);
            }
            res.add(sb.toString());
        }
        return res;
    }


    static boolean isValid(int row, int col, int n, char[][] board) {

        //判断列的方向
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }

        //判断左上角是否能攻击到
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        //判断右上角是否能攻击到
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        return true;

    }

}
