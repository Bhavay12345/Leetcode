class Solution {
    public int minimumDeletions(int[] nums) {
        int n=nums.length;
        int mini=Integer.MAX_VALUE; int minidx=0;
        int maxi=Integer.MIN_VALUE; int maxidx=0;
        for(int i=0;i<n;i++){
            if(nums[i]>maxi){
                maxi=nums[i];
                maxidx=i;
            }
            if(nums[i]<mini){
                mini=nums[i];
                minidx=i;
            }
        }
        int bothF = Math.max(minidx,maxidx) + 1 ;
        int bothB = n - Math.min(minidx,maxidx) ;
        int way1 = maxidx + 1 + n - minidx ;
        int way2 = minidx + 1 + n - maxidx ;

        return Math.min(Math.min(bothF,bothB),Math.min(way1,way2));
    }
}