package LinkedListT;

/**
 * 单链表节点实现（支持泛型）
 *
 * 特性：
 * 1. 仅维护 next 指针
 * 2. 适用于单向链表结构
 */
public class SinglyNode<E> extends Node<E, SinglyNode<E>> {
    public SinglyNode(E data) {
        super(data); // 调用父类构造器
    }
}