package com.luomo.java;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

/**
 * @author LiuMei
 * @date 2019/5/16 0016
 */
public class A {
    static class SafeDateFormat {
        static final ThreadLocal<DateFormat> tl = ThreadLocal.withInitial(() -> new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));

        static DateFormat get() {
            return tl.get();
        }
    }

    static class DateThread extends Thread{
        @Override
        public void run(){
            DateFormat dateFormat = SafeDateFormat.get();
            System.out.println(Thread.currentThread().getName());
            System.out.println(System.identityHashCode(dateFormat));
        }
    }

    public static void main(String[] args) {
        DateThread threadA = new DateThread();
        DateThread threadB = new DateThread();
        threadA.start();
        threadB.start();
    }

}
