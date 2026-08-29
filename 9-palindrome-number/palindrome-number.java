class Solution {
    public boolean isPalindrome(int x) {
        if(x<0) return false;
        char[] ch= String.valueOf(x).toCharArray();
        int l=0; int r=ch.length-1;
        while(l<r){
            if(ch[l]!=ch[r]) return false;
            l++;r--;
        }
        return true;
    }
}