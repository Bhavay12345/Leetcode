class Solution {
    public int maxProfit(int[] prices) {
        int n=prices.length;
        Integer[][] dp=new Integer[n][2];
        return fxn(0,0,prices,dp);

    }
    public static int fxn(int i,int stock,int[] prices,Integer[][] dp){
        if(i>=prices.length){
            return 0;
        }
        if(dp[i][stock]!=null) return dp[i][stock];
        
        int ans;
        if(stock==0){
            int buy=fxn(i+1,1,prices,dp)-prices[i];
            int coll=fxn(i+1,stock,prices,dp);
            ans=Math.max(buy,coll);
        }
        else{
            int sell=prices[i]+ fxn(i+2,0,prices,dp);
            int coll=fxn(i+1,stock,prices,dp);
            ans=Math.max(sell,coll);
        }
        return dp[i][stock]=ans;
    }
}