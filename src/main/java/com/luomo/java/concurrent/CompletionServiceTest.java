package com.luomo.java.concurrent;

import java.util.concurrent.*;

/**
 * @author LiuMei
 * @date 2019/4/28 0028
 */
public class CompletionServiceTest {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        ExecutorService executor = Executors.newFixedThreadPool(3);
        CompletionService<Integer> cs = new ExecutorCompletionService<>(executor);
        cs.submit(() -> {
                    System.out.println("S1询价");
                    return 1;
                }
        );
        cs.submit(() -> {
                    System.out.println("S2询价");
                    return 2;
                }
        );
        cs.submit(() -> {
                    System.out.println("S3询价");
                    return 3;
                }
        );
        for(int i=0;i<3;i++){
            Integer price = cs.take().get();
            executor.execute(()->{
                System.out.println("保存"+price);
            });
        }
    }
}
