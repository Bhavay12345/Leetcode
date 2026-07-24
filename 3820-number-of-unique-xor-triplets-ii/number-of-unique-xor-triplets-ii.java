class Solution {
    public int uniqueXorTriplets(int[] nums) {
        int n=nums.length;
        Set<Integer> s1=new HashSet<>();
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                s1.add(nums[i] ^ nums[j]);
            }
        }
        Set<Integer> s2=new HashSet<>();
        for(int x:s1){
            for(int j=0;j<n;j++){
                s2.add(x ^ nums[j]);
            }
        }
        return s2.size();
    }
}