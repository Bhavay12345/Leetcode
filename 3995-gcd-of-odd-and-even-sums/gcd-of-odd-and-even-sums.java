class Solution {
    public int gcdOfOddEvenSums(int n) {
        int s1=n*n;
        int s2=n*(n+1);
        System.out.println(s1);
        System.out.println(s2);
        return gcd(s1,s2);
    }
    public static int gcd(int a,int b){
        if(a==0) return b;
        while(b!=0){
            int rem=a%b;
            a=b;
            b= rem;
        }
        return a;
    }
}