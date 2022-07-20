package back;

/**
 * @description：79. 单词搜索
 * https://leetcode.cn/problems/word-search/
 * @author: zhangxianglong
 * @date: 2022/7/20
 */
public class Exist {
    static boolean find;

    public static boolean exist(char[][] board, String word) {
        //数组长度
        int m = board.length;
        //数组的宽度
        int n = board[0].length;

        boolean[][] visited = new boolean[m][n];
        //遍历二位数组的每一个字符
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                backtracing(i, j, board, word, visited, 0);
            }
        }
        return find;
    }

    /**
     * i,j,board：棋盘格及当前元素的坐标
     * word: 要搜索的目标单词
     * visited：记录当前格子是否已被访问过
     * pos: 记录目标单词的字符索引，只有棋盘格字符和pos指向的字符一致时，才有机会继续搜索接下来的字符；如果pos已经过了目标单词的尾部了，那么便说明找到目标单词了
     */

    static void backtracing(int i, int j, char[][] board, String word, boolean[][] visited, int pos) {
        //递归终止条件
        // 超出边界、已经访问过、已找到目标单词、棋盘格中当前字符已经和目标字符不一致了

        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || visited[i][j] || find || board[i][j] != word.charAt(pos)) {
            return;
        }

        //找到了
        if (pos == word.length() - 1) {
            find = true;
            return;
        }


        // 修改当前节点状态 表示这个位置已经访问过了
        visited[i][j] = true;

        backtracing(i + 1, j, board, word, visited, pos + 1);
        backtracing(i - 1, j, board, word, visited, pos + 1);
        backtracing(i, j + 1, board, word, visited, pos + 1);
        backtracing(i, j - 1, board, word, visited, pos + 1);

        //回溯 撤销
        visited[i][j] = false;

    }

    public static void main(String[] args) {

        char[][] board = new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        String word = "ABCCED";

        boolean res = exist(board, word);

        System.out.println(res);
    }
}
