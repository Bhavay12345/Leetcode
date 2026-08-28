/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        Deque<pair> q=new ArrayDeque<>();
        q.add(new pair(root,0));
        int max=0;
        while(!q.isEmpty()){
            int st=q.peekFirst().num; // for width calculation
            int en=q.peekLast().num;
            max=Math.max(max,en-st+1);
            int currLevel=q.size();
            for(int i=0;i<currLevel;i++){
                TreeNode CN=q.peekFirst().node;// next node buildup
                int currNum=q.removeFirst().num;
                if(CN.left!=null) q.add(new pair(CN.left,2*currNum+1));
                if(CN.right!=null) q.add(new pair(CN.right,2*currNum+2));
            }
        }
        return max;
    }
}
class pair{
    TreeNode node;
    int num;
    public pair(TreeNode node,int num){
        this.node=node;
        this.num=num;
    }
}