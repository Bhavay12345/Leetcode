class Solution {
    public String removeOuterParentheses(String s) {
        StringBuilder sb= new StringBuilder();
        Stack<Character> st = new Stack<>();
        boolean in= false;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='('){
                if(in) sb.append('(');
                else in=true;
                st.push('(');
            }
            else{
                st.pop();
                if(!st.isEmpty()) sb.append(')');
                else in=false;
            }
        }
        return sb.toString();
    }
}