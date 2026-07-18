class Solution {
    public int findGCD(int[] nums) {

        int maxi=Integer.MIN_VALUE;int min=Integer.MAX_VALUE;
        for(int i=0;i<nums.length;i++){
            maxi=Math.max(maxi,nums[i]);
            min=Math.min(min,nums[i]);
        }
        return gcd(min,maxi);
    }
    public static int gcd(int a,int b){
        if(a==0) return b;
        while(b!=0){
            int rem=a%b;
            a=b;
            b=rem;
        }
        return a;
    }
}