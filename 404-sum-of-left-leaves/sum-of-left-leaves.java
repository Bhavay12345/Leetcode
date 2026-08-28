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
    static int sum;
    public int sumOfLeftLeaves(TreeNode root) {
        sum=0;
        summ(root,false);
        return sum;  
    }
    public void summ(TreeNode root,boolean isLeft){
        if(root.left==null && root.right==null){
            if(isLeft) sum+=root.val;
            return;
        }
        if(root.left!=null) summ(root.left,true);
        if(root.right!=null) summ(root.right,false);
    }
}