package com.luomo.java.concurrent;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

/**
 * @author LiuMei
 * @date 2019/4/28 0028
 */
public class CompleteableFutureTest {

    void sleep(int t, TimeUnit u) {
        try {
            u.sleep(t);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        CompleteableFutureTest test = new CompleteableFutureTest();
        /**
         * 任务1：洗水壶-》烧开水
         */
        CompletableFuture<Void> f1 = CompletableFuture.runAsync(() -> {
            System.out.println("T1:洗水壶。。。");
            test.sleep(1,TimeUnit.SECONDS);
            System.out.println("T1:烧开水。。。");
            test.sleep(15, TimeUnit.SECONDS);
        });

        CompletableFuture<String> f2 = CompletableFuture.supplyAsync(() -> {
            System.out.println("T2:洗茶壶。。。");
            test.sleep(1, TimeUnit.SECONDS);
            System.out.println("T2:洗茶杯。。。");
            test.sleep(2, TimeUnit.SECONDS);
            System.out.println("T2:拿茶叶。。。");
            test.sleep(1, TimeUnit.SECONDS);
            return "龙井";
        });

        CompletableFuture<String> f3 = f1.thenCombine(f2, (__, tf) -> {
            System.out.println("T3:拿到茶叶:" + tf);
            System.out.println("T3:泡茶。。。");
            return "上茶：" + tf;
        });
        System.out.println(f3.join());
    }


}
