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
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        TreeMap < Integer,TreeMap < Integer, PriorityQueue<Integer>>> map=new TreeMap<>();
    //for cc can acces in order ,for multi cr for one cc in order ,for same cr,cr PQ give min val first
        Queue<tri> q=new LinkedList<>();
        q.add(new tri(root,0,0));
        while(!q.isEmpty()){
            TreeNode CN=q.peek().node;
            int cr=q.peek().cr;
            int cc=q.remove().cc;
            //store data
            map.putIfAbsent(cc,new TreeMap<>());
            map.get(cc).putIfAbsent(cr, new PriorityQueue<>());
            map.get(cc).get(cr).add(CN.val);

            if(CN.left!=null) q.add(new tri(CN.left,cr+1,cc-1));
            if(CN.right!=null) q.add(new tri(CN.right,cr+1,cc+1));

        }
        //fetching values first with order cc then cr then val
        List<List<Integer>> ans=new ArrayList<>();
        for(int cc : map.keySet()){ // picking each col(vertical levels)
            // we use treemap so that it piched up in ASC -ve --> +ve
            TreeMap<Integer,PriorityQueue<Integer>> row = map.get(cc);
            //append whole treemap of that cc so we can use it
            List<Integer> col=new ArrayList<>();
            for(int cr : row.keySet()){
                PriorityQueue<Integer> pq=row.get(cr);
                //append whole PriorityQueue of that cr so we can use it
                while(!pq.isEmpty()){
                    col.add(pq.poll());
                }
            }
            ans.add(col);
        }
        return ans;
    }  
}
class tri{
    TreeNode node;
    int cr;
    int cc;
    public tri(TreeNode node,int cr,int cc){
        this.node=node;
        this.cr=cr;
        this.cc=cc;
    }
}