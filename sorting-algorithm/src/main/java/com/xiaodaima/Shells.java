package com.xiaodaima;

/**
 * 希尔排序，使用gap，相隔多少的元素分为一组。
 * 1. 开始s.length / 2 = x，x /2 = x1, x1/2 = x2 ... 直至 Xn=1 也就是x为多少就分为多少组
 * 2. 对分组进行直接插入排序
 */
public class Shells extends AbstractSort implements Sortable {

    public void sort1(int[] s) {
        int gap = s.length / 2;
        while (gap >= 1) {
            //对相差gap的元素变为一组
            for (int i = 0; i < gap; i++) {
                Insertion.doSort(s, i, gap);
            }
            gap /= 2;
        }
    }

    public void sort(int[] s) {
        int gap = s.length / 2;
        while (1 <= gap) {
            // 把距离为 gap 的元素编为一个组，扫描所有组
            for (int i = gap; i < s.length; i++) {
                int j = 0;
                int temp = s[i];

                // 对距离为 gap 的元素组进行排序
                for (j = i - gap; j >= 0 && temp < s[j]; j = j - gap) {
                    s[j + gap] = s[j];
                }
                s[j + gap] = temp;
            }
            gap = gap / 2; // 减小增量
        }
    }

    @Override
    public String getName() {
        return "希尔排序（Shell）";
    }

    public static void main(String[] args) {
        new Shells().testSort();
    }
}
