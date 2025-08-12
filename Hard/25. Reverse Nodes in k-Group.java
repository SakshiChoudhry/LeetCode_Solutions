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
class Solution25 {
    public ListNode reverse(ListNode s,ListNode e)
    {
        ListNode te=s;
        ListNode prev=null;
        while(te!=e)
        {
            ListNode x=te.next;
            te.next=prev;
            prev=te;
            te=x;
        }
        return prev;
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode curr=head;
        ListNode newhead=null;
        ListNode prevtail=null;
        while(curr!=null)
        {
            ListNode kth=curr;
            for(int i =1;i<k && kth!=null;i++)
            {
                kth=kth.next;
            }
            if(kth==null)break;
            ListNode newgroup=kth.next;
            ListNode revhead=reverse(curr,newgroup);
            if(prevtail!=null)
            {
                prevtail.next=revhead;
            }
            else
            {
                newhead=revhead;
            }
            curr.next=newgroup;
            prevtail=curr;
            curr=newgroup;
        }
        return newhead!=null?newhead:head;
    }
}