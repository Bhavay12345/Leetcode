class Solution {
    public int[] plusOne(int[] digits) {
        Stack<Integer> st= new Stack<>();
        int n= digits.length;
        int zero=0; int i=0;
        while(i<n){
            if(i==n-1){
                if(digits[i]==9){
                    zero++;
                    while(!st.isEmpty() && st.peek()==9){
                        zero++;
                        st.pop();
                    }
                    if(!st.isEmpty()){
                        int num=st.pop();
                        st.push(num+1);
                    }
                    else st.push(1);
                }
                else st.push(digits[i]+1);
            }
            else st.push(digits[i]);
            i++;
        }
        int size= st.size() + zero ;
        int[] ans = new int[size];
        for(i=0;i<size;i++){
            if(i<st.size()) ans[i]=st.get(i);
            
        }
        return ans;
    }
}