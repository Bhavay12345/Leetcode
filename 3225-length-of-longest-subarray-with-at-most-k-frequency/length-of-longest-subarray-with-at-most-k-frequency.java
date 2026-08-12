class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        HashMap<Integer,Integer> map=new HashMap<>();
        int maxi=0;
        int i=0; int j=0;
        while(j<nums.length){
            
            if(!map.containsKey(nums[j])) {
                map.put(nums[j],1);
                maxi=Math.max(maxi,j-i+1);
                j++;
            }
            else{
                if(map.get(nums[j])<k){
                    map.put(nums[j],map.get(nums[j])+1);
                    maxi=Math.max(maxi,j-i+1);
                    j++;
                }
                else{
                    map.put(nums[i],map.get(nums[i])-1);
                    i++;
                }
            }
            
        }
        return maxi;
    }
}