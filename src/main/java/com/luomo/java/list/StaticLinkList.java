package com.luomo.java.list;

/**
 * 静态链表
 *
 * @author LiuMei
 * @date 2019/5/23 0023
 */
public class StaticLinkList<T> implements List<T> {

    private SNode[] nodes;

    private int maxSize;

    public StaticLinkList(){
        this(1000);
    }

    public StaticLinkList(int maxSize) {
        this.maxSize = maxSize;
        nodes = new SNode[this.maxSize];
        for (int i = 0; i < this.maxSize; i++) {
            nodes[i] = new SNode(null, i + 1);
        }
        nodes[maxSize - 1] = new SNode(null, 0);
    }

    private class SNode<T> {
        T data;
        int cur;

        public SNode(T data, int cur) {
            this.data = data;
            this.cur = cur;
        }
    }

    /**
     * 获取第i个元素的下标
     *
     * @param i
     * @return
     * @throws Exception
     */
    public int getIndex(int i) throws Exception {
        if (i < 1 || i > this.size()) {
            throw new Exception("参数错误！");
        }
        int k = nodes[maxSize - 1].cur;
        for (int j = 1; j < i; j++) {
            k = nodes[k].cur;
        }
        return k;
    }

    /**
     * 返回可分配节点的下标
     *
     * @return
     */
    public int mallocSll() {
        int i = nodes[0].cur;
        //第i个分量要拿来用，指向下一个分量
        nodes[0].cur = nodes[i].cur;
        return i;
    }

    /**
     * 将下标为i的元素回收到备用链表中
     *
     * @param i
     */
    public void free_sll(int i) {
        nodes[i].cur = nodes[0].cur;
        nodes[0].cur = i;
    }

    @Override
    public int size() {
        int length = 0;
        int i = nodes[maxSize - 1].cur;
        while (i != 0) {
            i = nodes[i].cur;
            length++;
        }
        return length;
    }

    @Override
    public boolean isEmpty() {
        return this.size() == 0;
    }

    @Override
    public void insert(int index, T data) throws Exception {

        if (index < 1 || index > this.size() + 1) {
            throw new Exception("参数错误！");
        }
        if (size() == maxSize - 2) {
            throw new Exception("表已满，无法插入！");
        }
        int j = this.mallocSll();
        nodes[j].data = data;
        //第index-1个元素的下标
        int p;
        if (index == 1) {
            p = maxSize - 1;
        } else {
            p = getIndex(index - 1);
        }
        nodes[j].cur = nodes[p].cur;
        nodes[p].cur = j;
    }

    @Override
    public void delete(int index) throws Exception {
        if (index < 1 || index > size()) {
            throw new Exception("参数错误！");
        }
        int m = getIndex(index);
        //第i-1个元素的下标
        int p;
        if (index == 1) {
            p = maxSize - 1;
        } else {
            p = getIndex(index - 1);
        }
        nodes[p].cur = nodes[m].cur;
        free_sll(m);
    }

    @Override
    public T get(int index) throws Exception {
        return (T) nodes[getIndex(index)].data;
    }
}
