package LinkedListT;

/**
 * 单链表节点实现（继承自泛型节点基类）
 *
 * 特性：
 * 1. 仅维护 next 指针
 * 2. 适用于单向链表结构
 */
public class SinglyNode extends Node<SinglyNode> {
    /**
     * 单链表节点构造函数
     * @param data 节点存储的整型数据
     */
    public SinglyNode(int data) {
        super(data); // 调用父类构造器初始化数据域
    }
}