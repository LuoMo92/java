package com.luomo.java.list;

/**
 * 循环链表
 *
 * @author LiuMei
 * @date 2019/5/23 0023
 */
public class CircleLinkList<T> implements List<T> {

    /**
     * 头结点
     */
    public Node head;

    /**
     * 当前节点对象
     */
    private Node current;

    /**
     * 线性表的长度
     */
    public int size;

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 定位函数
     * <p>
     * 实现当前操作对象的前一个节点，也就是让当前节点对象定位到要操作的节点的前一个节点
     *
     * @param index
     * @throws Exception
     */
    public void index(int index) throws Exception {

        if (index < 0 || index > size) {
            throw new Exception("参数错误！");
        }
        /**
         * 头结点
         *
         */
        if (index == 0) {
            return;
        }
        current = head.next;
        int j = 0;
        while (current != head && j < index) {
            current = current.next;
            j++;
        }

    }

    @Override
    public void insert(int index, T data) throws Exception {

        if (index < 0 || index > size) {
            throw new Exception("参数错误！");
        }
        index(index);
        current.next = new Node(data, current.next);
        size++;
    }

    @Override
    public void delete(int index) throws Exception {

        if (isEmpty()) {
            throw new Exception("链表为空，无法删除！");
        }

        if (index < 0 || index > size) {
            throw new Exception("参数错误！");
        }
        //定位要操作节点的前一个节点对象
        index(index - 1);
        current.next = current.next.next;
        size--;
    }

    @Override
    public T get(int index) throws Exception {
        if (index < -1 || index > size - 1) {
            throw new Exception("参数错误！");
        }
        index(index);
        return (T) current.data;
    }

    public class Node<T> {
        T data;
        Node<T> next;

        public Node(T data, Node<T> next) {
            this.data = data;
            this.next = next;
        }
    }

    public CircleLinkList() {
        this.head = current = new Node(null, null);
        this.size = 0;
        this.head.next = this.head;
    }

}
