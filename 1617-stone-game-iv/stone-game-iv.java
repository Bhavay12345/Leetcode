class Solution {
    public boolean winnerSquareGame(int n) {
        Boolean[] dp=new Boolean[n+1];
        return fxn(n,dp);
    }
    public static boolean fxn(int n,Boolean[] dp){
        if(n==0) return false;
        if(dp[n]!=null) return dp[n];
        int root=(int)Math.sqrt(n);
        for(int i=1;i<=root;i++){
            if(fxn(n - (i * i),dp)==false) return dp[n]=true;
        }
        return false;
    }
}