class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        ArrayList<Integer> ll=new ArrayList<>();
        Arrays.sort(nums);
        int c=nums[0]; int i=0;
        while(c!=nums[nums.length-1]){
            if(c!=nums[i]) ll.add(c);
            else i++; 
            c++;
        }
        return ll;
    }
}