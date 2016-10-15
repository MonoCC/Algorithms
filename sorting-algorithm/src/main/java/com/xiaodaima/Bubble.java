package com.xiaodaima;

import java.util.Arrays;

/**
 * 冒泡排序，最基本的冒泡排序，大数值在右边，小数字在左边
 * Example: 1 5 6 8 9 11 12
 * 特性：
 * 1. 相邻数之间比较，如果满足要求就进行交换。
 */
public class Bubble extends AbstractSort implements Sortable {

    @Override
    public void sort(int[] s) {
        //冒泡排序算法需要和选择排序算法区分开来
        //冒泡是往上冒大的或者小的，选择是从左向右选择大的或小的或从右向左选择大的或小的占位。
        for(int i=0; i<s.length - 1; i++) {
            for(int j=1; j<s.length-i; j++) {
                if(s[j-1] > s[j]) {
                    int temp = s[j-1];
                    s[j-1] = s[j];
                    s[j] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        new Bubble().testSort();
    }
}
