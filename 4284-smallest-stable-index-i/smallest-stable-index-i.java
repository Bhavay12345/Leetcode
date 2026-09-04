class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int n=nums.length;
        int[] arr= new int[n];
        int min=nums[n-1];
        for(int i=n-1;i>=0;i--){
            min=Math.min(min,nums[i]);
            arr[i]=min;
        }
        int max=0;
        for(int i=0;i<n;i++){
            max=Math.max(max,nums[i]);
            if(max-arr[i] <= k){
                return i;
            }
        }
        return -1;
    }
}