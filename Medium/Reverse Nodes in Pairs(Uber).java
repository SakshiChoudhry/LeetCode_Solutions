class Node
{
    int data;
    Node next;
    Node(){}
    Node(int val)
    {
        this.data=val;
    }
    Node(int val,Node next)
    {
        this.data=val;
        this.next=next;
    }
}
public class ReverseListInPairs {
    public Node pairs(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node newh = head.next;
        Node curr = head;
        Node prev = null;
        while (curr != null && curr.next != null) {
            Node nextpair = curr.next.next;
            Node second = curr.next;
            second.next = curr;
            curr.next = nextpair;

            if (prev != null) {
                prev.next = second;
            }
            prev = curr;
            curr = nextpair;
        }
        return newh;
    }
    public static void printlist(Node head)
    {
        Node temp=head;
        while(temp!=null)
        {
            System.out.print(temp.data+ " ");
            temp=temp.next;
        }
    }
    public static void main(String args[])
    {
        Node x=new Node(1);
        x.next=new Node(2);
        x.next.next=new Node(3);
        x.next.next.next=new Node(4);
        x.next.next.next.next=new Node(5);
        ReverseListInPairs o=new ReverseListInPairs();
        printlist(o.pairs(x));
    }
}
