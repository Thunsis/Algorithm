package LinkedListT;

/**
 * 链表节点基类（泛型抽象类）
 * @param <T> 节点类型，必须继承自 Node<T>（递归泛型约束）
 *
 * 设计目标：
 * 1. 提供基础链表节点结构
 * 2. 通过泛型支持不同类型链表的扩展
 * 3. 强制子类维护类型一致性
 */
public abstract class Node<T extends Node<T>> {
    /** 节点存储的数据 */
    public int data;

    /** 指向下一个节点的引用（类型由子类决定） */
    public T next;

    /**
     * 节点构造函数
     * @param data 节点存储的整型数据
     */
    public Node(int data) {
        this.data = data;
        this.next = null; // 初始化时无后继节点
    }
}