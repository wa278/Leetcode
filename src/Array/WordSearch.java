package Array;
//回溯法一般都传进index用来判断是否查找到。
public class WordSearch {
    public boolean exist(char[][] board, String word) {
        char[] str = word.toCharArray();
        int row = board.length;
        int col = board[0].length;
        boolean[][] flag = new boolean[row][col];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (backtracing(board, flag, str, 0, i, j))
                    return true;
            }
        }
        return false;
    }

    public boolean backtracing(char[][] board, boolean[][] flag, char[] str, int index, int i, int j) {
        if (index == str.length) {
            return true;
        }
        if (i < 0 || i > board.length - 1 || j < 0 || j > board[0].length - 1 || board[i][j] != str[index] || flag[i][j])
            return false;
        flag[i][j] = true;
        if (backtracing(board, flag, str, index + 1, i - 1, j) || backtracing(board, flag, str, index + 1, i + 1, j) || backtracing(board, flag, str, index + 1, i, j - 1) || backtracing(board, flag, str, index + 1, i, j + 1)) {
            return true;
        }
        flag[i][j] = false;
        return false;
    }

    public static void main(String[] args) {
        char[][] board = {{'B'}};
        String word = "A";
        WordSearch x = new WordSearch();
        System.out.print(x.exist(board, word));
    }
}
