class Solution {
    public int maxProduct(int n) {
        int r1=n%10;
        n=n/10;
        int r2=n%10;
        n=n/10;
        int max1=Math.max(r1,r2); int max2=Math.min(r1,r2);
        while(n!=0){
            int rem=n%10;
            n/=10;
            if(rem>=max1){
                max2=max1;
                max1=rem;
            }
            else if(rem>max2) max2=rem;
        }
        return max1*max2;
    }
}