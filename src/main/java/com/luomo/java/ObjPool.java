package com.luomo.java;

import java.util.List;
import java.util.Vector;
import java.util.concurrent.Semaphore;
import java.util.function.Function;

/**
 * @author LiuMei
 * @date 2019/4/24 0024
 */
public class ObjPool<T, R> {

    final List<T> pool;

    final Semaphore semaphore;

    ObjPool(int size, T t) {
        pool = new Vector<>();
        for (int i = 0; i < size; i++) {
            pool.add(t);
        }
        semaphore = new Semaphore(size);
    }

    R exec(Function<T, R> func) throws InterruptedException {
        T t = null;
        semaphore.acquire();
        try {
            t = pool.remove(0);
            return func.apply(t);
        } finally {
            pool.add(t);
            semaphore.release();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ObjPool<Long, String> pool = new ObjPool<>(10, 2L);
        pool.exec(t -> {
            System.out.println(t);
            return t.toString();
        });
    }

}
