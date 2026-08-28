/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        HashMap<TreeNode,TreeNode> parentDATA=new HashMap<>();
        parent(root,parentDATA);
        HashMap<TreeNode,Boolean> vis=new HashMap<>();
        Queue<TreeNode> q=new LinkedList<>();
        q.add(target);
        vis.put(target,true);
        int currDiss=0;
        while(!q.isEmpty()){
            int qsize=q.size();
            if(currDiss==k) break;
            currDiss++;
            for(int i=0;i<qsize;i++){ //BST
                TreeNode CN=q.remove();
                if(CN.left!=null && vis.get(CN.left)==null){
                    q.add(CN.left);
                    vis.put(CN.left,true);
                }
                if(CN.right!=null && vis.get(CN.right)==null){
                    q.add(CN.right);
                    vis.put(CN.right,true);
                }
                if(parentDATA.get(CN)!=null && vis.get(parentDATA.get(CN))==null){
                    q.add(parentDATA.get(CN));
                    vis.put(parentDATA.get(CN),true);
                }
            }
        }
        List<Integer> ans=new ArrayList<>();
        while(!q.isEmpty()){
            TreeNode CN=q.poll();
            ans.add(CN.val);
        }
        return ans;
    }
    public static void parent(TreeNode root,HashMap<TreeNode,TreeNode> map){
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            TreeNode CN=q.remove();
            if(CN.left!=null){
                map.put(CN.left,CN);
                q.add(CN.left);
            }
            if(CN.right!=null){
                map.put(CN.right,CN);
                q.add(CN.right);
            }
        }
    }
}