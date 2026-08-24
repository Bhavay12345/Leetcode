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
    public int maxDepth(TreeNode root) {
        return fxn(root);
    }
    public static int fxn(TreeNode node){
        if(node==null) return 0;
        int left=fxn(node.left);
        int right=fxn(node.right);
        return 1+Math.max(left,right);
    }
}