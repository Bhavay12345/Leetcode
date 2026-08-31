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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        //preorder starting element is Root
        //preorder --> Root L R.   [3,9,20,15,7]
        //Inorder  --> L Root R.   [9,3,15,20,7]
        //             L(subtree)<-- Root--> R(subtree)
        return create(preorder,inorder,0,preorder.length-1,0,inorder.length-1);
    }
    public static TreeNode create(int[] preorder, int[] inorder,int plo,int phi,int inlo,int inhi){
        if(plo > phi || inlo > inhi) return null;
        TreeNode root = new TreeNode(preorder[plo]);
        int idx=searchInInorder(inorder,preorder[plo]);

        root.left = create(preorder,inorder,plo+1,plo+idx-inlo,inlo,idx-1);
        root.right= create(preorder,inorder,plo+1+idx-inlo,phi,idx+1,inhi);
        return root;

    }
    public static int searchInInorder(int[] inorder,int target){
        for(int i=0;i<inorder.length;i++){
            if(inorder[i]==target) return i;
        }
        return -1;
    }
}