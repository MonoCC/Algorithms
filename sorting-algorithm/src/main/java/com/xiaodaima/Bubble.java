package com.xiaodaima;

/**
 * 冒泡排序，最基本的冒泡排序，大数值在右边，小数字在左边
 * Example: 1 5 6 8 9 11 12
 * 特性：
 * 1. 相邻数之间比较，如果满足要求就进行交换。
 */

// 冒泡排序算法需要和选择排序算法区分开来
// 冒泡是往上冒大的或者小的，或往前面冒大的或者小的。
// 选择是从左向右选择大的或小的或从右向左选择大的或小的依次占位。
public class Bubble extends AbstractSort implements Sortable {

    @Override
    public void sort(int[] s) {
        for (int i = 0; i < s.length - 1; i++) {
            for (int j = 1; j < s.length - i; j++) {
                prevGtNextThenSwap(s, j - 1, j);
            }
        }
    }


    public void sort2(int[] s) {
        for (int i = 0; i < s.length - 1; i++) {
            for (int j = 0; j < s.length - i - 1; ) {
                int next = j + 1;
                prevGtNextThenSwap(s, j, next);
                j = next;
            }
        }
    }


    public static void main(String[] args) {
        new Bubble().testSort();
    }

    @Override
    public String getName() {
        return "冒泡（Bubble）";
    }
}
