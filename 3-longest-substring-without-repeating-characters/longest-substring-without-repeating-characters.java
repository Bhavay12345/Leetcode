class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character,Integer> map= new HashMap<>();
        int i=0;int j=0;int len=0;
        while(j<s.length()){
            char ch=s.charAt(j);
            if(map.containsKey(ch)){
                map.remove(s.charAt(i));
                i++;
            }
            else{
                map.put(ch,1);
                len=Math.max(len,(j-i+1));
                j++;
            }
        }
        return len;
    }
}