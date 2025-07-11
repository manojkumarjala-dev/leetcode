class Solution {
    public void solve(char[][] board) {
        int[][] visited = new int[board.length][board[0].length];
        char[][] ans = new char[board.length][board[0].length];

        for(char[] c: ans) Arrays.fill(c,'X'); 

        Queue<int[]> q = new LinkedList<>();

        for(int i = 0;i<board.length;i++){
            for(int j = 0;j<board[0].length;j++){
                if((i==0 || j==0 || i==board.length-1 || j==board[0].length-1) && board[i][j]=='O' && visited[i][j]==0){
                    ans[i][j] = 'O';
                    visited[i][j] = 1;
                    q.offer(new int[]{i,j});
 
                    while(q.size()>0){
                        int size = q.size();
                        while(size-->0){
                            int[] pos = q.poll();

                            int[][] directions = {{0,1},{1,0},{-1,0},{0,-1}};

                            for(int[] dir : directions){
                                int r = pos[0]+dir[0];
                                int c = pos[1] + dir[1];

                                if(r>=0 && c>=0 && r<board.length && c<board[0].length && board[r][c] == 'O' && visited[r][c]==0){
                                    visited[r][c] = 1;
                                    ans[r][c] = 'O';
                                    q.offer(new int[]{r,c});
                                }
                            }
                        }
                    }
                }
            }
        }

        for(int i = 0;i<board.length;i++){
            for(int j = 0;j<board[0].length;j++){
                board[i][j] = ans[i][j];
            }
        }
    }
}