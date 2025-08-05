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
class Solution234 {
    public ListNode reverselist(ListNode head)
    {
        ListNode temp=head;
        ListNode prev=null;
        while(temp!=null)
        {
            ListNode curr=temp.next;
            temp.next=prev;
            prev=temp;
            temp=curr;
        }
        return prev;
    }
    public boolean isPalindrome(ListNode head) {
        ListNode slow=head;
        ListNode fast=head;
        while(fast!=null && fast.next!=null && slow!=null)
        {
            slow=slow.next;
            fast=fast.next.next;
        }
        ListNode rev= reverselist(slow);
        ListNode s= head;
        while(rev!=null)
        {
            if(s.val!=rev.val)
            {
                return false;
            }
            s=s.next;
            rev=rev.next;
        }
        return true;
    }
}
