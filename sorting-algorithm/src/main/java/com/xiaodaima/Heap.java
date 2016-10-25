package com.xiaodaima;

/**
 * 堆排序
 * 1. 建立大堆
 * 2. 堆调整
 */
public class Heap extends AbstractSort implements Sortable {
    @Override
    public String getName() {
        return "堆排序(Heap)";
    }

    @Override
    public void sort(int[] s) {
        //v建立大堆
        for(int i=s.length>>1; i>=0; i--) {
            heapAdjust(s, s.length, i);
        }

        //建立好调整
        for(int i=s.length - 1; i > 0; i--) {
            super.swap(s, 0, i);
            heapAdjust(s, i, 0);
        }

    }

    public static void main(String[] args) {
        new Heap().testSort();
    }

    protected void heapAdjust(int[] s, int len, int index) {
        if(index >= len) {
            return ;
        }
        int left = (index << 1) + 1;
        int right = (index << 1) + 2;
        int large = index;
        if(left < len && s[left] > s[large]) {
            large = left;
        }
        if(right < len && s[right] > s[large]) {
            large = right;
        }
        if(large != index) {
            super.swap(s, large, index);
            heapAdjust(s, len, large);
        }
    }
}
