class Solution {
    public int maxDepth(String s) {
        int bal=0; int ans=0;
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(ch=='(') {
                bal++;
                ans=Math.max(ans,bal);
            }
            else if(ch==')') bal--;
            
        }
        return ans ;
    }
}