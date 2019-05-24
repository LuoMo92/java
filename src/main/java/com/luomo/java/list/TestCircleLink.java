package com.luomo.java.list;

import java.util.ArrayList;


/**
 * @author LiuMei
 * @date 2019/5/23 0023
 */
public class TestCircleLink {

    public static void josephus(int totalNum, int cycleNum, int index) {
        // 把所有人列入集合
        ArrayList<Integer> start = new ArrayList<>();
        for (int i = 1; i <= totalNum; i++) {
            start.add(i);
        }
        //把k设为起始坐标
        int k = index - 1 < 0 ? 0 : index - 1;
        while (start.size() > 0) {
            //赋值
            k = (k + cycleNum) % start.size();
            //第m个人的索引位置等于
            k = k % (start.size()) - 1;
            // 判断是否到队尾
            //输出该值后删除
            if (k < 0) {
                System.out.println(start.get(start.size() - 1));
                start.remove(start.size() - 1);
                k = 0;
            } else {
                System.out.println(start.get(k));
                start.remove(k);
            }
        }
    }

    public static void josephus(int total, int key) {
        CircleLinkList list = new CircleLinkList();
        CircleLinkList.Node p = list.create(total,null);
        CircleLinkList.Node temp;
        key %= total;
        while (p != p.next) {
            for (int i = 1; i < key - 1; i++) {
                p = p.next;
            }
            System.out.println(p.next.data);
            //删除第key个节点
            temp = p.next;
            p.next = temp.next;

            p = p.next;
        }
        System.out.println(p.data);
    }

    public static void magician() {
        CircleLinkList list = new CircleLinkList();
        CircleLinkList.Node head = list.create(13,0);
        CircleLinkList.Node p = head;
        p.data = 1;
        int count = 2;
        while (true) {
            for (int j = 0; j < count; j++) {
                p = p.next;
                if((int)p.data != 0){
                    //如果位置有牌的话，则下一个位置
                    j--;
                }
            }
            if((int)p.data == 0){
                p.data = count;
                count++;
                if(count == 14){
                    break;
                }
            }
        }
        for(int i = 0;i<13;i++){
            System.out.println(head.data);
            head = head.next;
        }
    }

    public static void main(String[] args) {
//        josephus(41, 3, 1);
//        josephus(41, 3);
        magician();
    }

}

