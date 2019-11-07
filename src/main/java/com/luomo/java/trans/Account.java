package com.luomo.java.trans;

/**
 * @author Liumei
 * @date 2019/11/7  0007
 */
public class Account {

    private Integer balance;

    public Account(Integer balance) {
        this.balance = balance;
    }

    public void transToTarget(Integer money, Account target) {
        Allocator.getInstance().apply(this, target);
        this.balance -= money;
        target.balance += money;
        Allocator.getInstance().release(this, target);
    }

    public Integer getBalance() {
        return balance;
    }

    public void setBalance(Integer balance) {
        this.balance = balance;
    }
}
