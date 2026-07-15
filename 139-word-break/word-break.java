class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        HashMap<String,Integer> map=new HashMap<>();
        Boolean[][] dp= new Boolean[s.length()+1][s.length()+1];
        for(int i=0;i<wordDict.size();i++){
            if(!map.containsKey(wordDict.get(i))) map.put(wordDict.get(i),1);
        }
        return fxn(0,1,map,s,dp);
    }
    public static boolean fxn(int i,int j,HashMap<String,Integer> map,String s,Boolean[][] dp){
        if(j==s.length()){
            if(!map.containsKey(s.substring(i,j))) return false;
            else return true;
        }
        if(dp[i][j]!=null) return dp[i][j];
        boolean take=false;
        boolean nottake=false;
        if(map.containsKey(s.substring(i,j))){
            take=fxn(j,j+1,map,s,dp);
            nottake= fxn(i,j+1,map,s,dp);
        }
        else{
            return fxn(i,j+1,map,s,dp);
        }
        return dp[i][j]=take || nottake;
    }
}