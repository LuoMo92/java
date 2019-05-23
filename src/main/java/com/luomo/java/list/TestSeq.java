package com.luomo.java.list;

/**
 * @author LiuMei
 * @date 2019/5/22 0022
 */
public class TestSeq {

    public static void main(String[] args) throws Exception {
        SeqList seqList = new SeqList();
        seqList.insert(1, 1);
        seqList.insert(2, 2);
        seqList.insert(3, 3);
        seqList.insert(4, 4);
        seqList.insert(5, 5);

        for (int i = 1; i <= seqList.size; i++) {
            System.out.println("第" + i+ "个数为：" + seqList.get(i));
        }
        seqList.delete(1);
        for (int i = 1; i <= seqList.size; i++) {
            System.out.println("第" + i + "个数为：" + seqList.get(i));
        }
    }

}
