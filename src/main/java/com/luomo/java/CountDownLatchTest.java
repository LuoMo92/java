package com.luomo.java;

import java.util.Vector;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * @author LiuMei
 * @date 2019/4/24 0024
 */
public class CountDownLatchTest {

    public static void main(String[] args) throws InterruptedException {

        Executor executor = Executors.newFixedThreadPool(2);
        while (true){
            CountDownLatch latch = new CountDownLatch(2);
            executor.execute(()->{
                //获取订单
                latch.countDown();
            });
            executor.execute(()->{
                //获取物流单
                latch.countDown();
            });
            //等待线程操作完成
            latch.await();
            //执行后续操作
        }

    }

}
