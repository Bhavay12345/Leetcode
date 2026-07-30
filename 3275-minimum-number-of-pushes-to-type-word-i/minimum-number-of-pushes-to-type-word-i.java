class Solution {
    public int minimumPushes(String word) {
        int[] arr=new int[10];
        int p=2; int ans=0;
        for(int i=0;i<word.length();i++){
            if(p>=10) p=2;
            arr[p]++;
            ans+=arr[p];
            p++;
        }
        return ans;
    }
}