class Solution {
    public boolean validPalindrome(String s) {
        char[] ch = s.toCharArray();
        int l=0; int r=ch.length-1;
        while(l<r){
            if(s.charAt(l)!=s.charAt(r)){
                //going in both ways and take true one ans
                return after1margin(s,l+1,r) || after1margin(s,l,r-1);
            }
            l++;
            r--;
        }
        return true;
    }
    public boolean after1margin(String s,int l,int r){
        while(l<r){
            if(s.charAt(l)!=s.charAt(r)) return false;
            l++;
            r--;
        }
        return true;
    }
}