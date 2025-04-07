package LinkedListT;

/**
 * 链表节点基类（泛型抽象类）
 * @param <E> 数据泛型类型
 * @param <T> 节点泛型类型，必须继承自 Node<E, T>
 *
 * 设计目标：
 * 1. 提供基础链表节点结构
 * 2. 通过泛型支持不同类型链表的扩展
 * 3. 强制子类维护类型一致性
 */
public abstract class Node<E, T extends Node<E, T>> {
    /** 节点存储的数据 */
    public E data;
    /** 指向下一个节点的引用 */
    public T next;

    /**
     * 节点构造函数
     * @param data 节点存储的泛型数据
     */
    public Node(E data) {
        this.data = data;
        this.next = null;
    }
}