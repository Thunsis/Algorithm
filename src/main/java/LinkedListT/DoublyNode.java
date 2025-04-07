package LinkedListT;

/**
 * 双向链表节点实现（支持泛型）
 *
 * 特性：
 * 1. 新增 prev 指向前驱节点
 * 2. 适用于双向链表结构
 */
public class DoublyNode<E> extends Node<E, DoublyNode<E>> {
    /** 指向前驱节点的引用 */
    public DoublyNode<E> prev;

    /**
     * 双向链表节点构造函数
     * @param data 节点存储的整型数据
     */
    public DoublyNode(E data) {
        super(data); // 初始化数据域和 next 指针
        this.prev = null; // 初始化时无前驱节点
    }
}
