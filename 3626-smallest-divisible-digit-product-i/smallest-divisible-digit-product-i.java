class Solution {
    public int smallestNumber(int n, int t) {
        int i=n; 
        int pro=fxn(i);
        while(pro%t!=0){
            pro=fxn(++i);
        }
        return i;
    }
    public static int fxn(int i){
        int pro=1;
        while(i!=0){
            int rem=i%10;
            pro*=rem;
            i=i/10;
        }
        return pro;
    }
}