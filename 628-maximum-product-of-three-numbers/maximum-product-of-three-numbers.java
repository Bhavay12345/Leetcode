class Solution {
    public int maximumProduct(int[] nums) {
        int n=nums.length;
        Arrays.sort(nums);
        int max1=(nums[0]*nums[1]);
        int max2=(nums[n-1]*nums[n-2]);
        int ans1=Integer.MIN_VALUE; int ans2=Integer.MIN_VALUE; 
        // if(max1>=max2) 
        ans1=(max1*Math.max(nums[2],nums[n-1]));
        
        // else 
        ans2=Math.max((max1*nums[n-1]),(max2*nums[n-3]));
        // ans=(max2*nums[n-3]);
        return Math.max(ans1,ans2);
    }
}