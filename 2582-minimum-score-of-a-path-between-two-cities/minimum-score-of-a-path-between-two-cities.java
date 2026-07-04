class Solution {
    int m=Integer.MAX_VALUE;

    public int minScore(int n, int[][] roads) {
        ArrayList<ArrayList<pair>> adj=new ArrayList<>();
        for(int i=0;i<=n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<roads.length;i++){
            int u=roads[i][0];
            int v=roads[i][1];
            int d=roads[i][2];

            adj.get(u).add(new pair(v,d));
            adj.get(v).add(new pair(u,d));
        }
        boolean[] vis=new boolean[n+1];
         
        dfs(1,vis,adj,n);
        return m;
    }
    public void dfs(int cn,boolean[] vis,ArrayList<ArrayList<pair>> adj,int n){
        vis[cn]=true;
    
        for(int i=0;i<adj.get(cn).size();i++){
            int v=adj.get(cn).get(i).f;
            m=Math.min(m,adj.get(cn).get(i).s);
            if(!vis[v]){
                dfs( v,vis,adj,n );
            }
        }
    }
}
class pair{
    int f; int s;
    public pair(int f,int s){
        this.f=f;
        this.s=s;
    }
}