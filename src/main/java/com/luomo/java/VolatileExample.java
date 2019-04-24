package com.luomo.java;

/**
 * @author LiuMei
 * @date 2019/4/19 0019
 */
public class VolatileExample {

    int x= 0;
    volatile boolean v = false;

    public void writer(){
        x = 42;
        v = true;
    }

    public void reader(){
        if(v == true){
            System.out.println(x);
        }
    }

    public static void main(String[] args){
         final VolatileExample volatileExample = new VolatileExample();
        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {
                volatileExample.writer();
            }
        });

        Thread threadB = new Thread(new Runnable() {
            @Override
            public void run() {
                volatileExample.reader();
            }
        });

        threadA.start();
        threadB.start();
    }
}
