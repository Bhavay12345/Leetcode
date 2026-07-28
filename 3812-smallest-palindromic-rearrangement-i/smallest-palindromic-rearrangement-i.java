class Solution {
    public String smallestPalindrome(String s) {
        int n=s.length();
        int[] alfa=new int[26];
        for(int i=0;i<n/2;i++){
            int num=s.charAt(i)-'a';
            alfa[num]+=1;
        }
        StringBuilder t =new StringBuilder();
        for(int i=0;i<26;i++){
            while(alfa[i]!=0){
                t.append((char)(i+'a'));
                alfa[i]-=1;
            }
        }
        if(n%2!=0) t.append(s.charAt(n/2));
        for(int i=(n/2)-1;i>=0;i--){
            t.append(t.charAt(i));
        }
        return t.toString();
    }
}