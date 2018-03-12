package com.luomo.java.ds;

/**
 * @author LiuMei
 * @date 2018-03-12
 */
public class MaxSum {

    public static void main(String[] args) {
        int[] list = {-2, 11, -4, 13, -5, -2};
        System.out.println(maxSum(list, 6));
    }

    public static int maxSum(int[] a, int n) {
        int thisSum, maxSum;
        int i;
        thisSum = maxSum = 0;
        for (i = 0; i < n; i++) {
            thisSum += a[i];
            if (thisSum > maxSum) {
                maxSum = thisSum;
            } else if (thisSum < 0) {
                thisSum = 0;
            }
        }
        return maxSum;
    }

}
