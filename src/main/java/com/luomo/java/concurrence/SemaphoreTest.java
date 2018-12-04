package com.luomo.java.concurrence;

import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 实现控制数量的场景，可以是线程数量或者任务数量等等
 *
 * @author LiuMei
 * @date 2018-12-04.
 */
public class SemaphoreTest {

    public static void main(String[] args) throws InterruptedException {
        /**
         * 设定了总数为10，却开了100个线程，但是最终只有10个线程获取到了信号量，
         * 如果这10个线程不主动调用release方法的话，那么其余90个线程将一起挂死
         */
        final Semaphore semaphore = new Semaphore(10);
        final AtomicInteger number = new AtomicInteger();
        for (int i = 0; i < 100; i++) {
            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {}
                    try {
                        semaphore.acquire();
                        number.incrementAndGet();
                    } catch (InterruptedException e) {}
                }
            };
            Thread thread = new Thread(runnable);
            thread.start();
        }
        Thread.sleep(10000);
        System.out.println("共" + number.get() + "个线程获得到信号");
        System.exit(0);
    }

}
