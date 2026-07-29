class Solution {
    public String longestCommonPrefix(String[] strs) {
        int n=strs.length;
        if(n==1) return strs[0];
        StringBuilder t=new StringBuilder();
        String s=strs[0];
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            for(int j=1;j<strs.length;j++){
                if(strs[j].length()<=i) return t.toString();
                char ch2=strs[j].charAt(i);
                if(ch2!=ch) return t.toString();
                else{
                    if(j==n-1) t.append(ch);
                }  
            }
        }
        return t.toString();
    }
}