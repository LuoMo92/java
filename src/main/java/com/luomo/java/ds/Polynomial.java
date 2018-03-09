package com.luomo.java.ds;

/**
 * 多项式
 * <p>
 * f(x) = a0+a1x+...+a(n-1下标)x(n-1上标)+anxn
 *
 * @author LiuMei
 * @date 2018-03-06
 */
public class Polynomial {

    public static double f(int n, double[] a, double x) {
        int i;
        double p = a[0];
        for (i = 1; i <= n; i++) {
            p += (a[i] * Math.pow(x, i));
        }
        return p;
    }

    /**
     * f(x) = a0+x(a1+x(...(an-1+x(an)))
     * 每次把x当做公因子提取出来
     *
     * @param n
     * @param a
     * @param x
     * @return
     */
    public static double f1(int n, double[] a, double x) {
        int i;
        double p = a[n];
        for (i = n; i > 0; i--) {
            p = a[i - 1] + x * p;
        }
        return p;
    }

    /**
     * f(x) = 1+求和(x的i次方/i)
     *
     * @param x
     * @return
     */
    public static double f3(int n, double x) {
        int i;
        double p = 1;
        for (i = 1; i < n; i++) {
            p += (Math.pow(x, i) / i);
        }
        return p;
    }

    public static double f4(int n, double x) {
        int i;
        double p = 1 / n;
        for (i = n; i > 1; i--) {
            p = 1.0 / (i - 1) + (p) * x;
        }
        p = 1 + (p) * x;
        return p;
    }

    public static void cirF3(int number) {
        System.out.println("开始调用cirF3");
        long start = System.currentTimeMillis();
        for (int i = 0; i < number; i++) {
            f3(100, 1.1);
        }
        long end = System.currentTimeMillis();
        System.out.println("耗时:" + (end - start) / 1000 + "s");
    }

    public static void cirF4(int number) {
        System.out.println("开始调用cirF4");
        long start = System.currentTimeMillis();
        for (int i = 0; i < number; i++) {
            f4(100, 1.1);
        }
        long end = System.currentTimeMillis();
        System.out.println("耗时:" + (end - start) + "ms");
    }

    public static void main(String[] args) {
        double[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        double f = f(9, a, 1.1);
        double f1 = f1(9, a, 1.1);
        System.out.println(f);
        System.out.println(f1);
        cirF3(1000000);
        cirF4(1000000);
    }
}
