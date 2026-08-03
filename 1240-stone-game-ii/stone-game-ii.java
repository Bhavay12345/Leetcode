class Solution {
    public int stoneGameII(int[] piles) {
        int n=piles.length;
        Integer[][][] dp=new Integer[n+1][2][n+1];
        return fxn(0,1,1,piles,dp);
    }
    public static int fxn(int i,int chance,int m,int[] nums,Integer[][][] dp){
        if(i>=nums.length) return 0;
        if(dp[i][chance][m]!=null) return dp[i][chance][m];
        int res=0;
        if(chance==1) res=-1;
        else res=Integer.MAX_VALUE;
        int stone=0;
        for(int x=1;x<=Math.min(2*m,nums.length-i);x++){
            
            if(chance==1){
                stone+=nums[i+x-1];
                res=Math.max(res,stone+fxn(i+x,0,Math.max(x,m),nums,dp));
            }
            else{
                res=Math.min(res,fxn(i+x,1,Math.max(x,m),nums,dp));
            }
        }
        return dp[i][chance][m]=res;
    }
}