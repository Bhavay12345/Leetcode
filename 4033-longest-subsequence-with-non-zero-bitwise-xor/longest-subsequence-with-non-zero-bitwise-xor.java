class Solution {
    public int longestSubsequence(int[] nums) {
        int n=nums.length;
        int xor=0;
        boolean allzero=true;
        for(int i=0;i<nums.length;i++){
            xor=(xor ^ nums[i]);
            if(nums[i]!=0) allzero=false;
        }
        if(allzero) return 0;
        else if(xor==0) return n-1;
        else return n;
    }
}