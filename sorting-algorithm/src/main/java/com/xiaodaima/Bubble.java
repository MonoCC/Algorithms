package com.xiaodaima;

import java.util.Arrays;

/**
 * 冒泡排序，最基本的冒泡排序，大数值在右边，小数字在左边
 * Example: 1 5 6 8 9 11 12
 * 特性：
 * 1. 相邻数之间比较，如果满足要求就进行交换。
 */

// 冒泡排序算法需要和选择排序算法区分开来
// 冒泡是往上冒大的或者小的，或往前面冒大的或者小的。
// 选择是从左向右选择大的或小的或从右向左选择大的或小的占位。
public class Bubble extends AbstractSort implements Sortable {

    @Override
    public void sort(int[] s) {
        for (int i = 0; i < s.length - 1; i++) {
            for (int j = 1; j < s.length - i; j++) {
                swap(s, j - 1, j);
            }
        }
    }


    public void sort2(int[] s) {
        for (int i = 0; i < s.length - 1; i++) {
            for (int j = 0; j < s.length - i -1; ) {
                int next = j + 1;
                swap(s, j, next);
                j = next;
            }
        }
    }

    private void swap(int[] s, int prev, int next) {
        if (s[prev] > s[next]) {
            int temp = s[prev];
            s[prev] = s[next];
            s[next] = temp;
        }
    }
    

    public static void main(String[] args) {
        new Bubble().testSort();
    }
}
