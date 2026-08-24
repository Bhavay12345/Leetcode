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
    static int maxi;
    public int maxPathSum(TreeNode root) {
        maxi=Integer.MIN_VALUE;
        fxn(root);
        return maxi;
    }
    public static int fxn(TreeNode node){
        if(node == null) return 0;
        //in que there is not compulsory leaf to leaf
        int left = Math.max(0,fxn(node.left)) ;
        //if L or R give -ve so just not take it by taking it as 0
        int right = Math.max(0,fxn(node.right)) ;
        
        maxi=Math.max( node.val+left+right , maxi );
        return node.val + Math.max( left,right );
    }
}