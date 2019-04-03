package com.luomo.java.concurrence;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * 实现多个线程一起启动的场景
 *
 * @author LiuMei
 * @date 2018-12-04.
 */
public class CyclicBarrierTest {

    public static void main(String[] args) {
        final CyclicBarrier cyclicBarrier = new CyclicBarrier(10);
        for (int i = 0; i < 10; i++) {
            final int number = i + 1;
            Thread thread = new Thread(()->{
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {}
                System.out.println("等待执行任务[" + number + "]");
                try {
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                } catch (BrokenBarrierException e) {
                }
                System.out.println("开始执行任务[" + number + "]");
            });
            thread.start();
        }
    }

}
