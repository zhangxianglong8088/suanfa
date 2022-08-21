package back;

/**
 * https://leetcode.cn/problems/sudoku-solver/
 * https://www.bilibili.com/video/BV14u411q7fJ?spm_id_from=333.999.0.0
 *
 * @description：37. 解数独
 * @author: zhangxianglong
 * @date: 2022/7/23
 */
public class SolveSudokuGGG {

    /**
     * @param board
     */
    public void solveSudoku(char[][] board) {

        sudoHelper(board);

    }

    boolean sudoHelper(char[][] board) {

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                //如果当前位置的数字是
                if (board[i][j] != '.') {
                    continue;
                }

                for (char k = '1'; k <= '9'; k++) {
                    //判断当前 i、j这个位置如果数字为k是否满足数独
                    if (issudo(board, i, j, k)) {
                        //如果满足 就填入k
                        board[i][j] = k;
                        if (sudoHelper(board)) {
                            return true;
                        }
                        board[i][j] = '.';
                    }
                }

                return false;
            }
        }

        return true;
    }

    boolean issudo(char[][] board, int row, int col, char val) {

        //判断同行方向是否满足
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == val) {
                return false;
            }
        }

        //判断同列方向是否满足
        for (int j = 0; j < 9; j++) {
            if (board[j][col] == val) {
                return false;
            }
        }

        //判断九宫格方向是否满足
        int startRow = (row / 3) * 3;
        int startCol = (col / 3) * 3;

        for (int i = startRow; i < startRow + 3; i++) {
            for (int j = startCol; j < startCol + 3; j++) {
                if (board[i][j] == val) {
                    return false;
                }
            }
        }

        return true;
    }
}
