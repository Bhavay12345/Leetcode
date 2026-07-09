class Solution {
    public boolean[] pathExistenceQueries(int n, int[] nums, int maxDiff, int[][] queries) {
        int[] comp = new int[nums.length];
        boolean[] ans=new boolean[queries.length];
        int i=0;int j=1;
        int grp=0;
        while(j<nums.length){
            if(Math.abs(nums[i]-nums[j])<=maxDiff){
                comp[i]=grp; comp[j]=grp; 
            }
            else{
                comp[i]=grp;
                grp++;
                comp[j]=grp;
            }
            i++;j++;
        }
        for(i=0;i<queries.length;i++){
            int u=queries[i][0];
            int v=queries[i][1];
            if(comp[u]==comp[v]) ans[i]=true;
        }
        for(int k=0;k<comp.length;k++){
            System.out.println(comp[k]);
        }
        return ans;
    }
}