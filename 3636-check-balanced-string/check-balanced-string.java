class Solution {
    public boolean isBalanced(String num) {
        int O=0; int E=0;
        for(int i=0;i<num.length();i++){
            if(i%2==0) E+=num.charAt(i)-'0';
            else O+=num.charAt(i)-'0';
        }
        return E==O;
    }
}