package LinkedListH;

class DoublyNode extends Node{
    DoublyNode prev;
    public DoublyNode(int data) {
        super(data);
        this.prev = null;
    }
}
public class DoublyLinkedList extends LinkedList {

    @Override
    public void insert(int data) {
        DoublyNode newNode = new DoublyNode(data);
        if (head == null) {
            head = newNode;
        } else {
            newNode.next = head;
            ((DoublyNode)head).prev = newNode;
            head = newNode;
        }

    }

    public void insertAtTail(int data) {
        DoublyNode newNode = new DoublyNode(data);
        DoublyNode current = (DoublyNode)head;
        if (head == null) {
            insert(data);
        } else {
            while (current.next != null) {
                current = (DoublyNode) current.next;
            }
            current.next = newNode;
            newNode.prev = current;
        }
    }

    @Override
    public void insert(int pos, int data) {
        DoublyNode newNode = new DoublyNode(data);
        if (pos == 1) {
            insert(data);
        } else {
            DoublyNode current = (DoublyNode) head;
            for (int i = 1; i < pos-1; i++) {
                current = (DoublyNode) current.next;
            }
            if (current.next != null) {
                ((DoublyNode) (current.next)).prev = newNode;
            }
            newNode.next = current.next;
            current.next = newNode;
            newNode.prev = current;
        }
    }

    public void reversePrint() {
        DoublyNode newNode = (DoublyNode) head;
        while (newNode.next != null) {
            newNode = (DoublyNode) newNode.next;
        }
        while (newNode != null) {
            System.out.print(newNode.data + " ");
            newNode = newNode.prev;
        }
    }

    public static void main(String[] args) {
        DoublyLinkedList myList = new DoublyLinkedList();
        myList.insert(1);
        myList.insert(2);
        myList.insert(3);
        myList.insert(4);
        myList.insert(5);
        myList.insertAtTail(6);
        myList.insert(3,3);
        myList.insert(4,4);
        System.out.println(myList);
        myList.reversePrint();

    }
}
