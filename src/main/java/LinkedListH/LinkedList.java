package LinkedListH;

class Node {
    int data;
    Node next;
    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}
public class LinkedList {

    protected Node head = null;

    public void insert(int data) { // pass in the pointer of head, not actually the head node
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    public void insert(int pos, int data) { // pass in the pointer of head, not actually the head node
        Node newNode = new Node(data);
        if (pos == 1) {
            newNode.next = head;
            head = newNode;
        } else {
            Node current = head;
            for ( int i = 1; i < pos - 1; i++ ) {
                current = current.next; // 找到第pos-1个
            }
            newNode.next = current.next; // new node -> next = pos node
            current.next = newNode; // pos-1 node -> next = new node
        }
    }


    public void delete(int pos) { // pass in the pointer of head, not actually the head node
        Node current = head;
        if (pos == 1) {
            head = current.next;
        } else {
            for ( int i = 1; i < pos - 1; i++ ) {
                current = current.next; // 找到第pos-1个
            }
            current.next = current.next.next; // pos node -> next = pos+1 node
        }
    }

    public void reverse() {
        Node prev = null;
        Node current = head;
        Node next = null;
        while (current != null) {
            next = current.next; // Store next node
            current.next = prev; // Reverse current node's pointer
            prev = current; // Move pointers one position ahead
            current = next;
        }
        head = prev; // Update head to the new first node
    }
    public void reverseRecursion() {
        reverseRecursionHelper(head);
    }

    public void reverseRecursionHelper(Node p) {
        if ( p == null || p.next == null ) {
            head = p;
            return;
        }
        reverseRecursionHelper(p.next);
        p.next.next = p;
        p.next = null;
    }

    public void reversePrint() {
        reversePrintHelper(head);
        System.out.println();
    }

    public void reversePrintHelper(Node p) {
        if (p == null) {
            return;
        }
        reversePrintHelper((p.next));
        System.out.print(p.data + " ");
    }


    @Override
    public String toString() {
        Node current = head; // 临时节点遍历得到当前尾节点，不直接用head是不想失去头节点的引用
        String ret = "";
        while (current != null) {
            ret = ret + current.data + " ";
            current = current.next;
        }
        return ret;
    }

    public static void main(String[] args)
    {
        LinkedList list = new LinkedList();
        list.insert(1,4);
        list.insert(2,5);
        list.insert(1,3);
        list.insert(2,9);

        System.out.println(list);

        list.delete(2);

        System.out.println(list);

        list.reverse();

        System.out.println(list);
        list.reversePrint();
        list.reverseRecursion();
        System.out.println(list);




    }
}