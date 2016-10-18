package com.xiaodaima;

/**
 * 快速排序
 * 思想：
 * 1. 快速排序使用了分治法，将数据一分为二
 * 2. 随机选择一个数做基准，以这个数为基准将数分大于和小于这个基准数的。
 * （通常做法：选择第一个数为基准，那么从右边第一个数开始和基准数比较，如果小于那么标志，再
 * 从左开始和基准数比较，如果大于基准数那么就标记，将两个标记的数交换；或者相反）
 * 3. 对第二步剩余的按照相同的方法进行，一直细分下去，直到分不下去为止
 */
public class Quick extends AbstractSort implements Sortable {

    @Override
    public String getName() {
        return "快速排序（Quick）";
    }

    @Override
    public void sort(int[] s) {
        doSort(s, 0, s.length - 1);
    }

    private void doSort(int s[], int begin, int end) {
        if(end > begin) {
            int partPos = part(s, begin, end);
            doSort(s, begin, partPos - 1);
            doSort(s, partPos + 1, end);
        }
    }

    /**
     * 将数据一分为二，返回分隔的位置
     * @param s
     * @param begin 不包含上次比较的基数位置
     * @param end 不包含上次比较的基数位置
     * @return
     */
    private int part(int s[], int begin, int end) {
        int basePos = begin;
        while(begin < end) {
            //尾部开始
            while((begin < end) && (s[basePos] < s[end])) {
                end --;
            }
            //首部开始
            while((begin < end) && (s[basePos] > s[begin])) {
                begin ++;
            }
            if(begin != end) {
                swap(s, begin, end);
                end --;
            } else {
                break;
            }
        }
        if(basePos != begin) {
            swap(s, basePos, begin);
            return basePos;
        }
        return begin;
    }

    public static void main(String[] args) {
        new Quick().testSort(1000);
    }
}
