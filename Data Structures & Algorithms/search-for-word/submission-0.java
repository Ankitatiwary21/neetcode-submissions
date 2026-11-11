
class Solution {
    public boolean exists(char[][] board, int i, int j, String word, int idx) {
        if (idx == word.length()) {
            return true;
        }

        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length
                || board[i][j] != word.charAt(idx)) {
            return false;
        }

        char ch = board[i][j];
        board[i][j] = '*';

        boolean res = exists(board, i + 1, j, word, idx + 1) ||
                      exists(board, i - 1, j, word, idx + 1) ||
                      exists(board, i, j + 1, word, idx + 1) ||
                      exists(board, i, j - 1, word, idx + 1);

        board[i][j] = ch;

        return res;
    }

    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (exists(board, i, j, word, 0)) {
                    return true;
                }
            }
        }

        return false;
    }
}
