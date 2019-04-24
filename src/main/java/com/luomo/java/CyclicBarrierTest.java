package com.luomo.java;

import java.util.Vector;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * @author LiuMei
 * @date 2019/4/24 0024
 */
public class CyclicBarrierTest {

    Vector pos;
    Vector dos;

    Executor executor = Executors.newFixedThreadPool(1);
    final CyclicBarrier barrier = new CyclicBarrier(2,()->{executor.execute(()->check());});

    void check(){
        //执行对账操作
        //差异写入差异库
    }

    void checkAll(){
        Thread t1 = new Thread(()->{
            while (true){
                //查询订单库
                try {
                    barrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }
        });
        t1.start();
        Thread t2 = new Thread(()->{
            while (true){
                //查询运单库
                try {
                    barrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }
        });
        t2.start();
    }
}
