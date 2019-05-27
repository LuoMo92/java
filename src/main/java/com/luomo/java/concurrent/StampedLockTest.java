package com.luomo.java.concurrent;

import java.util.concurrent.locks.StampedLock;

/**
 * @author LiuMei
 * @date 2019/4/24 0024
 */
public class StampedLockTest {

    public static void main(String[] args) {
        final StampedLock sl = new StampedLock();
        long stamp = sl.readLock();
        try {

        }finally {
            sl.unlockRead(stamp);
        }
    }

}
