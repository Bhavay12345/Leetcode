class Solution {
    public int maximumSafenessFactor(List<List<Integer>> grid) {
        int n=grid.size();
        int [][] arr = new int[n][n];
        boolean[][] vis= new boolean[n][n];
        Queue <pair> q=new LinkedList<pair>();
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if (grid.get(i).get(j)==1){
                    vis[i][j]=true;
                    q.add(new pair(i,j));
                }
                
            }
        }//
        while(!q.isEmpty()){
            int cr=q.peek().f;
            int cc=q.peek().s;
            q.remove();
            int[] dr={-1,1,0,0};
            int[] dc={0,0,-1,1};
            for(int k=0;k<4;k++){
                int nbrr=cr+dr[k];
                int nbrc=cc+dc[k];
                if(nbrr>=0 && nbrr<n && nbrc>=0 && nbrc<n && vis[nbrr][nbrc]==false){
                    vis[nbrr][nbrc]=true;
                    q.add(new pair(nbrr,nbrc));
                    arr[nbrr][nbrc]= arr[cr][cc]+1;
                }
            }
        }
        int s=0; int e=2*n;
        int max=Integer.MIN_VALUE;
        
        while(s<=e){
            boolean[][] vis1= new boolean[n][n];
            int mid=(s+e)/2;
            boolean check=fxn(0,0,mid,arr,n,vis1);
            if(check){
                max=mid;
                s=mid+1;
                
            }
            else {
                e=mid-1;
            }
        }
        return max;
    }
    public static boolean fxn(int row,int col,int mid,int[][] arr,int n,boolean[][] vis1){
        if(row<0 || col<0 || row>=n || col>=n || vis1[row][col]==true) return false;
        if(arr[row][col] < mid) return false;
        if(row==n-1 && col==n-1) return true;
        vis1[row][col]=true;

        boolean r=fxn(row,col+1,mid,arr,n,vis1);
        boolean d=fxn(row+1,col,mid,arr,n,vis1);
        boolean l=fxn(row,col-1,mid,arr,n,vis1);
        boolean u=fxn(row-1,col,mid,arr,n,vis1);
        return r || d || l || u;
    }
}
class pair{
    int f; int s;
    public pair(int f,int s){
        this.f=f;
        this.s=s;
    }
}