package com.xiaodaima;

/**
 * 选择排序
 * 选择排序的特性：
 * 1. 选出最小的数与第一位交换，（也就是占用第一位）；选出第二小的数与第二位交换，依次类推
 */
public class Selection extends AbstractSort implements Sortable {

    @Override
    /**
     * 优化选择排序方法，减少交换次数。
     * @param s
     */
    public void sort(int[] s) {
        for(int i=0; i<s.length - 1; i++) {
            int minIndex = i;
            for(int j=i+1; j<s.length; j++) {
                if(s[minIndex] > s[j]) {
                    minIndex = j;
                }
            }
            if(minIndex != i) {
                swap(s, minIndex, i);
            }
        }
    }

    /**
     * 传统选择排序方法
     * @param s
     */
    public void sort2(int[] s) {
        for(int i=0; i<s.length - 1; i++) {
            for(int j=i+1; j<s.length; j++) {
                if(s[i] > s[j]) {
                    swap(s, i, j);
                }
            }
        }
    }



    public static void main(String[] args) {
        new Selection().testSort();
    }
}
