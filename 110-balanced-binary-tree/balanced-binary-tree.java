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
    public boolean isBalanced(TreeNode root) {
        return dfsHeight(root) != -1;
    }
    public static int dfsHeight(TreeNode node){
        if(node==null) return 0;
        
        int Lheight=dfsHeight(node.left);
        if(Lheight==-1) return -1;
        int Rheight=dfsHeight(node.right);
        if(Rheight==-1) return -1;

        if(Math.abs(Lheight - Rheight)>1) return -1;
        return 1 + Math.max(Lheight,Rheight);
    }
}