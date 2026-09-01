class Solution {
    public int[] plusOne(int[] digits) {
        for(int i=digits.length-1;i>=0;i--){
            if(digits[i]<9){
                digits[i]++;
                return digits; // when ans settle in same arr
            }
            digits[i]=0;
        }
        int[] ans= new int[digits.length+1]; // if all are 9 in digits
        ans[0]=1;
        return ans;
    }
}