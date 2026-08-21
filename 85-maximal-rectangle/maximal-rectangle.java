class Solution {
    static Stack<Integer> st=new Stack<>();
    public int maximalRectangle(char[][] matrix) {
        int r = matrix.length;
        int c = matrix[0].length;
        int[] arr=new int[c];
        for(int i=0;i<c;i++){
            arr[i]=matrix[0][i]-'0';
        }
        int maxi=-1;
        for(int row=0;row<r;row++){
            for(int i=0;i<c;i++){
                if(row!=0 && matrix[row][i]=='1'){
                    arr[i]++;
                }
                else if(row!=0 && matrix[row][i]=='0'){
                    arr[i]=0;
                } 
            }
            int[] nse=new int[c]; Nse(nse,arr);
            int[] pse=new int[c]; Pse(pse,arr);
            
            for(int i=0;i<c;i++){
                int right=nse[i]-i-1;
                int left= i-pse[i]-1;

                int area=arr[i]*(left+right+1);
                maxi=Math.max(maxi,area);
            }
        }
        return maxi;
    }
    public void Nse(int[] nse,int[] arr){
        int n=arr.length;
        for(int i=n-1;i>=0;i--){
            int curr=arr[i];
            while(!st.isEmpty() && curr<=arr[st.peek()])  st.pop();
            if(st.isEmpty()) nse[i]=n;
            else nse[i]=st.peek();
            st.push(i);
        }
        st.clear();
    }
    public void Pse(int[] pse,int[] arr){
        int n=arr.length;
        for(int i=0;i<n;i++){
            int curr=arr[i];
            while(!st.isEmpty() && curr<=arr[st.peek()])  st.pop();
            if(st.isEmpty()) pse[i]=-1;
            else pse[i]=st.peek();
            st.push(i);
        }
        st.clear();
    }
}