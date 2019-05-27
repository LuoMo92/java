package com.luomo.java.stack;

import java.util.Stack;

/**
 * 利用栈进行二进制转十进制、八进制
 *
 * @author LiuMei
 * @date 2019/5/27 0027
 */
public class SeqStack {

    public static int bin2ten(String bin) {
        Stack stack = new Stack();
        char[] chars = bin.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            stack.push(chars[i]);
        }
        int ten = 0;
        int size = stack.size();
        for (int i = 0; i < size; i++) {
            ten += (Integer.valueOf(stack.pop().toString())) * Math.pow(2, i);
        }
        return ten;
    }

    public static String bin2oct(String bin) {
        char[] binArray = bin.toCharArray();
        Stack binStack = new Stack();
        int length = binArray.length;
        for (int i = 0; i < length; i++) {
            binStack.push(binArray[i]);
        }
        Stack octStack = new Stack();
        for (int i = 0; i < length; i = i + 3) {
            double v1 = Integer.valueOf(binStack.pop().toString()) * Math.pow(2, 0);
            double v2 = i + 1 < length ? Integer.valueOf(binStack.pop().toString()) * Math.pow(2, 1) : 0;
            double v3 = i + 2 < length ? Integer.valueOf(binStack.pop().toString()) * Math.pow(2, 2) : 0;
            octStack.push((int)(v1 + v2 + v3));
        }
        int size = octStack.size();
        String oct = "";
        for (int i = 0; i < size; i++) {
            oct += octStack.pop();
        }
        return oct;
    }

    public static void main(String[] args) {
        String bin = "1111100010100010";
        System.out.println(SeqStack.bin2ten(bin));
        System.out.println(SeqStack.bin2oct(bin));
    }

}
