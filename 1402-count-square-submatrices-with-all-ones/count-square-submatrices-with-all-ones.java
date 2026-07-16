class Solution {
    public int countSquares(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp=new int[m][n];
        int c=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j]==1){
                    c+=fxn(i,j,m,n,matrix,dp);
                }
            }
        }
        return c;
    }
    public static int fxn(int i,int j,int m,int n,int[][] matrix,int[][] dp){
        if(i>=m || j>=n || matrix[i][j]==0) return 0;

        if(dp[i][j]!=0) return dp[i][j];

        int right=fxn(i,j+1,m,n,matrix,dp);
        int down=fxn(i+1,j,m,n,matrix,dp);
        int dig=fxn(i+1,j+1,m,n,matrix,dp);

        return dp[i][j]=1+Math.min(right,Math.min(down,dig));
    }
}