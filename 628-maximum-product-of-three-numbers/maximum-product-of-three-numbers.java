class Solution {
    public int maximumProduct(int[] nums) {
        int n=nums.length;
        Arrays.sort(nums);
        int max1=(nums[0]*nums[1]);
        int max2=(nums[n-1]*nums[n-2]);
        int ans1=Integer.MIN_VALUE; int ans2=Integer.MIN_VALUE; 

        ans1=(max1*nums[n-1]);

        ans2=(max2*nums[n-3]);

        return Math.max(ans1,ans2);
    }
}