class Solution {
    public int minimumPushes(String word) {
        int[] arr=new int[26];
        for(int i=0;i<word.length();i++){
            int num=word.charAt(i)-'a';
            arr[num]++;
        }
        Arrays.sort(arr);
        for(int i=0,j=25;i<j;i++,j--){
            int temp=arr[i];
            arr[i]=arr[j];
            arr[j]=temp;
        }
        int ans=0;
        for(int i=0;i<arr.length;i++){
            int num=(i/8)+1;
            ans+=num*arr[i];
        }
        return ans;
    }
}