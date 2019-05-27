package com.luomo.java.stack;

import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static java.util.regex.Pattern.*;

/**
 * 逆波兰计算
 *
 * @author LiuMei
 * @date 2019/5/27 0027
 */
public class RPN {

    public static double cal(String str){
        String[] s = str.split(" ");
        Stack stack = new Stack();
        for (int i = 0; i < s.length; i++) {
            if (RPN.isNumeric(s[i])) {
                stack.push(s[i]);
            } else {
                switch (s[i]) {
                    case "+":
                        double a = Double.valueOf(stack.pop().toString());
                        double b = Double.valueOf(stack.pop().toString());
                        stack.push(b + a);
                        break;
                    case "-":
                        double c = Double.valueOf(stack.pop().toString());
                        double d = Double.valueOf(stack.pop().toString());
                        stack.push(d - c);
                        break;
                    case "*":
                        double e = Double.valueOf(stack.pop().toString());
                        double f = Double.valueOf(stack.pop().toString());
                        stack.push(f * e);
                        break;
                    case "/":
                        double g = Double.valueOf(stack.pop().toString());
                        double h = Double.valueOf(stack.pop().toString());
                        if (g != 0) {
                            stack.push(h / g);
                        } else {
                            System.out.println("除数为0！");
                        }
                        break;
                }
            }
        }
        return (double) stack.pop();
    }

    public static void main(String[] args) {

        String str = "5 6 7 + 8 * - 9 4 / +";
        System.out.println(RPN.cal(str));
    }

    public static boolean isNumeric(String str) {
        Pattern pattern = compile("[0-9]*");
        Matcher isNum = pattern.matcher(str);
        if (!isNum.matches()) {
            return false;
        }
        return true;
    }
}
