class Solution {
    private int n;
    private int m;
    private int[][] visited;
    private int[][] matrix;
    public boolean isValid(int row, int col){
        return (row>=0 && row<n && col>=0 && col<m);
    }
    public int bfs(int row, int col){
        int[][] dir = new int[][]{{1,0},{-1,0},{0,1},{0,-1}};
        Queue<int[]> q = new LinkedList<>();
        int area = 1;
        q.offer(new int[]{row, col});

        while(q.size()>0){
            int size = q.size();
            while(size-->0){
                int[] cur_pos = q.poll();
                for(int[] d: dir){
                    int new_row = cur_pos[0]+d[0];
                    int new_col = cur_pos[1]+d[1];
                    if(isValid(new_row, new_col) && visited[new_row][new_col]==0 && matrix[new_row][new_col]==1){
                        visited[new_row][new_col]=1;
                        area++;
                        q.offer(new int[]{new_row,new_col});
                    }
                    
                }
            }
        }

        return area;
        
    }
    public int maxAreaOfIsland(int[][] grid) {
        n = grid.length;
        m = grid[0].length;
        visited = new int[n][m];
        matrix = grid;
        int ans = 0;

        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                if(grid[i][j]==1 && visited[i][j]==0){
                    visited[i][j] = 1;
                    ans = Math.max(ans,bfs(i,j));
                }
            }
        }

        return ans;
        
    }
}