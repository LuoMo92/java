package com.luomo.java.list;

/**
 * 单链表
 *
 * @author LiuMei
 * @date 2019/5/23 0023
 */
public class LinkList<T> implements List<T> {

    /**
     * 头结点
     */
    private Node<T> head;

    /**
     * 线性表的长度
     */
    private int size;

    private class Node<T> {
        T data;
        Node<T> next;

        public Node(T data, Node<T> next) {
            this.data = data;
            this.next = next;
        }
    }

    public LinkList() {
        head = new Node(null, null);
        this.size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    public Node getNode(int index) throws Exception {
        Node node = head;
        if (index > size) {
            throw new Exception("参数错误");
        }
        int j = 1;
        while (node != null && j <= index) {
            node = node.next;
            ++j;
        }
        return node;
    }

    @Override
    public void insert(int index, T data) throws Exception {
        if (index < 1 || index > size + 1) {
            throw new Exception("参数错误！");
        }
        Node node = getNode(index - 1);
        Node newNode = new Node(data, node.next);
        node.next = newNode;
        size++;
    }

    @Override
    public void delete(int index) throws Exception {
        Node node = getNode(index - 1);
        node.next = node.next.next;
        size--;
    }

    @Override
    public T get(int index) throws Exception {
        return (T) getNode(index).data;
    }

    /**
     * 头插法
     *
     * @param n
     */
    public void createListHead(int n) {
        size = n;
        for (int i = 0; i < n; i++) {
            Node node = new Node(i + 1, head.next);
            head.next = node;
        }
    }

    /**
     * 尾插法
     *
     * @param n
     */
    public void createListTail(int n) {
        size = n;
        Node last = head;
        for (int i = 0; i < n; i++) {
            Node node = new Node(i + 1, null);
            last.next = node;
            last = node;
        }
    }

    public T getMidNode() {
        Node search, mid;
        mid = search = head;
        while (search.next != null) {
            mid = mid.next;
            //search移动的速度是mid的2倍
            if (search.next.next != null) {
                search = search.next.next;
            } else {
                search = search.next;
            }
        }
        return (T) mid.data;
    }
}
