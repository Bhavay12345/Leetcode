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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return create(postorder,inorder,0,postorder.length-1,0,inorder.length-1);
    }
    public TreeNode create(int[] post,int[] in,int polo,int pohi,int inlo,int inhi){
        if(polo > pohi || inlo > inhi) return null;

        TreeNode root = new TreeNode(post[pohi]);
        int idx = searchInInorder(in,post[pohi]);
        int INORDER_Lside = idx-inlo; 
        root.left = create(post,in, polo , polo+INORDER_Lside-1 , inlo , idx-1 );
        root.right = create(post,in, polo+INORDER_Lside , pohi-1 , idx+1 , inhi );
        return root;
    }
    public static int searchInInorder(int[] inorder,int target){
        for(int i=0;i<inorder.length;i++){
            if(inorder[i]==target) return i;
        }
        return -1;
    }
}