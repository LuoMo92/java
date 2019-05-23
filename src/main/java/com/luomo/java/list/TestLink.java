package com.luomo.java.list;

/**
 * @author LiuMei
 * @date 2019/5/23 0023
 */
public class TestLink {

    public static void main(String[] args) throws Exception {
        LinkList linkList = new LinkList();
//        linkList.insert(1,1);
//        linkList.insert(2,2);
//        linkList.insert(3,3);
//        linkList.insert(4,4);
//        linkList.createListHead(5);
        linkList.createListTail(9);
        for (int i = 1; i <= linkList.size(); i++) {
            System.out.println("第" + i+ "个数为：" + linkList.get(i));
        }
        System.out.println("中间元素："+linkList.getMidNode());
//        linkList.delete(1);
//        for (int i = 1; i <= linkList.size(); i++) {
//            System.out.println("第" + i + "个数为：" + linkList.get(i));
//        }
    }

}
