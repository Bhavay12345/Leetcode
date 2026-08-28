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
    public TreeNode sortedArrayToBST(int[] nums) {
        return makeTree(nums,0,nums.length-1);
    }
    public static TreeNode makeTree(int[] nums,int low,int high){

        if(low > high) return null; //base case

        int mid = low + (high - low) / 2; //make mid root first
        TreeNode root = new TreeNode(nums[mid]);
        root.left = makeTree(nums,low,mid-1); // going left
        root.right = makeTree(nums,mid+1,high); // going right

        return root;
    }
}