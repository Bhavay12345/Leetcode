class Solution {
    public int lengthOfLIS(int[] nums) {
        int n=nums.length;
        Integer[][] dp=new Integer[n][n+1];
        return fxn(0,-1,nums,dp);
    }
    public static int fxn(int i,int last,int[] nums,Integer[][] dp){
        if(i>=nums.length){
            return 0;
        }
        if(dp[i][last+1]!=null) return dp[i][last+1];
        int f1=0;
        if(last==-1 || nums[i]>nums[last]){
            f1=1 + fxn(i+1,i,nums,dp); // take
        }
        int f2=0 + fxn(i+1,last,nums,dp);
        return dp[i][last+1]=Math.max(f1,f2);

    }
}