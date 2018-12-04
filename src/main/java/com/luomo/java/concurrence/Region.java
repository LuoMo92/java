package com.luomo.java.concurrence;

/**
 * @author LiuMei
 * @date 2018-12-04.
 */
public class Region {

    private int left;

    private int right;

    public Region() {
        super();
    }

    public Region(int left, int right) {
        super();
        if (left <= right) {
            this.left = left;
            this.right = right;
        }else {
            this.left = left;
            this.right = right;
        }
    }

    public void setLeft(int left) {
        System.out.println("before setLeft:" + toString());
        synchronized (this) {
            if (left > right) {
                this.left = right;
            }else {
                this.left = left;
            }
        }
        System.out.println("after setLeft:" + toString());
    }

    public void setRight(int right) {
        System.out.println("before setRight:" + toString());
        synchronized (this) {
            if (right < left) {
                this.right = left;
            }else {
                this.right = right;
            }
        }
        System.out.println("after setRight:" + toString());
    }

    public synchronized boolean in(int value){
        return value >= left && value <= right;
    }

    @Override
    public String toString(){
        return "[" + left + "," + right + "]";
    }

}
