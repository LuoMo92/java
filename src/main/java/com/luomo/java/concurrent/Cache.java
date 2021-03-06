package com.luomo.java.concurrent;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author LiuMei
 * @date 2019/4/24 0024
 */
public class Cache<K, V> {

    final Map<K, V> map = new HashMap<>();

    final ReadWriteLock rwl = new ReentrantReadWriteLock();

    final Lock r = rwl.readLock();
    final Lock w = rwl.writeLock();

    V get(K key) {
        r.lock();
        try {
            return map.get(key);
        } finally {
            r.unlock();
        }
    }

    V put(K key, V v) {
        w.lock();
        try {
            return map.put(key, v);
        } finally {
            w.unlock();
        }
    }

    @Test
    public void test() {
        try {
            r.lock();
            w.lock();
            System.out.println("===");
        } catch (Exception e) {
        } finally {
            r.unlock();
        }
    }

}
