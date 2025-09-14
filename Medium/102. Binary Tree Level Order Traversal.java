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
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans=new ArrayList<>();
        Queue<TreeNode> q=new LinkedList<>();
        if(root==null)
        {
            return ans;
        }
        q.add(root);
        while(!q.isEmpty())
        {
            int size=q.size();
            List<Integer> s=new ArrayList<>();
            for(int i =0;i<size;i++)
            {
                TreeNode x=q.poll();
                s.add(x.val);
                if(x.left!=null)
                {
                    q.add(x.left);
                }
                if(x.right!=null)
                {
                    q.add(x.right);
                }
            }

            ans.add(s);
        }
        return ans;
    }
}
