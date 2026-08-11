class Solution {
    public int missingInteger(int[] nums) {
        HashMap<Integer,Integer> map= new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(!map.containsKey(nums[i])) map.put(nums[i],1);
        }
        int cs=nums[0];
        int mini=cs;
        int i=0;
        for(i=1;i<nums.length;i++){
            if(nums[i]==nums[i-1]+1) cs+=nums[i];
            else {
                mini=check(cs,map);
                break;
            }
        }
        if(i==nums.length) return check(cs,map);
        System.out.print(cs);
        return mini;
    }
    public static int check(int n,HashMap<Integer,Integer> map){
        while(map.containsKey(n)){
            n++;
        }
        return n;
    }
}