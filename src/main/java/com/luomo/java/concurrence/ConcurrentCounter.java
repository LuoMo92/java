package com.luomo.java.concurrence;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author LiuMei
 * @date 2018-12-04.
 */
public class ConcurrentCounter {

    private final AtomicInteger count = new AtomicInteger(0);

    public int getCount(){
        return count.get();
    }

    public int increment(){
        return count.incrementAndGet();
    }

    public int decrement(){
        return count.decrementAndGet();
    }
}
