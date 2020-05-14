package com.luomo.java.concurrent;

import org.junit.Test;

import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.StampedLock;

/**
 * @author LiuMei
 * @date 2019/4/24 0024
 */
public class StampedLockTest {

    public static void main(String[] args) throws InterruptedException {
        final StampedLock lock = new StampedLock ();
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                long l = lock.writeLock();
                System.out.println("Thread real execute");
                lock.unlockWrite(l);
            }
        });

        long l = lock.writeLock();
        lock.unlockWrite(l);
        long l1 = lock.writeLock();
        t.start();
        Thread.sleep(200);

        System.out.println("release one once");
        lock.unlockWrite(l1);
    }

    @Test
    public void test()  {
        final StampedLock lock = new StampedLock();
        Thread T1 = new Thread(()->{
            // 获取写锁
            lock.writeLock();
            // 永远阻塞在此处，不释放写锁
            LockSupport.park();});
        T1.start();
        // 保证T1获取写锁
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Thread T2 = new Thread(()->
                //阻塞在悲观读锁
                lock.readLock());
        T2.start();
        // 保证T2阻塞在读锁
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //中断线程T2
        // 会导致线程T2所在CPU飙升
        T2.interrupt();
        try {
            T2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
