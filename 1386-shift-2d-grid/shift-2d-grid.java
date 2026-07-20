class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int n=grid.length; int m=grid[0].length;
        List<List<Integer>> ans = new ArrayList<>();
        for(int x=0;x<k;x++){
            int temp=grid[n - 1][m - 1];
            for(int i=n-1;i>=0;i--){
                for(int j=m-1;j>=0;j--){  
                    if(j!=0){
                        grid[i][j]=grid[i][j - 1];
                    }
                    else{
                        if(i==0) grid[i][j] = temp;
                        else{
                            grid[i][j]=grid[i-1][m-1];
                        }
                    }
                }
            }
        }
        
        for(int i=0;i<n;i++){
            List<Integer> ll = new ArrayList<>();
            for(int j=0;j<m;j++){
                ll.add(grid[i][j]);
            }
            ans.add(ll);
        }
        return ans;

    }
}