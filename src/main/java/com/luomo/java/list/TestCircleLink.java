package com.luomo.java.list;

/**
 * @author LiuMei
 * @date 2019/5/23 0023
 */
public class TestCircleLink {

    public static void main(String[] args) throws Exception {
        Game game = new Game(31, 3);
//        game.play();
        Game jos = new Game(10, 3);
        jos.josephus();
    }

}

class Game {

    CircleLinkList list = new CircleLinkList();
    /**
     * 总人数
     */
    int num;
    /**
     * 数到几退出
     */
    int key;

    public Game(int num, int key) {
        this.num = num;
        this.key = key;
    }

    public void josephus() throws Exception {
        CircleLinkList.Node p = list.head.next;
        for (int i = 0; i < num; i++) {
            if (p == list.head) {
                p.data = i+1;
                p.next = p;
                list.size++;
            } else {
                list.insert(i, i + 1);
            }
        }
        key %= num;
        CircleLinkList.Node temp;
        while (p != p.next) {
            for (int i = 1; i < key - 1; i++) {
                p = p.next;
            }
            System.out.println(p.next.data + "->");
            temp = p.next;
            p.next = temp.next;
            p = p.next;
        }
        System.out.println("over");
        System.out.println(p.data);
    }

    public void play() throws Exception {
        for (int i = 0; i < num; i++) {
            list.insert(i, i + 1);
        }
        System.out.println("=======游戏开始之前========");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i) + " ");
        }
        System.out.println("=======游戏开始========");
        //开始等于总人数
        int iCount = num;
        //累加器，计算是否能被key整除
        int j = 0;

        CircleLinkList.Node node = list.head;
        while (iCount != 1) {
            if (node.data != null && Integer.parseInt(node.data.toString()) != -1) {
                j++;
                if (j % key == 0) {
                    node.data = -1;
                    iCount--;
                    System.out.println();
                    for (int i = 0; i < list.size(); i++) {
                        System.out.println(list.get(i));
                    }
                }
            }
            node = node.next;
        }
        System.out.println("=======游戏结束========");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }

}
