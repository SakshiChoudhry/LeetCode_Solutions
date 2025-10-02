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
class BSTIterator
{
    Stack<TreeNode> s;
    boolean reverse;
    BSTIterator(TreeNode root, boolean reverse)
    {
        s=new Stack<>();
        this.reverse=reverse;
        pushAll(root);
    }
    boolean hasNext()
    {
        return !s.isEmpty();
    }
    int next()
    {
        TreeNode n=s.pop();
        if(!reverse)
        {
            pushAll(n.right);
        }
        else
        {
            pushAll(n.left);
        }
        return n.val;
    }
    public void pushAll(TreeNode root)
    {
        while(root!=null)
        {
            s.push(root);
            if(reverse)
            {
                root=root.right;
            }
            else
            {
                root=root.left;
            }
        }
    }
}
class Solution653 {
    public boolean findTarget(TreeNode root, int k) {
        if(root==null)
        {
            return false;
        }
        BSTIterator l=new BSTIterator(root,false);
        BSTIterator r=new BSTIterator(root,true);
        int i =l.next();
        int j=r.next();
        while(i<j)
        {
            if(i+j==k)
            {
                return true;
            }
            else if(i+j<k)
            {
                i=l.next();
            }
            else {
                j=r.next();
            }
        }
        return false;
    }
}