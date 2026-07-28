class Solution {
    public int maxProfit(int[] prices) {
        Integer[][] dp=new Integer[prices.length][2];
        return fxn(0,0,prices,dp);
    }
    public static int fxn(int i,int st,int[] prices,Integer[][] dp){
        if(i == prices.length)
            return 0;

        if(dp[i][st]!=null) return dp[i][st];
        if(st==0){
            int buy=fxn(i+1,1,prices,dp)-prices[i];
            int skip=fxn(i+1,st,prices,dp);

            return dp[i][st]=Math.max(skip,buy);
        }
        else{
            int sell=prices[i]+ fxn(i+1,0,prices,dp);
            int skip=fxn(i+1,st,prices,dp);

            return dp[i][st]=Math.max(skip,sell);
        }
    }
}