/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/
 /*we will proceed this question in 3 steps
 step 1: create duplicate nodes right next to each node
 1->2->3->4 will become 1->1'->2->2'->3->3'->4->4'
step 2 : for each duplicate node point its random to the originals
node random ka next because that will be the duplicate node which is
exactly what we need to point to
Step 3: extract the duplicate list by rearranging pointers
*/
class Solution138 {
    public Node copyRandomList(Node head) {
        Node temp=head;
        //step 1:
        while(temp!=null)
        {
            Node copy=new Node(temp.val);
            copy.next=temp.next;
            temp.next=copy;
            temp=temp.next.next;
        }
        //step 2:
        temp=head;
        while(temp!=null)
        {
            Node r=temp.next;
            if(temp.random!=null)
            {
                r.random=temp.random.next;
            }
            else{
                r.random=null;
            }
            temp=temp.next.next;
        }
        //step 3:
        Node dummy=new Node(-1);
        Node r=dummy;
        temp=head;
        while(temp!=null)
        {
            r.next=temp.next;
            temp.next=temp.next.next;
            r=r.next;
            temp=temp.next;
        }
        return dummy.next;
    }
}