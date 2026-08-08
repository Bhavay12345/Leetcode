class Solution {
    public int[] validSequence(String word1, String word2) {
        int n=word1.length(); int m=word2.length();
        int[] sufix=new int[n];
        int ccount=0;
        int[] ans= new int[m];
        int i=n-1; int j=m-1;
        while(i>=0){
            if(j<0) j=j;
            else if(word1.charAt(i)==word2.charAt(j)){
                ccount++;
                j--;
            }
            sufix[i]=ccount;
            i--;
        }
        i=0; j=0; boolean canchange=true;
        while(j<m && i<n){
            if(word1.charAt(i)==word2.charAt(j)){
                ans[j]=i;
                j++;
            }
            else{
                if(i!=n-1 && sufix[i+1]>=m-j-1 && canchange==true){
                    ans[j]=i;
                    canchange=false;
                    j++;
                }
            }
            i++;
        }
        if(j!=m) return new int[0];
        return ans;
    }
}