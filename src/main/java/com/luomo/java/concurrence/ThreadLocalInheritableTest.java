package com.luomo.java.concurrence;

/**
 * @author Liumei
 * @date 2020/5/14  0014
 */
public class ThreadLocalInheritableTest {

    private static InheritableThreadLocal<Integer> inheritableThreadLocal = new InheritableThreadLocal<Integer>() {
        @Override
        protected Integer initialValue() {
            return Integer.valueOf(10);
        }

        @Override
        protected Integer childValue(Integer parentValue) {
            //设置子线程初始值
            return Integer.valueOf(5);
        }
    };

    static class MyThread extends Thread {
        @Override
        public void run() {
            super.run();
            System.out.println(getName() + " inheritableThreadLocal.get() = " + inheritableThreadLocal.get());
        }
    }

    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName() + " inheritableThreadLocal.get() = " + inheritableThreadLocal.get());

        MyThread myThread = new MyThread();
        myThread.setName("线程A");
        myThread.start();
    }

}
