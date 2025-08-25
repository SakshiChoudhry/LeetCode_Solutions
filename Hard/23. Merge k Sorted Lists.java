import java.util.PriorityQueue;

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
class Solution23 {
    public ListNode mergeKLists(ListNode[] lists) {
        int n =lists.length;
        PriorityQueue<ListNode> p=new PriorityQueue<>((a, b)->a.val-b.val);
        for(int i =0;i<n;i++)
        {
            if(lists[i]!=null)
            {
                p.offer(lists[i]);
            }
        }
        ListNode dum=new ListNode();
        ListNode temp=dum;
        while(!p.isEmpty())
        {
            ListNode min=p.poll();
            temp.next=min;
            temp=temp.next;
            if(min.next!=null)
            {
                p.offer(min.next);
            }
        }
        return dum.next;
    }
}