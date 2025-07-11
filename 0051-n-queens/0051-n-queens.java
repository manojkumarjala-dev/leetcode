class Solution {
    void helper(List<List<String>> ans, int n, int idx, char[][] grid, List<int[]> positions){
        if(idx == n){
            List<String> temp = new ArrayList<>();
            for(char[] ch: grid) temp.add(new String(ch));
            ans.add(temp);
            return;
        }


        for(int i = 0;i<n;i++){
            if(isValid(positions, idx, i)){
                grid[idx][i] = 'Q';
                positions.add(new int[]{idx,i});
                helper(ans,n,idx+1, grid, positions);
                positions.remove(positions.size()-1);
                grid[idx][i] = '.';
            }
        }
    }

    boolean isValid(List<int[]> positions, int row, int col){
        for(int[] arr: positions){
            if(arr[1]==col || (Math.abs(arr[0]-row) == Math.abs(arr[1]-col))) return false;
        }

        return true;
    }

    
    public List<List<String>> solveNQueens(int n) {

        List<List<String>> ans = new ArrayList<>();
        char[][] grid = new char[n][n];

        for(char[] c: grid) Arrays.fill(c,'.');

        helper(ans, n, 0, grid, new ArrayList<int[]>());

        return ans;
        
    }
}