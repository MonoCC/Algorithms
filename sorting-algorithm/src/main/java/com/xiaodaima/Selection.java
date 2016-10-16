package com.xiaodaima;

/**
 * 选择排序
 * 选择排序的特性：
 * 1. 选出最小的数与第一位交换，（也就是占用第一位）；选出第二小的数与第二位交换，依次类推
 */
public class Selection extends AbstractSort implements Sortable {

    @Override
    public void sort(int[] s) {
        for(int i=0; i<s.length - 1; i++) {
            int minIndex = i;
            int min = s[i];
            for(int j=i+1; j<s.length; j++) {
                if(min > s[j]) {
                    min = s[j];
                    minIndex = j;
                }
            }
            if(minIndex != i) {
                s[minIndex] = s[i];
                s[i] = min;
            }
        }
    }

    public static void main(String[] args) {
        new Selection().testSort();
    }
}
