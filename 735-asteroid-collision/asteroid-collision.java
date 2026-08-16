class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st=new Stack<>();
        for(int i=0;i<asteroids.length;i++){
            int curr=asteroids[i];
            if(curr>=0){
                st.push(curr);
            }
            else{   
                while(!st.isEmpty() && st.peek()>0 && st.peek() < Math.abs(curr)){
                    st.pop();
                }
                if(st.isEmpty() || st.peek()<0) st.push(asteroids[i]);
                else if(!st.isEmpty() && st.peek() == Math.abs(curr)){
                    st.pop();
                }
            }
        }
        int[] ans=new int[st.size()];
        for(int i=0;i<st.size();i++){
            ans[i]=st.get(i);
        }
        return ans;
    }
}