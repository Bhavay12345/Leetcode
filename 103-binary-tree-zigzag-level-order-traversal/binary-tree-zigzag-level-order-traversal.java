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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans= new ArrayList<>();
        List<Integer> ll=new ArrayList<>();
        Queue<TreeNode> qu= new LinkedList<>();
        if(root==null) return ans;
        qu.add(root);
        qu.add(null);
        int level=1;
        while(!qu.isEmpty()){
            TreeNode CN=qu.remove();
            if(CN==null){
                if(level%2==0){ // even level ko reversed dalo ans m
                    Collections.reverse(ll);
                }
                ans.add(ll);
                ll=new ArrayList<>();
                if(qu.isEmpty()) break;
                else qu.add(null);
                level++;
            }
            else{
                ll.add(CN.val);
                if(CN.left!=null)  qu.add(CN.left);
                if(CN.right!=null) qu.add(CN.right);
            }
        }
        return ans;
    }
}