class Solution {
    public boolean predictTheWinner(int[] nums) {
        int n=nums.length;
        return fxn(0,n-1,0,0,1,nums);
    }
    public static boolean fxn(int l,int r,int p1,int p2,int chance,int[] nums){
        if(l>r){
            if(p1>=p2) return true;
            else return false;
        }
        boolean player1=false;
        boolean player2=false;
        if(chance==1){
            boolean path1 = fxn(l+1,r,p1+nums[l],p2,0,nums); 
            boolean path2 = fxn(l,r-1,p1+nums[r],p2,0,nums); 
            player1=path1 || path2;
        }
        else{
            boolean path1 = fxn(l+1,r,p1,p2+nums[l],1,nums);
            boolean path2 = fxn(l,r-1,p1,p2+nums[r],1,nums);
            player2 = path1 && path2;
        }
        return player1 || player2;
    }
}