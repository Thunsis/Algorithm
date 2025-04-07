package LinkedListT;

/**
 * 链表抽象基类（支持泛型）
 * @param <E> 数据泛型类型
 * @param <T> 节点泛型类型，需继承自 Node<E, T>
 *
 * 核心职责：
 * 1. 定义链表通用操作方法
 * 2. 通过泛型支持不同类型链表的实现
 * 3. 提供基础方法实现（如打印、节点查找等）
 */
public abstract class LinkedList<E, T extends Node<E, T>> {
    /** 链表头节点引用 */
    protected T head;

    // ----------------- 通用方法 -----------------

    /**
     * 获取链表字符串表示（覆盖 Object.toString）
     * @return 链表元素按顺序拼接的字符串（空格分隔）
     * 时间复杂度：O(n) —— 遍历所有节点
     * 空间复杂度：O(n) —— 字符串存储所有数据
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        T current = head;
        while (current != null) {
            sb.append(current.data).append(" ");
            current = current.next;
        }
        return sb.toString().trim(); // 去除末尾空格
    }

    /**
     * 获取指定位置的节点
     * @param pos 节点位置（从1开始计数）
     * @return 目标位置节点
     * @throws IndexOutOfBoundsException 当位置超过链表长度时抛出
     * @throws IllegalArgumentException 当位置小于1时抛出
     * 时间复杂度：O(n) —— 最坏情况下需遍历到链表末尾
     * 空间复杂度：O(1) —— 仅使用临时变量
     */
    public T getNode(int pos) throws IndexOutOfBoundsException {
        if (pos < 1) throw new IllegalArgumentException("位置必须≥1");

        T current = head;
        for (int i = 1; i < pos && current != null; i++) {
            current = current.next;
        }

        if (current == null) {
            throw new IndexOutOfBoundsException("位置 " + pos + " 超过链表长度");
        }
        return current;
    }

    // ----------------- 抽象方法（需子类实现） -----------------

    /** 在链表头部插入数据 */
    public abstract void insert(E data);

    /**
     * 在指定位置插入数据
     * @param pos 插入位置（1 ≤ pos ≤ length+1）
     */
    public abstract void insert(int pos, E data);

    /** 删除指定位置节点 */
    public abstract void delete(int pos);

    // ----------------- 通用功能 -----------------

    /** 递归逆序打印链表元素 */
    public void reversePrint() {
        reversePrintHelper(head);
        System.out.println();
    }

    /** 递归逆序打印辅助方法
     * 时间复杂度：O(n) —— 递归遍历所有节点
     * 空间复杂度：O(n) —— 递归调用栈深度为n
     */
    private void reversePrintHelper(T node) {
        if (node == null) return;
        reversePrintHelper(node.next); // 先递归到末尾
        System.out.print(node.data + " "); // 回溯时打印
    }

    /** 迭代反转链表
     * 时间复杂度：O(n) —— 遍历所有节点
     * 空间复杂度：O(1) —— 仅使用几个临时变量
     */
    public void reverse() {
        T prev = null;
        T current = head;
        T next = null;
        while (current != null) {
            next = current.next;
            current.next = prev; // 反转指针
            prev = current;
            current = next;
        }
        head = prev; // 更新头节点
    }

    /** 递归反转链表入口方法 */
    public void reverseRecursion() {
        reverseRecursionHelper(head);
    }

    /** 递归反转核心逻辑
     * 时间复杂度：O(n) —— 递归遍历所有节点
     * 空间复杂度：O(n) —— 递归调用栈深度为n
     * */
    protected void reverseRecursionHelper(T current) {
        if (current == null || current.next == null) {
            head = current; // 终止条件：到达末尾
            return;
        }
        reverseRecursionHelper(current.next);
        current.next.next = current; // 反转指针
        current.next = null; // 断开原指针
    }
}