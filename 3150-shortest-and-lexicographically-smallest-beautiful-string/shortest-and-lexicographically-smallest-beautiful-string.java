class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        int c=0;
        int i=0;int j=0;
        String res="";
        StringBuilder sb = new StringBuilder();
        while(j<s.length()){
            char ch=s.charAt(j);
            if(ch=='1') c++;
            sb.append(ch);
            if(c>=k){
                while(i<s.length() && (c>k || s.charAt(i)=='0')){
                    if(s.charAt(i)=='1') c--;
                    if(sb.length()>0) sb.deleteCharAt(0);
                    i++;
                }
                if(c==k){
                    if(sb.length()<res.length() || res.length()==0) res=sb.toString();
                    else if(sb.length() == res.length() && sb.toString().compareTo(res) < 0){
                        res=sb.toString();
                    }
                }
            }
            j++;
        }
        return res;
    }
}