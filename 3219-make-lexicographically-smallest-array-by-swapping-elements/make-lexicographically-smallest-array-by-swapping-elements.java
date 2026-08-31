class Solution {
    public int[] lexicographicallySmallestArray(int[] nums, int limit) {
        //making duplicate sorted arr
        int[] arr=new int[nums.length];
        for(int i=0;i<nums.length;i++) arr[i]=nums[i];
        Arrays.sort(arr);
        //making groups of reachable elements with limit
        HashMap<Integer,ArrayList<Integer>> grp=new HashMap<>();
        HashMap<Integer,Integer> findgrp=new HashMap<>();
        int currgrp=0;
        grp.put(currgrp,new ArrayList<>());
        grp.get(currgrp).add(arr[0]);
        findgrp.put(arr[0],currgrp);
        for(int i=1;i<nums.length;i++){
            if(! (Math.abs(arr[i] - arr[i-1]) <= limit) ){
                currgrp++;
                grp.put(currgrp,new ArrayList<>());
            }
            grp.get(currgrp).add(arr[i]);
            findgrp.put(arr[i],currgrp);
        }
        //finding actual ans
        for(int i=0;i<nums.length;i++){
            int g = findgrp.get(nums[i]);
            nums[i] = grp.get(g).remove(0);
        }
        return nums;
    }
}