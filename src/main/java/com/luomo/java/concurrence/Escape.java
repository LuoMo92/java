package com.luomo.java.concurrence;

/**
 * 逸出
 *
 * 在对象未完成构造之前，不可以将其发布
 * @author Liumei
 * @date 2020/5/14  0014
 */
public class Escape {

    private int thisCanBeEscape = 0;

    public Escape() {
        new InnerClass();
    }

    private class InnerClass {
        public InnerClass() {
            //这里可以在Escape对象完成构造前提前引用到Escape的private变量
            System.out.println(Escape.this.thisCanBeEscape);
        }
    }

    public static void main(String[] args) {
        new Escape();
    }

}
