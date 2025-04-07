package LinkedListT;

/**
 * 双向链表实现类
 *
 * 特性：
 * 1. 需要维护 prev 和 next 指针
 * 2. 所有修改操作必须同时维护双向指针，需要单独实现
 */
public class DoublyLinkedList<E> extends LinkedList<E, DoublyNode<E>> {

    // ----------------- 核心操作 -----------------

    /** 头部插入新节点（需维护原头节点的 prev）
     * 时间复杂度：O(1) —— 直接修改头指针
     * 空间复杂度：O(1) —— 仅创建新节点
     */
    @Override
    public void insert(E data) {
        DoublyNode<E> newNode = new DoublyNode<E>(data);
        // 需要考虑next为null时next的prev没法赋值的问题
        if (head != null) {
            head.prev = newNode; // 原头节点前驱指向新节点
        }
        newNode.next = head; // 新节点后继指向原头节点
        head = newNode;      // 更新头节点
    }

    /**
     * 指定位置插入新节点
     * 关键操作：
     * 1. 维护新节点与前后节点的双向指针
     * 2. 处理插入末尾的特殊情况
     * 时间复杂度：O(n) —— 需找到前驱节点
     * 空间复杂度：O(1) —— 仅创建新节点
     */
    @Override
    public void insert(int pos, E data) {
        DoublyNode<E> newNode = new DoublyNode<E>(data);
        if (pos == 1) {
            insert(data);
        } else {
            DoublyNode<E> prevNode = getNode(pos - 1);
            // 维护新节点指针
            newNode.prev = prevNode;
            newNode.next = prevNode.next;

            // 维护后继节点指针（如果存在）
            // 需要考虑next为null时next的prev没法赋值的问题
            if (prevNode.next != null) {
                prevNode.next.prev = newNode;
            }

            // 维护前驱节点指针
            prevNode.next = newNode;
        }
    }

    /**
     * 链表尾部插入新节点
     * 实现策略：
     * 1. 找到当前尾节点
     * 2. 维护新节点与前驱的双向指针
     * 时间复杂度：O(n) —— 需遍历到链表末尾
     * 空间复杂度：O(1) —— 仅创建新节点
     */
    public void insertAtTail(E data) {
        DoublyNode<E> newNode = new DoublyNode<E>(data);
        if (head == null) {
            head = newNode;
        } else {
            DoublyNode<E> current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
            newNode.prev = current;
        }
    }

    /**
     * 删除指定位置节点
     * 关键操作：
     * 1. 维护被删除节点前后节点的指针
     * 2. 处理删除头节点和尾节点的特殊情况
     * 时间复杂度：O(n) —— 需找到前驱节点
     * 空间复杂度：O(1) —— 无额外空间使用
     */
    @Override
    public void delete(int pos) {
        if (pos == 1) {
            if (head.next != null) {
                head.next.prev = null; // 清除新头节点的前驱
            }
            head = head.next; // 更新头节点
        } else {
            DoublyNode<E> prevNode = getNode(pos - 1);
            if (prevNode.next != null) {
                // 维护后继节点的前驱指针
                if (prevNode.next.next != null) {
                    prevNode.next.next.prev = prevNode;
                }
                // 跳过被删除节点
                prevNode.next = prevNode.next.next;
            }
        }
    }

    // ----------------- 增强功能 -----------------

    /** 反向遍历打印（利用双向特性）
     * 时间复杂度：O(n) —— 两次遍历（找尾部+反向遍历）
     * 空间复杂度：O(1) —— 仅使用临时变量
     */
    @Override
    public void reversePrint() {
        if (head == null) return;

        // 定位到尾节点
        DoublyNode<E> current = head;
        while (current.next != null) {
            current = current.next;
        }

        // 反向遍历打印
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.prev;
        }
        System.out.println();
    }

    /**
     * 迭代反转链表
     * 算法步骤：
     * 1. 交换每个节点的 prev 和 next 指针
     * 2. 遍历完成后更新头节点
     * 时间复杂度：O(n) —— 遍历所有节点
     * 空间复杂度：O(1) —— 仅使用临时变量
     */
    @Override
    public void reverse() {
        DoublyNode<E> current = head;
        DoublyNode<E> temp = null;

        while (current != null) {
            // 交换前后指针
            temp = current.prev;
            current.prev = current.next;
            current.next = temp;

            // 移动到原下一个节点（现前驱节点）
            current = current.prev;
        }

        // 更新头节点（temp保存原末节点的前驱，即新头节点）
        if (temp != null) {
            head = temp.prev;
        }
    }

    /**
     * 递归反转链表（优化版）
     * 改进点：
     * 1. 递归过程中直接维护 prev 指针
     * 2. 避免后续遍历修正
     */
    @Override
    public void reverseRecursion() {
        reverseRecursionHelper(head, null);
    }

    /*
     * 时间复杂度：O(n) —— 递归遍历所有节点
     * 空间复杂度：O(n) —— 递归调用栈深度为n
     */
    private void reverseRecursionHelper(DoublyNode<E> current, DoublyNode<E> prev) {
        if (current == null) {
            head = prev; // 终止条件：到达末尾，更新头节点
            return;
        }
        DoublyNode<E> next = current.next;
        current.next = prev; // 反转后继指针
        current.prev = next; // 反转前驱指针（指向原下一个节点）
        reverseRecursionHelper(next, current); // 递归处理下一个节点
    }

    public static void main(String[] args) {
        DoublyLinkedList myList = new DoublyLinkedList();
        myList.insert(1);
        myList.insert(2);
        myList.insert(3);
        myList.insert(4);
        myList.insert(5);
        System.out.println(myList);

        myList.insertAtTail(6);
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



    }
}