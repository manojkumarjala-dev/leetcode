class Solution {

    public int numIslands(char[][] grid) {

        int[][] visited = new int[grid.length][grid[0].length];      
        int count = 0;
        Queue<int[]> q = new LinkedList<>();

        for(int i =0;i<grid.length;i++){
            for(int j = 0;j<grid[0].length;j++){
                if(visited[i][j]==0 && grid[i][j]=='1'){
                    count++;
                    visited[i][j] = 1;
                    q.offer(new int[]{i,j});
                    while(q.size()>0){
                        int size = q.size();
                        while(size-->0){
                            int[] pos = q.poll();
                            int[][] directions = {{1,0},{0,1},{-1,0},{0,-1}};

                            for(int[] dir: directions){
                                int new_row = dir[0] + pos[0];
                                int new_col = dir[1] + pos[1];

                                if(new_row>=0 && new_col>=0 && new_row<grid.length && new_col<grid[0].length){
                                    if(visited[new_row][new_col]==0 && grid[new_row][new_col]=='1'){
                                        visited[new_row][new_col] = 1;
                                        q.offer(new int[]{new_row, new_col});
                                    }
                                }
                            }

                        }
                    }
                }

            }
        }  

        return count;
    }
}