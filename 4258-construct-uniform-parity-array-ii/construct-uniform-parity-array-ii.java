class Solution {
    public boolean uniformArray(int[] nums1) {
        int[] odd=new int[nums1.length];
        Arrays.sort(nums1);
        int c=0;
        for(int i=0;i<nums1.length;i++){
            if(nums1[i] % 2 == 1) c++;
            odd[i]=c;
        }
        if(c == 0) return true; // all even
        if(c == nums1.length) return true; // all odd
        //we check can we make all odd
        for(int i=nums1.length-1;i>=0;i--){
            if(nums1[i] % 2 == 0){
                if(odd[i] == 0) return false;
            }
        }
        return true;
    }
}