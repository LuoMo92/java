package com.luomo.java.ds;

/**
 * 二分法
 * 给定N个从小到大排好序的整数序列List[]，以及某待查找整数X，我们的目标是找到X在List中的下标。即若有List[i]=X，则返回i；否则返回-1表示没有找到。
 * 二分法是先找到序列的中点List[M]，与X进行比较，若相等则返回中点下标；否则，若List[M]>X，则在左边的子系列中查找X；若List[M]<X，则在右边的子系列中查找X。
 *
 * @author LiuMei
 * @date 2018-03-12
 */
public class Dichotomy {

    /**
     * 时间复杂度
     * 最好:1
     *
     * @param list
     * @param search
     * @return
     */
    public static int dichotomy(int[] list, int search) {
        int start = 0;
        int end = list.length - 1;
        while (start <= end) {
            int middle = (start + end) / 2;
            if (search < list[middle]) {
                end = middle - 1;
            } else if (search > list[middle]) {
                start = middle + 1;
            } else {
                return middle;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] list = {1, 2, 3, 4, 6, 7, 8};
        System.out.println(dichotomy(list, 8));
    }
}
