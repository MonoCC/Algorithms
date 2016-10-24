package com.xiaodaima;

/**
 * 归并排序
 * 归并排序采用的是分治法，将数组一次分下去，然后对排好序的数组进行合并。
 */
public class Merge extends AbstractSort implements Sortable {
    @Override
    public String getName() {
        return "归并排序（merge）";
    }

    @Override
    public void sort(int[] s) {
        sort(s, 0, s.length - 1);
    }

    // 归并排序进行递归，一直递归下去。分部分排序
    protected void sort(int[] s, int begin, int end) {
        if (end <= begin) {
            return;
        }
        int pos = begin + (end - begin) / 2;
        int next = pos + 1;
        sort(s, begin, pos);
        sort(s, next, end);
        doSort(s, begin, end, next);
    }

    // 归并排序二分法
    protected void doSort(int[] s, int begin, int end, int pos) {
        int[] temp = new int[end - begin + 1];
        int i = begin, j = pos, k = 0;
        while (i < pos && j <= end) {
            if (s[i] < s[j]) {
                temp[k] = s[i];
                i++;
            } else {
                temp[k] = s[j];
                j++;
            }
            k++;
        }

        while (i < pos) {
            temp[k] = s[i];
            i++;
            k++;
        }
        while (j <= end) {
            temp[k] = s[j];
            j++;
            k++;
        }
        System.arraycopy(temp, 0, s, begin, temp.length);
    }

    public static void main(String[] args) {
        new Merge().testSort();
    }
}
