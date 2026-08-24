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
    public int diameterOfBinaryTree(TreeNode root) {
        return diameter(root).D;
    }
    public Treeinfo diameter(TreeNode root){
        if(root==null) return new Treeinfo(0,0);

        Treeinfo left=diameter(root.left);
        Treeinfo right=diameter(root.right);

        int myht=Math.max(left.ht,right.ht)+1;
        int diam1=left.D; //left side max Diam
        int diam2=right.D;//right side max Diam
        int diam3=left.ht+right.ht;// curr node ke Lheight+Rheight

        int mydiam=Math.max(Math.max(diam1,diam2),diam3);
        Treeinfo myinfo=new Treeinfo(myht,mydiam);
        return myinfo;
    }
}
class Treeinfo{
    int ht;
    int D;
    Treeinfo(int ht ,int D){
        this.ht=ht;
        this.D=D;
    } 
}