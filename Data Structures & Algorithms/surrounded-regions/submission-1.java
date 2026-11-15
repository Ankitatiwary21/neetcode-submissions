

class Solution {
    public void solve(char[][] board) {

        int n = board.length;
        if (n == 0) return;

        int m = board[0].length;

        Queue<int[]> q = new LinkedList<>();

        // Step 1: Add boundary 'O' cells to the queue

        for (int i = 0; i < n; i++) {

            if (board[i][0] == 'O') {
                q.offer(new int[]{i, 0});
                board[i][0] = '#';
            }

            if (board[i][m - 1] == 'O') {
                q.offer(new int[]{i, m - 1});
                board[i][m - 1] = '#';
            }
        }

        for (int j = 0; j < m; j++) {

            if (board[0][j] == 'O') {
                q.offer(new int[]{0, j});
                board[0][j] = '#';
            }

            if (board[n - 1][j] == 'O') {
                q.offer(new int[]{n - 1, j});
                board[n - 1][j] = '#';
            }
        }

        // Four directions: Up, Down, Left, Right
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        // Step 2: BFS traversal
        while (!q.isEmpty()) {

            int[] curr = q.poll();

            int row = curr[0];
            int col = curr[1];

            for (int k = 0; k < 4; k++) {

                int newRow = row + dx[k];
                int newCol = col + dy[k];

                if (newRow >= 0 && newRow < n &&
                    newCol >= 0 && newCol < m &&
                    board[newRow][newCol] == 'O') {

                    board[newRow][newCol] = '#';

                    q.offer(new int[]{newRow, newCol});
                }
            }
        }

        // Step 3: Replace remaining O with X
        // Restore boundary-connected O from # to O

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {

                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
                else if (board[i][j] == '#') {
                    board[i][j] = 'O';
                }
            }
        }
    }
}
