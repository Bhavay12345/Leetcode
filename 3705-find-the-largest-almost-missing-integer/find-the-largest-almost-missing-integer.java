class Solution {
    public int largestInteger(int[] nums, int k) {
        HashMap<Integer,Integer> map=new HashMap<>();
        int maxi=-1;
        for(int i=0;i<=nums.length-k;i++){
            HashSet<Integer> set = new HashSet<>();
            for(int j=i;j<i+k;j++){
                set.add(nums[j]);
            }
            for(int x: set){
                if(map.containsKey(x)) map.put(x,map.get(x)+1);
                else {
                    map.put(x,1);
                }
            } 
        }
        for(Map.Entry<Integer,Integer> e : map.entrySet()){
            if(e.getValue()==1){
                maxi=Math.max(maxi,e.getKey());
            }
        }
        return maxi;
    }
}