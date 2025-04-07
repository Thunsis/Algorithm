package LinkedListT;

/**
 * 单链表实现（支持泛型）
 *
 * 特性：
 * 1. 仅维护 next 指针
 * 2. 插入/删除操作无需处理 prev 指针
 */
public class SinglyLinkedList<E> extends LinkedList<E, SinglyNode<E>> {

    /** 头部插入新节点
     * 时间复杂度：O(1) —— 直接修改头指针
     * 空间复杂度：O(1) —— 仅创建新节点
     */
    @Override
    public void insert(E data) {
        SinglyNode<E> newNode = new SinglyNode<E>(data);
        newNode.next = head; // 新节点指向原头节点
        head = newNode;     // 更新头节点
    }

    /**
     * 指定位置插入新节点
     * 实现策略：
     * 1. 位置1直接调用头部插入
     * 2. 其他位置找到前驱节点后插入
     * 时间复杂度：O(n) —— 需找到前驱节点
     * 空间复杂度：O(1) —— 仅创建新节点
     */
    @Override
    public void insert(int pos, E data) {
        SinglyNode<E> newNode = new SinglyNode<E>(data);
        if (pos == 1) {
            insert(data);
        } else {
            SinglyNode<E> prevNode = getNode(pos - 1); // 获取前驱节点
            newNode.next = prevNode.next; // 新节点指向原位置节点
            prevNode.next = newNode;       // 前驱节点指向新节点
        }
    }

    /**
     * 删除指定位置节点
     * 实现策略：
     * 1. 位置1直接后移头指针
     * 2. 其他位置找到前驱节点后跳过目标节点
     * 时间复杂度：O(n) —— 需找到前驱节点
     * 空间复杂度：O(1) —— 无额外空间使用
     */
    @Override
    public void delete(int pos) {
        if (pos == 1) {
            head = head.next; // 直接删除头节点
        } else {
            SinglyNode<E> prevNode = getNode(pos - 1);
            prevNode.next = prevNode.next.next; // 跳过被删除节点
        }
    }

    public static void main(String[] args) {
        SinglyLinkedList<Integer> myList = new SinglyLinkedList<>();
        myList.insert(1);
        myList.insert(2);
        myList.insert(3);
        myList.insert(4);
        myList.insert(5);
        System.out.println(myList);


        myList.insert(3,3);
        myList.insert(4,4);
        System.out.println(myList);

        myList.delete(5);

        System.out.println(myList);

        myList.reversePrint();
        myList.reverse();
        System.out.println(myList);
        myList.reverseRecursion();
        System.out.println(myList);
        myList.reverseByStack();
        System.out.println(myList);

    }
}