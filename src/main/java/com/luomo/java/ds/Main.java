package com.luomo.java.ds;

import java.util.Scanner;

/**
 * @author LiuMei
 * @date 2018-03-12
 */
public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        String string = sc.nextLine();
        String[] split = string.split("\\s");
        int[] input = new int[n];
        for (int i = 0; i < split.length; i++) {
            input[i] = Integer.parseInt(split[i]);
        }
        System.out.println(maxSum(input, n));
    }

    public static String maxSum(int[] a, int n) {
        int thisSum, maxSum;
        thisSum = maxSum = 0;
        Integer endIndex = null;
        Integer startIndex = null;
        Integer start = null;
        Integer end = null;
        Integer max = null;
        for (int i = 0; i < n; i++) {
            thisSum += a[i];
            if (max == null || max < a[i]) {
                max = a[i];
            }
            if (thisSum > maxSum) {
                if (startIndex == null) {
                    startIndex = i;
                }
                endIndex = i;
                maxSum = thisSum;
                start = a[startIndex];
                end = a[endIndex];
            } else if (thisSum < 0) {
                thisSum = 0;
                startIndex = null;
                endIndex = null;
            }
        }
        if (maxSum == 0 && start == null && end == null) {
            maxSum = max;
            start = max;
            end = max;
        }
        return maxSum + " " + start + " " + end;
    }

}
