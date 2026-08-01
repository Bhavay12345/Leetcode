class Solution {
    public boolean predictTheWinner(int[] nums) {
        int sum=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
        }
        int sum1=fxn(0,nums.length-1,nums); int sum2=sum-sum1;
        if(sum1>=sum2) return true;
        else return false;
    }
    public static int fxn(int i,int j,int[] nums){
        if(i>j) return 0;
        if(i==j) return nums[i];
        int take_i=nums[i]+ Math.min(fxn(i+2,j,nums),fxn(i+1,j-1,nums));
        int take_j=nums[j]+ Math.min(fxn(i+1,j-1,nums),fxn(i,j-2,nums));

        return Math.max(take_i,take_j);
    }
}