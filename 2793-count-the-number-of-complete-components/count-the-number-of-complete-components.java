class Solution {
    int V=0;
    int E=0;
    public int countCompleteComponents(int n, int[][] edges) {
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<edges.length;i++){
            int u=edges[i][0];
            int v=edges[i][1];

            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        boolean[] vis=new boolean[n];
        int ans=0;
        for(int i=0;i<vis.length;i++){
            V=0;
            E=0;
            if(!vis[i]){
                dfs(i,vis,adj);
                if(E/2==(V*(V-1))/2) ans++;
            }
        }
        return ans;
    }
    public void dfs(int node,boolean[] vis,ArrayList<ArrayList<Integer>> adj){
        vis[node]=true;
        V++;
        E+=adj.get(node).size();
        for(Integer it : adj.get(node)){
            if(vis[it]==false){
                dfs(it,vis,adj);
            }
        }
    }
}