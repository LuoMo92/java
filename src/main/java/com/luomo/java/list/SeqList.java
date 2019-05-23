package com.luomo.java.list;

/**
 * 顺序存储
 *
 * @author LiuMei
 * @date 2019/5/22 0022
 */
public class SeqList<T> implements List<T> {

    /**
     * 默认的顺序表的最大长度
     */
    final int defaultSize = 10;

    /**
     * 最大长度
     */
    int maxSize;

    /**
     * 当前长度
     */
    int size;

    /**
     * 对象数组
     */
    T[] listArray;

    public SeqList() {
        init(defaultSize);
    }

    public SeqList(int size) {
        init(size);
    }

    /**
     * 顺序表的初始化方法
     *
     * @param size
     */
    private void init(int size) {
        maxSize = size;
        listArray = (T[]) new Object[size];
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

    @Override
    public void insert(int index, T data) throws Exception {
        if (size == maxSize) {
            throw new Exception("顺序表已满，无法插入！");
        }
        if (index < 0 || index > maxSize) {
            throw new Exception("参数错误！");
        }
        for (int j = size - 1; j >= index; j--) {
            //将index后面的元素依次往后移动
            listArray[j + 1] = listArray[j];
        }
        listArray[index - 1] = data;
        size++;
    }

    @Override
    public void delete(int index) throws Exception {
        if (isEmpty()) {
            throw new Exception("顺序表为空，无法删除！");
        }
        if (index < 0 || index > size - 1) {
            throw new Exception("参数错误！");
        }
        for (int j = index; j < size; j++) {
            listArray[j - 1] = listArray[j];
        }
        size--;
    }

    @Override
    public T get(int index) throws Exception {
        if (index < 1 || index > size) {
            throw new Exception("参数错误！");
        }
        return listArray[index - 1];
    }
}
