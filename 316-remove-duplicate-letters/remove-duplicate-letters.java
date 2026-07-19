class Solution {
    public String removeDuplicateLetters(String s) {
        boolean[] vis= new boolean[26];
        int[] lastplace= new int[26];
        for(int i=0;i<s.length();i++){
            char ch= s.charAt(i);
            lastplace[ch-'a']=i;
        }
        String t="";
        int i=0;
        while(i<s.length()){
            char ch= s.charAt(i);
            int k=(t.length()-1);
            if(!vis[ch-'a']){
                if( k<0 || ch>t.charAt(k) ) {
                    t+=ch;
                    vis[ch-'a']=true;
                }
                else{
                    while(k >= 0 && t.charAt(k) > ch && lastplace[t.charAt(k)-'a'] > i){
                        vis[t.charAt(k)-'a']=false;
                        t=t.substring(0,k);
                        k--;
                    }
                    t+=ch;
                    vis[ch-'a']=true;
                }
            }
            i++;
        }
        return t;
    }
}