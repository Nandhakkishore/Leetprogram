class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        boolean[] cols = new boolean[n];
        boolean[] diag1 = new boolean[2 * n];
        boolean[] diag2 = new boolean[2 * n];
        solve(0, board, res, cols, diag1, diag2, n);
        return res;
    }
    
    private void solve(int row, char[][] board, List<List<String>> res, boolean[] cols, boolean[] diag1, boolean[] diag2, int n) {
        if (row == n) {
            List<String> list = new ArrayList<>();
            for (char[] r : board) {
                list.add(new String(r));
            }
            res.add(list);
            return;
        }
        
        for (int col = 0; col < n; col++) {
            int d1 = row + col;
            int d2 = row - col + n;
            
            if (cols[col] || diag1[d1] || diag2[d2]) {
                continue;
            }
            
            board[row][col] = 'Q';
            cols[col] = true;
            diag1[d1] = true;
            diag2[d2] = true;
            
            solve(row + 1, board, res, cols, diag1, diag2, n);
            
            board[row][col] = '.';
            cols[col] = false;
            diag1[d1] = false;
            diag2[d2] = false;
        }
    }
}
