package com.luomo.java.queue;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author LiuMei
 * @date 2019/5/28 0028
 */
public class LinkQueue {

    public static void main(String[] args) throws InterruptedException {
        LinkedBlockingQueue queue = new LinkedBlockingQueue();
        queue.put(1);
        queue.put(2);
        System.out.println(queue.poll());
    }

}
