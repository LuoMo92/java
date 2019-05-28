package com.luomo.java.stack;

import com.sun.org.apache.bcel.internal.generic.POP;

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

    public static String trans(String str) {
        /**
         * 1+(2-3)*4+10/5
         * 从左到右遍历每个数字和符号
         * 如果是数字直接输出
         * 若是符号，则判断其与栈顶符号的优先级，是右括号或者优先级低于栈顶符号，则栈顶元素依次出栈并输出，直到遇到左括号或栈空才入栈
         */
        String[] s = str.split(" ");
        Stack stack = new Stack();
        String data = "";
        for (int i = 0; i < s.length; i++) {
            if (isNumeric(s[i])) {
                data += s[i]+" ";
            } else if (")".equals(s[i])) {
                String pop = (String) stack.pop();
                while (!("(").equals(pop)) {
                    data += pop+" ";
                    pop = (String) stack.pop();
                }
            } else if ("+".equals(s[i]) || "-".equals(s[i])) {
                if (stack.empty()) {
                    stack.push(s[i]);
                } else {
                    String pop;
                    do {
                        pop = (String) stack.pop();
                        if ("(".equals(pop)) {
                            stack.push(pop);
                        } else {
                            data += pop+" ";
                        }
                    } while (!stack.empty() && !"(".equals(pop));
                    stack.push(s[i]);
                }
            } else if ("*".equals(s[i]) || "/".equals(s[i]) || "(".equals(s[i])) {
                stack.push(s[i]);
            }else {
                System.out.println("输入格式错误");
            }
        }
        while (!stack.empty()){
            data += stack.pop()+" ";
        }
        return data;
    }


    public static double cal(String str) {
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
        RPN.trans("1 + ( 2 - 3 ) * 4 + 10 / 5");
        System.out.println(RPN.cal(RPN.trans("1 + ( 2 - 3 ) * 4 + 10 / 5")));
        //1 2 3 - 4 * + 10 5 / +
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
