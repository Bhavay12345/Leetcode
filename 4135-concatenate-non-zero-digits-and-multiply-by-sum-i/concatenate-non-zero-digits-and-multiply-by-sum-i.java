class Solution {
    public long sumAndMultiply(int n) {
        long sum=0; long x=0;
        String s=String.valueOf(n);
        for(int i=0;i<s.length();i++){
            int dig=s.charAt(i)-'0';
            if(dig!=0){
                x=(x*10)+dig;
                sum+=dig;
            }
        }
        return x*sum;
    }
}