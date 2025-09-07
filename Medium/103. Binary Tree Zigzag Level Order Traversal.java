import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

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
class Solution103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Queue<TreeNode> q=new LinkedList<>();
        List<List<Integer>> ans=new ArrayList<>();
        if(root==null)
        {
            return ans;
        }
        q.add(root);
        int level =0;
        while(!q.isEmpty())
        {
            int size=q.size();
            List<Integer> l=new ArrayList<>();
            for(int i =0;i<size;i++)
            {
                TreeNode x=q.poll();
                l.add(x.val);
                if(x.left!=null)
                {
                    q.offer(x.left);
                }
                if(x.right!=null)
                {
                    q.offer(x.right);
                }
            }
            if(level%2!=0)
            {
                Collections.reverse(l);
            }

            ans.add(l);
            level++;

        }
        return ans;
    }
}