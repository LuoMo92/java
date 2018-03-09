package com.luomo.java.ds;

/**
 * 循环和递归
 *
 * @author LiuMei
 * @date 2018-03-06
 */
public class CirAndRec {

    public static void circulation(int n) {
        if (n > 0) {
            for (int i = 1; i < n; i++) {
                System.out.println(i);
            }
        }
    }

    public static void recursion(int n) {
        if (n > 0) {
            recursion(n - 1);
            System.out.println(n);
        }
    }

    public static void polynomial(){

    }

    public static void main(String[] args) {
        recursion(22000);
        circulation(100000);
    }

}
