package com.xiaodaima;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

/**
 *  排序抽象， 添加一些输入和打印日志方法
 */
public abstract class AbstractSort implements Sortable {

    private static final Logger LOG = LoggerFactory.getLogger(AbstractSort.class);

    public void testSort() {
        testSort(1000);
    }

    public void testSort(int cycleCount) {
        int[] a = ConsoleUtils.readLine();
        testSort(a, cycleCount);
    }

    public void testSort(int[] a, int cycleCount) {
        testSort(a, cycleCount, true);
    }

    public void testSort(int[] a, int cycleCount, boolean putOut) {
        LOG.info("算法：" + getName() + "，执行开始时间：" + System.nanoTime());
        long exe = 0;
        for(int i=0; i<cycleCount; i++) {
            int[] sortArray = Arrays.copyOf(a, a.length);
            long begin = System.nanoTime();
            sort(sortArray);
            exe += (System.nanoTime() - begin);
        }
        long end = System.nanoTime();
        LOG.info("算法：" + getName() + "，执行结束时间：" + end + "，循环次数：" + cycleCount +  "，统计sort平均耗时：" + (exe) * 1.0/cycleCount);
        if(putOut) {
            ConsoleUtils.putOut(a);
        }
    }

    /**
     * 数据交换
     * @param s 数据源数组
     * @param i 位置i
     * @param j 位置j
     */
    protected void swap(int[] s, int i, int j) {
        int temp = s[i];
        s[i] = s[j];
        s[j] = temp;
    }



    protected void prevGtNextThenSwap(int[] s, int prev, int next) {
        if (s[prev] > s[next]) {
            swap(s, prev, next);
        }
    }

    protected void prevLtNextThenSwap(int[] s, int prev, int next) {
        if (s[prev] < s[next]) {
            swap(s, prev, next);
        }
    }

}
