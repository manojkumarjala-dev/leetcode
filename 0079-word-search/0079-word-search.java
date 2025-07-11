class Solution {
    boolean helper(char[][] board, String word, int idx, int[][] visited, int row, int col){
        if(idx == word.length()) return true;

        int[][] directions = { {0, 1}, {1, 0}, {-1, 0}, {0, -1} };

        for(int[] dir: directions){
            int new_row = row+dir[0];
            int new_col = col+dir[1];

            if(new_row>=0 && new_row<board.length && new_col>=0 && new_col<board[0].length && visited[new_row][new_col]==0 && word.charAt(idx) == board[new_row][new_col]){
                visited[new_row][new_col] = 1;
                if(helper(board, word, idx+1, visited, new_row, new_col)) return true;
                visited[new_row][new_col] = 0;
            }
        }

        return false;
    }
    public boolean exist(char[][] board, String word) {
        int[][] visited = new int[board.length][board[0].length];
        for(int i = 0;i<board.length;i++){
            for(int j = 0;j<board[0].length;j++){
                if(board[i][j]==word.charAt(0)){
                    visited[i][j] = 1;
                    if(helper(board, word, 1, visited, i , j)) return true;
                    visited[i][j] = 0;
                }
            }
        }
        return false;
    }
}