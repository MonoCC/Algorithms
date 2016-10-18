package com.xiaodaima;

import java.util.Arrays;

/**
 * 插入排序
 * 基本思想：
 * 将一个记录插入到已排序好的有序表中，从而得到一个新，记录数增1的有序表。
 * 将第一个数看成排好序的子序，第二个数插入子序中，依此类推。
 * (如果一个一个交换，有一点类似冒泡，但是和冒泡很大的区别在于 1.有序列表 2.不用从头至尾或者从尾至头一一比较)
 */
public class Insertion extends AbstractSort implements Sortable {

    /**
     * 传统一个一个交互
     * @param s
     */
    public void sort2(int[] s) {
        for (int i = 1; i < s.length; i++) {
            for (int j = i; j > 0; j--) {
                if (s[j - 1] > s[j]) {
                    swap(s, j - 1, j);
                } else {
                    break;
                }
            }
        }

    }

    /**
     * 标志位置，最后统一交换
     * @param s
     */
    public void sort(int[] s) {
        for (int i = 1; i < s.length; i++) {
            int pos = i;
            //记住需要插入的位置
            for (int j = i -1; j >= 0; j--) {
                if (s[j] > s[i]) {
                    pos = j;
                } else {
                    break;
                }
            }
            // 交换
            int index = i;
            while (index != pos) {
                swap(s, index, --index);
            }

        }

    }

    /**
     * 优化，减少交换次数，空缺出需要暂用的位置。
     * @param s
     */
    public void sort1(int[] s) {
        for (int i = 1; i < s.length; i++) {
            int value = s[i];
            int j = i - 1;
            boolean move = false;
            while(value < s[j]) {
                s[j + 1] = s[j];
                move = true;
                j --;
                if(j < 0) {
                    break;
                }
            }
            if(move) {
                s[j + 1] = value;
            }
        }

    }


    public static void main(String[] args) {
        new Insertion().testSort();
    }

    @Override
    public String getName() {
        return "插入（Insertion）";
    }
}
