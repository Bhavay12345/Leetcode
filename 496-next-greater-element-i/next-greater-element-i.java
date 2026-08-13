class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<nums1.length;i++){
            if(!map.containsKey(nums1[i])) map.put(nums1[i],i);
        }
        Stack<Integer> st=new Stack<>();
        int[] ans=new int[nums1.length];
        for(int i=nums2.length-1;i>=0;i--){
            int curr=nums2[i];
            while(!st.isEmpty() && st.peek()<=curr){
                st.pop();
            }
            if(map.containsKey(curr)){
                if(st.isEmpty()) ans[map.get(curr)]=-1;
                else ans[map.get(curr)] =st.peek();
            }
            st.push(curr);       
        }
        return ans;
    }
}