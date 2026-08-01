class Solution {
    public boolean predictTheWinner(int[] nums) {
        int n=nums.length;
        Integer[][] dp=new Integer[n][n];
        int sum=0;
        for(int i=0;i<n;i++){
            sum+=nums[i];
        }
        int sum1=fxn(0,n-1,nums,dp); int sum2=sum-sum1;
        if(sum1>=sum2) return true;
        else return false;
    }
    public static int fxn(int i,int j,int[] nums,Integer[][] dp){
        if(i>j) return 0;
        if(i==j) return nums[i];
        if(dp[i][j]!=null) return dp[i][j];
        int take_i=nums[i]+ Math.min(fxn(i+2,j,nums,dp),fxn(i+1,j-1,nums,dp));
        int take_j=nums[j]+ Math.min(fxn(i+1,j-1,nums,dp),fxn(i,j-2,nums,dp));

        return dp[i][j]=Math.max(take_i,take_j);
    }
}