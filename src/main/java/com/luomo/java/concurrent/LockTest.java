package com.luomo.java.concurrent;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author LiuMei
 * @date 2019/4/24 0024
 */
public class LockTest {

    private final Lock rt1 = new ReentrantLock();

    int value;

    public void addOne() {
        rt1.lock();
        try {
            value += 1;
        } finally {
            rt1.unlock();
        }
    }

}
