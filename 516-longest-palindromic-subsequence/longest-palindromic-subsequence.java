class Solution {
    Integer[][] dp= new Integer[1001][1001];
    public int longestPalindromeSubseq(String s) {
        return fxn(s,0,s.length()-1);
    }
    public int fxn(String s,int i,int j){
        if(i > j) return 0;
        if(i == j) return 1; //same alfa
        if(dp[i][j] != null) return dp[i][j];
        if(s.charAt(i) == s.charAt(j)){
            return dp[i][j] = 2 + fxn(s,i+1,j-1) ;
        }
        else{
            return dp[i][j] = Math.max(fxn(s,i+1,j),fxn(s,i,j-1));
        }
    }
}