class Solution {
    static Stack<Integer> st=new Stack<>();
    public int largestRectangleArea(int[] heights) {
        int n=heights.length;
        int[] nse=new int[n];
        Nse(nse,heights);
        int[] pse=new int[n];
        Pse(pse,heights);
        int maxi=-1;
        for(int i=0;i<n;i++){
            int right=nse[i]-i-1; //
            int left= i-pse[i]-1;

            int sum=heights[i]*(left+right+1);
            maxi=Math.max(maxi,sum);
        }
        return maxi;

    }
    public void Nse(int[] nse,int[] height){
        int n=height.length;
        for(int i=n-1;i>=0;i--){
            int curr=height[i];
            while(!st.isEmpty() && curr<=height[st.peek()]){
                st.pop();
            }
            if(st.isEmpty()) nse[i]=n;
            else nse[i]=st.peek();
            st.push(i);
        }
        st.clear();
    }
    public void Pse(int[] pse,int[] height){
        int n=height.length;
        for(int i=0;i<n;i++){
            int curr=height[i];
            while(!st.isEmpty() && curr<=height[st.peek()]){
                st.pop();
            }
            if(st.isEmpty()) pse[i]=-1;
            else pse[i]=st.peek();
            st.push(i);
        }
        st.clear();
    }
}