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
    public TreeNode reverseOddLevels(TreeNode root) {
        // if(root.left==null || root.)
        return rev(root,root.left,root.right,1);
    }
    public static TreeNode rev(TreeNode root,TreeNode p,TreeNode q,int level){
        if(p==null || q==null) return root;
        if(level%2 == 1){ // odd level
            int temp = p.val;
            p.val = q.val;
            q.val = temp;
        }
        rev(root,p.left,q.right,level+1);
        rev(root,p.right,q.left,level+1);

        return root;
    }
}