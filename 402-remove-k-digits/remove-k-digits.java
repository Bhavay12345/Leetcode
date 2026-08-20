class Solution {
    public String removeKdigits(String num, int k) {
        int m=num.length();
        Stack<Integer> st=new Stack<>();
        for(int i=0;i<m;i++){
            int curr=num.charAt(i)-'0';
            while(!st.isEmpty() && curr<st.peek() && k>0){
                st.pop();
                k--;
            }
            st.push(curr);
        }
        while(k > 0) {
            st.pop();
            k--;
        }
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<st.size();i++){
            if(sb.length()==0 && st.get(i)==0) continue;
            sb.append(st.get(i));
        }
        if(sb.length()==0) return "0";
        return sb.toString();
    }
}