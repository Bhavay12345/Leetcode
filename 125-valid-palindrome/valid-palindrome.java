class Solution {
    public boolean isPalindrome(String s) {
        char[] ch = s.toCharArray();
        int l=0; int r=ch.length-1;
        while(l<r){
            if(!Character.isLetterOrDigit(ch[l])){
                l++;
                continue;
            } 
            if(!Character.isLetterOrDigit(ch[r])){
                r--;
                continue;
            } 
            if(Character.toLowerCase(ch[l]) != Character.toLowerCase(ch[r])){
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}