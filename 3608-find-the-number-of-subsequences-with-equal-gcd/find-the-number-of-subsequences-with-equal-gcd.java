class Solution {
    static final int MOD = 1_000_000_007;
    public int subsequencePairCount(int[] nums) {
        int n = nums.length;
        int[][] gcd = new int[201][201];
        for (int i = 0; i <= 200; i++) {
            for (int j = 0; j <= 200; j++) {
                gcd[i][j] = gcd(i, j);
            }
        }

        int[][][] dp = new int[n + 1][201][201];

        // Base case
        for (int f = 0; f <= 200; f++) {
            for (int s = 0; s <= 200; s++) {
                dp[n][f][s] = (f == s) ? 1 : 0;
            }
        }

        // Fill backwards
        for (int i = n - 1; i >= 0; i--) {
            int x = nums[i];
            for (int f = 0; f <= 200; f++) {
                for (int s = 0; s <= 200; s++) {
                    long ans = dp[i + 1][f][s];     // skip
                    ans += dp[i + 1][gcd[f][x]][s]; // take first
                    ans += dp[i + 1][f][gcd[s][x]]; // take second

                    dp[i][f][s] = (int)(ans % MOD);
                }
            }
        }
        return (dp[0][0][0] - 1 + MOD) % MOD;
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