package com.luomo.java.list;

/**
 * 线性表通用接口
 *
 * @author LiuMei
 * @date 2019/5/22 0022
 */
public interface List<T> {

    /**
     * 列表长度
     * @return
     */
    int size();

    /**
     * 列表是否为空
     * @return
     */
    boolean isEmpty();

    /**
     * 插入数据
     * @param index
     * @param data
     * @throws Exception
     */
    void insert(int index, T data) throws Exception;

    /**
     * 删除数据
     * @param index
     * @throws Exception
     */
    void delete(int index) throws Exception;

    /**
     * 根据下标获取数据
     * @param index
     * @return
     * @throws Exception
     */
    T get(int index) throws Exception;
}
