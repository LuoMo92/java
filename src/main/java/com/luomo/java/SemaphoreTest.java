package com.luomo.java;

import java.util.concurrent.Semaphore;

/**
 * @author LiuMei
 * @date 2019/4/24 0024
 */
public class SemaphoreTest {

    static int count;

    static final Semaphore s = new Semaphore(1);

    static void addOne() throws InterruptedException {
        s.acquire();
        try {
            count += 1;
        } finally {
            s.release();
        }
    }

}
