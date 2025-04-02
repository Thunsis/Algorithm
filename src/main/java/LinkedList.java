class Node {
    int data;
    Node next;
    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}
public class LinkedList {

    private Node head;

    public void insert(int x) { // pass in the pointer of head, not actually the head node
        Node temp = new Node(x);
        temp.next = head;
        head = temp;
    }

    public void insert(int pos, int x) { // pass in the pointer of head, not actually the head node
        Node temp1 = new Node(x);
        if (pos == 1) {
            temp1.next = head;
            head = temp1;
        } else {
            Node temp2 = head;
            for ( int i = 0; i < pos - 2; i++ ) {
                temp2 = temp2.next; // 找到第pos-1个
            }
            temp1.next = temp2.next; // new node -> next = pos node
            temp2.next = temp1; // pos-1 node -> next = new node
        }
    }


    public void delete(int pos) { // pass in the pointer of head, not actually the head node
        Node temp = head;
        if (pos == 1) {
            head = temp.next;
        } else {
            for ( int i = 0; i < pos - 2; i++ ) {
                temp = temp.next; // 找到第pos-1个
            }
            temp.next = temp.next.next; // pos node -> next = pos+1 node
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

    public void reversePrint(Node head) {
        while (temp != null) {
            System.out.print(temp.data + " ");
            reversePrint(temp.next);
        }
    }


    @Override
    public String toString() {
        Node temp = head; // 临时节点遍历得到当前尾节点，不直接用head是不想失去头节点的引用
        String ret = "";
        while (temp != null) {
            ret = ret + " " + temp.data;
            temp = temp.next;
        }
        return "List is:" + ret;
    }

    public static void main(String[] args)
    {
        LinkedList list = new LinkedList();
        list.head = null; // 头节点

        list.insert(1,4);
        list.insert(2,5);
        list.insert(1,3);
        list.insert(2,9);

        System.out.println(list);

        list.delete(2);

        System.out.println(list);

        list.reverse();

        System.out.println(list);
//        list.reversePrint(list.head);




    }
}