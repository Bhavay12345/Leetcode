class Solution {
    public int maximumLengthSubstring(String s) {
        HashMap<Character,Integer> map=new HashMap<>();
        int i=0; int j=0; int max=1;
        while(j<s.length()){
            char ch=s.charAt(j);
            
            if(!map.containsKey(ch)) map.put(ch,1);
            else{
                if(map.get(ch)>1){
                    while(s.charAt(i)!=ch){
                        map.put(s.charAt(i),map.get(s.charAt(i))-1);
                        i++;
                    }
                    i++;
                }
                else map.put(ch,map.get(ch)+1);
            }
            max=Math.max(max,j-i+1);
            j++;
        }
        return max;
    }
}