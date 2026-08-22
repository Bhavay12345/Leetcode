class Solution {
    public boolean checkDivisibility(int n) {
        int sum=0;
        int product=1;
        int m=n;
        while(m!=0){
            int rem=m%10;
            sum+=rem;
            product*=rem;
            m=m/10;
        }    
        return n%(sum+product) == 0;
    }
}