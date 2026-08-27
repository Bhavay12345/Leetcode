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
    public List<Integer> rightSideView(TreeNode root) {
        TreeMap<Integer,Integer> map=new TreeMap<>();
        List<Integer> ans=new ArrayList<>();
        Queue<pair> q=new LinkedList<>();
        if(root==null) return ans;
        q.add(new pair(root,0));
        while(!q.isEmpty()){
            TreeNode CN = q.peek().node;
            int cr= q.remove().row;

            map.put(cr,CN.val);

            if(CN.left!=null) q.add(new pair(CN.left,cr+1));
            if(CN.right!=null) q.add(new pair(CN.right,cr+1));
        }
        for(int cr: map.keySet()){
            ans.add(map.get(cr));
        }
        return ans;
    }
}
class pair{
    TreeNode node; int row;
    public pair(TreeNode node, int row){
        this.node=node;
        this.row=row;
    }
}