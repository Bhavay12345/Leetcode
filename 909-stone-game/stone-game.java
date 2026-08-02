class Solution {
    public boolean stoneGame(int[] piles) {
        int n=piles.length;
        Integer[][] dp=new Integer[n][n];
        int diff=fxn(0,n-1,piles,dp);
        return diff>=0;
    }
    public static int fxn(int i,int j,int[] nums,Integer[][] dp){

        if(i>j) return 0;
        if(dp[i][j]!=null) return dp[i][j];
        int take_i = nums[i] - fxn(i+1,j,nums,dp);
        int take_j = nums[j] - fxn(i,j-1,nums,dp);

        return dp[i][j]=Math.max(take_i,take_j);
    }
}