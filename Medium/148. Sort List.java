/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution148 {
    public ListNode merge(ListNode left,ListNode right)
    {
        ListNode d=new ListNode(-1);
        ListNode temp=d;
        while(left!=null && right!=null)
        {
            if(left.val<right.val)
            {
                temp.next=left;
                left=left.next;
            }
            else{
                temp.next=right;
                right=right.next;
            }
            temp=temp.next;
        }

        if(left!=null)
        {
            temp.next=left;

        }
        if(right!=null)
        {
            temp.next=right;
        }

        return d.next;

    }
    ListNode findmiddle(ListNode head)
    {
        ListNode slow=head;
        ListNode fast=head.next;
        while(fast!=null && fast.next!=null )
        {
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }
    public ListNode sortList(ListNode head) {
        if(head==null || head.next==null)
        {
            return head;
        }
        ListNode middle= findmiddle(head);
        ListNode right=middle.next;
        middle.next=null;
        ListNode left=head;

        left=sortList(left);
        right=sortList(right);
        return merge(left,right);
    }
}