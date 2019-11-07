package com.luomo.java.trans;

import java.util.concurrent.CountDownLatch;

/**
 * @author Liumei
 * @date 2019/11/7  0007
 */
public class Test {

    public static void main(String[] args) throws InterruptedException {
        Account src = new Account(10000);
        Account target= new Account(10000);
        CountDownLatch countDownLatch = new CountDownLatch(9999);
        int count = 10000;
        for (int i = 0; i < count; i++) {
            new Thread(()->{
                src.transToTarget(1,target);
                countDownLatch.countDown();
            }).start();
        }
        countDownLatch.await();
        System.out.println("src="+src.getBalance() );
        System.out.println("target="+target.getBalance() );
    }

}
