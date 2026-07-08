class Solution {
    public int[] sumAndMultiply(String s, int[][] queries) {
        int[] arr=new int[queries.length];
        long MOD = 1_000_000_007L;
        long[] pow10 = new long[s.length() + 1];
        pow10[0] = 1;

        for(int i = 1; i <= s.length(); i++){
            pow10[i] = (pow10[i-1] * 10) % MOD;
        }

        int[] prex=new int[s.length()+1];
        int[] predig=new int[s.length()+1];
        int[] presum=new int[s.length()+1];
        long cu=0;
        int nonzeroc=0;
        for(int i=1;i<s.length()+1;i++){
            int dig=s.charAt(i-1)-'0';
            if(dig!=0) {
                cu=(cu*10+dig)%MOD;
                nonzeroc++;
            }
            prex[i]=(int) cu;
            predig[i]=nonzeroc;
            presum[i]= dig + presum[i-1];
        }

        for(int i=0;i<queries.length;i++){
            int l=queries[i][0]; int r=queries[i][1]; 
            long sum=presum[r+1]-presum[l];
            int digit=predig[r+1]-predig[l];
            long x=(prex[r+1]-(prex[l]*pow10[digit])%MOD+MOD)%MOD;
            arr[i]=(int)((x*sum)%MOD);
        }
        return arr;
    }
}