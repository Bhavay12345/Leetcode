class Solution {
    public long gcdSum(int[] nums) {
        int n=nums.length;
        int[] arr=new int[n];
        int maxi=-1;
        for(int i=0;i<n;i++){
            maxi=Math.max(maxi,nums[i]);
            arr[i]=gcd(nums[i],maxi);
        }
        Arrays.sort(arr);
        long sum=0;int i=0;int j=n-1;
        while(i<j){
            sum += gcd(arr[i++],arr[j--]);
        }
        for(int k=0;k<n;k++){
            System.out.println(arr[k]);
        }
        return sum;
    }
    public static int gcd(int a,int b){
        if(a==0) return b;
        while(b!=0){
            int temp=a%b;
            a=b;
            b=temp;
        }
        return a;
    }
}