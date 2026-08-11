class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<nums2.length;i++){
            if(!map.containsKey(nums2[i])) map.put(nums2[i],i);
        }
        int[] ans=new int[nums1.length];
        for(int i=0;i<nums1.length;i++){
            int x=nums1[i];
            int idx=map.get(x);
            int j=0;
            for(j=idx;j<nums2.length;j++){
                if(nums2[j]>x){
                    ans[i]=nums2[j];
                    break;
                }
            }
            if(j==nums2.length) ans[i]=-1;
        }
        return ans;
    }
    
}