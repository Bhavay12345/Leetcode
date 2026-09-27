class Solution {
    public int reverseDegree(String s) {
        int sum=0;
        for(int i=1;i<=s.length();i++){
            char ch = s.charAt(i-1);
            int num = ch - '0' - 49;
            sum = sum +((26-num)*i);
        }
        return sum;
    }
}