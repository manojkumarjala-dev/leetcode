class Solution {
    public int orangesRotting(int[][] grid) {

        int[][] visited = new int[grid.length][grid[0].length];

        Queue<int[]> q = new LinkedList<>();
        int good = 0;
        
        for(int i = 0;i<grid.length;i++){
            for(int j = 0;j<grid[0].length;j++){
                if(grid[i][j]==2){
                    q.offer(new int[]{i,j});
                }
                else if(grid[i][j]==1) good++;
            }
        }
        int t = 0;

        while(q.size()>0){
            int size = q.size();
            //System.out.println(good+" at step");
            if(good==0) return t;
            while(size>0){
                int[] pos = q.poll();
                int[][] directions = {{0,1},{1,0},{-1,0},{0,-1}};

                for(int[] dir : directions){
                    int r = pos[0]+dir[0];
                    int c = pos[1]+dir[1];

                    if(r>=0 && c>=0 && r< grid.length && c<grid[0].length && grid[r][c]==1){
                        //System.out.println("Reduced at "+r+", "+c);
                        good--;
                        grid[r][c]=2;
                        q.offer(new int[]{r,c});
                    }

                }
                size--;
            }
            t++;
            
        }


        if(good>0) return -1;
        else return t;
    }
}