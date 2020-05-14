package com.luomo.java.concurrence;

import java.util.Arrays;

/**
 * @author Liumei
 * @date 2020/5/14  0014
 */
public class UnsafePublish {

    private String[] states = {"AK", "AL"};

    public String[] getStates() {
        return states;
    }

    public static void main(String[] args) {
        UnsafePublish safe = new UnsafePublish();
        System.out.println(Arrays.toString(safe.getStates()));
        //外部对象可以修改私有属性
        safe.getStates()[1] = "c";
        System.out.println(Arrays.toString(safe.getStates()));
    }
}
