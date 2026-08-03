class Solution {
    public String stoneGameIII(int[] stoneValue) {
        Integer[] dp=new Integer[stoneValue.length];
        int diff=fxn(0,stoneValue,stoneValue.length,dp);
        if(diff==0) return "Tie";
        else if(diff>0) return "Alice";
        else return "Bob";
    }
    public static int fxn(int i,int[] nums,int n,Integer[] dp){
        if(i>=n) return 0;
        if(dp[i]!=null) return dp[i];
        int res=Integer.MIN_VALUE;
        int res2=Integer.MIN_VALUE;
        int res3=Integer.MIN_VALUE;
        res = nums[i] - fxn(i+1,nums,n,dp);
        if(n-i>=2) res2 = nums[i]+nums[i+1] - fxn(i+2,nums,n,dp);
        if(n-i>=3) res3= nums[i]+nums[i+1]+nums[i+2] - fxn(i+3,nums,n,dp);
        return dp[i]=Math.max(res,Math.max(res2,res3));
    }
}