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
class Solution1008 {
    public TreeNode bstFromPreorder(int[] preorder) {
        int n=preorder.length;
        Stack<TreeNode> s=new  Stack<>();
        TreeNode root=new TreeNode(preorder[0]);
        s.push(root);
        TreeNode curr=root;
        TreeNode temp=null;
        for(int i=1;i<n;i++)
        {
            TreeNode child=new TreeNode(preorder[i]);
            if(child.val<s.peek().val)
            {
                curr.left=child;
                curr=child;
                s.push(child);
            }
            else
            {
                while(!s.isEmpty() && child.val>s.peek().val)
                {
                    temp=s.peek();
                    s.pop();
                }
                temp.right=child;
                curr=child;
                s.push(child);
            }
        }
        return root;
    }
}