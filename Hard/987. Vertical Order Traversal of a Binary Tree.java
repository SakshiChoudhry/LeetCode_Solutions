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
        List<List<Integer>>ans=new ArrayList<>();
        Map<Integer, Map<Integer, List<Integer>>> nodes=new TreeMap<>();
        Queue<Pair<TreeNode,Pair<Integer,Integer>>> q=new LinkedList<>();
        q.add(new Pair<>(root,new Pair<>(0,0)));
        while(!q.isEmpty())
        {
            Pair<TreeNode,Pair<Integer,Integer>> p=q.poll();
            TreeNode temp=p.getKey();
            int x=p.getValue().getKey();
            int y=p.getValue().getValue();
            nodes.computeIfAbsent(x,k->new TreeMap<>())
                    .computeIfAbsent(y,k->new ArrayList<>())
                    .add(temp.val);
            if(temp.left!=null)
            {
                q.add(new Pair<>(temp.left,new Pair<>(x-1,y+1)));
            }
            if(temp.right!=null)
            {
                q.add(new Pair<>(temp.right,new Pair<>(x+1,y+1)));
            }
        }
        for(Map<Integer,List<Integer>> entry:nodes.values())
        {
            List<Integer> col=new ArrayList<>();
            for(List<Integer> set:entry.values())
            {
                Collections.sort(set);
                col.addAll(set);
            }
            ans.add(col);
        }
        return ans;
    }
}