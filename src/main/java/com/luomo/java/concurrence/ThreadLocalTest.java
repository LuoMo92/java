package com.luomo.java.concurrence;

/**
 * @author Liumei
 * @date 2020/5/14  0014
 */
public class ThreadLocalTest {

    private static ThreadLocal<String> threadLocal = new ThreadLocal<String>(){
        @Override
        protected String initialValue() {
            //指定初始值
            return "hahaha";
        }
    };

    static class MyThread extends Thread {

        @Override
        public void run() {
            super.run();
            for (int i = 0; i < 3; i++) {
                threadLocal.set(i + "test");
                //每个线程都还是能取出自己设置的数据
                System.out.println(getName() + " threadLocal.get() = " + threadLocal.get());
            }
        }
    }

    public static void main(String[] args) {
        MyThread myThreadA = new MyThread();
        myThreadA.setName("ThreadA");

        MyThread myThreadB = new MyThread();
        myThreadB.setName("ThreadB");

        myThreadA.start();
        myThreadB.start();
    }

}
