/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode tempa=headA;
        ListNode tempb=headB;
        if(headA==null || headB==null )
        {
            return null;
        }
        while(tempa!=tempb)
        {
            tempa=(tempa==null)?headB:tempa.next;
            tempb=(tempb==null)?headA:tempb.next;
        }
        return tempa;
    }
}