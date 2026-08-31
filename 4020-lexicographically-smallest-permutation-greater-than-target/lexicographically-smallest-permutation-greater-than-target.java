class Solution {
    String res="";
    public String lexGreaterPermutation(String s, String target) {
        int[] count= new int[26];
        for(int i=0;i<s.length();i++){
            int num=s.charAt(i)-'a';
            count[num]++;
        }
        StringBuilder ans=new StringBuilder();
        fxn(0,ans,target,count,false);
        return res;
    }
    public boolean fxn(int i,StringBuilder ans,String t,int[] count,boolean greater){
        //base case
        if(i >= t.length()){
            if(greater==true){
                res=ans.toString();
                return true;
            }
            return false;
        }
        
        for(char ch='a' ;ch <= 'z';ch++){
            if(count[ch - 'a'] <= 0) continue; //that char is not aval
            if(greater==false && ch < t.charAt(i)) continue; //abe curr t char se chota ni le sakte 

            // Append char
            ans.append(ch);
            count[ch-'a']--;
//mark greater T if greater allready T || added grater ch in ans
            boolean isGreater= greater || ch > t.charAt(i);

            // move forward
            if(fxn(i+1,ans,t,count,isGreater)==true){ // last m smallest lexoco mil gya
                return true;
            }
            // Back track (last tak greater true hi nhi hua)
            ans.deleteCharAt(ans.length()-1);
            count[ch-'a']++;
        }
        return false; // s = "baba", target = "bbaa"
    }
}