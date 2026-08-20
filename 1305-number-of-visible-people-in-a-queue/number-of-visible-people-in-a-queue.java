class Solution {
    public int[] canSeePersonsCount(int[] heights) {
        int n=heights.length;
        int[] ans=new int[n];
        Stack<Integer> st=new Stack<>();
        for(int i=n-1;i>=0;i--){
            int count=0;
            while(!st.isEmpty() && heights[i]>=st.peek()){
                st.pop();
                count++;
            } 
            // First taller person is also visible
            if(!st.isEmpty()) count++;
            ans[i]=count;
            st.push(heights[i]);
        }
        return ans;
    }
}