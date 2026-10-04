class Solution {
    public boolean checkValidString(String s) {
        Boolean[][] dp=new Boolean[s.length()][s.length()];
        return fxn(0,s,0,dp);
    }
    public static boolean fxn(int i,String s,int bal,Boolean[][] dp){
        if(bal<0) return false;
        if(i==s.length()){
            if(bal==0) return true;
            else return false;
        }
        if(dp[i][bal]!=null) return dp[i][bal];
        char ch=s.charAt(i);
        if(ch=='(') {
            return fxn(i+1,s,bal+1,dp);
        }
        if(ch==')') {
            return fxn(i+1,s,bal-1,dp);
        }
        boolean f1=false;
        boolean f2=false;
        boolean f3=false;
        if(ch=='*'){
            f1=fxn(i+1,s,bal+1,dp); // * -> (
            f2=fxn(i+1,s,bal-1,dp); // * -> )
            f3=fxn(i+1,s,bal,dp);   // * -> " "
        }

        return dp[i][bal] = f1 || f2 || f3;
    }
}