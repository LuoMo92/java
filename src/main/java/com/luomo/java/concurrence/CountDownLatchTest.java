package com.luomo.java.concurrence;

import java.util.concurrent.CountDownLatch;

/**
 * 某一个线程需要等待其它若干个线程完成某件事以后才能继续进行
 *
 * @author LiuMei
 * @date 2018-12-04.
 */
public class CountDownLatchTest {

    public static void main(String[] args) throws InterruptedException {
        final CountDownLatch countDownLatch = new CountDownLatch(10);
        for (int i = 0; i < 10; i++) {
            final int number = i + 1;
            Runnable runnable = new Runnable() {
                public void run() {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {}
                    System.out.println("执行任务[" + number + "]");
                    countDownLatch.countDown();
                    System.out.println("完成任务[" + number + "]");
                }
            };
            Thread thread = new Thread(runnable);
            thread.start();
        }
        System.out.println("主线程开始等待...");
        //主线程会等待CountDownLatch进行10次countDown方法的调用才会继续执行
        countDownLatch.await();
        System.out.println("主线程执行完毕...");
    }

}
