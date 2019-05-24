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

    @Override
    public int size() {
        Node temp = head;
        int size = 0;
        while (temp.next != head) {
            size++;
            temp = temp.next;
        }
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override
    public void insert(int index, T data) throws Exception {
        if (index < 1) {
            throw new Exception("参数错误！");
        }
        Node node = new Node();
        node.data = data;
        if (head.next == head) {
            //第一次插入元素
            head.next = node;
            node.next = head;
        } else {
            Node temp = head;
            int count = 0;
            while (temp.next != head) {
                count++;
                temp = temp.next;
                if (count == index - 1) {
                    node.next = temp.next;
                    temp.next = node;
                }
            }
        }
    }

    @Override
    public void delete(int index) throws Exception {

        if (isEmpty()) {
            throw new Exception("链表为空，无法删除！");
        }

        if (index < 1 || index > size()) {
            throw new Exception("参数错误！");
        }
        Node temp = head;
        int count = 0;
        while (temp.next != head) {
            count++;
            if (count == index) {
                //删除节点
                temp.next = temp.next.next;
            } else {
                //指针后移
                temp = temp.next;
            }
        }
    }

    @Override
    public T get(int index) throws Exception {
        if (index < 1 || index > size()) {
            throw new Exception("参数错误！");
        }
        int count = 0;
        T data = null;
        Node temp = head;
        while (temp.next != head) {
            count++;
            if (count == index) {
                data = (T) temp.next.data;
            }
            temp = temp.next;
        }
        return data;
    }

    public class Node<T> {
        T data;
        Node<T> next;

        public Node(T data, Node<T> next) {
            this.data = data;
            this.next = next;
        }

        public Node() {
        }
    }

    public CircleLinkList() {
        head = new Node();
        head.next = head;
    }

    public void print() {
        if (!isEmpty()) {
            Node temp = head;
            while (temp.next != head) {
                temp = temp.next;
                System.out.println(temp.data);
            }
        }

    }

    /**
     * 创建环形链表（不包括头结点）
     *
     * @param n
     * @return 第一个节点
     */
    public Node create(int n, Integer data) {
        Node temp = head;
        int i = 1;
        Node p = null;
        if (n > 0) {
            while (i <= n) {
                p = new Node();
                if (data == null) {
                    p.data = i++;
                } else {
                    i++;
                    p.data = data;
                }
                temp.next = p;
                temp = p;
            }
            //将最后一个节点指向第一个节点，释放头结点
            p.next = head.next;
        }
        return p.next;
    }

}
