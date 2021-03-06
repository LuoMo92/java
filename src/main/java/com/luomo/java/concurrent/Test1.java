package com.luomo.java.concurrent;

/**
 * @author LiuMei
 * @date 2019/2/28 0028
 */
public class Test1 {
    private static long count = 0;

    private void add10K() {
        int idx = 0;
        while (idx++ < 10000) {
            count += 1;
        }
    }

    public static long calc() throws InterruptedException {
        final Test1 test1 = new Test1();
        // 创建两个线程，执行 add() 操作
        Thread th1 = new Thread(() -> {
            test1.add10K();
        });
        Thread th2 = new Thread(() -> {
            test1.add10K();
        });
        // 启动两个线程
        th1.start();
        th2.start();
        // 等待两个线程执行结束
        th1.join();
        th2.join();
        return count;
    }

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 10000; i++) {
            long calc = calc();
            System.out.println(calc);
            count = 0L;
        }
    }
}

