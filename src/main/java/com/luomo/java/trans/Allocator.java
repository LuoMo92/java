package com.luomo.java.trans;

import java.util.ArrayList;
import java.util.List;

/**
 * 账户分配者
 * <p>
 * 单例
 *
 * @author Liumei
 * @date 2019/11/7  0007
 */
public class Allocator {

    private Allocator() {
    }

    private List<Account> locks = new ArrayList<>();

    public synchronized void apply(Account src, Account target) {
        while (locks.contains(src) || locks.contains(target)) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        locks.add(src);
        locks.add(target);
    }

    public synchronized void release(Account src, Account target) {
        locks.remove(src);
        locks.remove(target);
        this.notifyAll();
    }

    public static Allocator getInstance() {
        return AllocatorSingle.allocator;
    }

    static class AllocatorSingle {
        public static Allocator allocator = new Allocator();
    }

}
