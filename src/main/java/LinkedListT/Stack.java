package LinkedListT;

/**
 * 栈实现（基于单链表）
 * @param <E> 数据类型
 */
public class Stack<E> extends SinglyLinkedList<E> {
    public void push(E data) {
        super.insert(data);
    }

    public void pop() {
        super.delete(1);
    }

    public E top() {
        return head.data;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public static void main(String[] args) {
        Stack<Integer> myStack = new Stack<>();
        myStack.push(1);
        myStack.push(2);
        myStack.push(3);
//        myStack.push("b");

        System.out.println(myStack);
        myStack.pop();
        System.out.println(myStack);
        myStack.isEmpty();
        System.out.println(myStack.isEmpty());
        System.out.println(myStack.top());



    }
}
