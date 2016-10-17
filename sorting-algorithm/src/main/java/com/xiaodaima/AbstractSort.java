package com.xiaodaima;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *  排序抽象， 添加一些输入和打印日志方法
 */
public abstract class AbstractSort implements Sortable {

    private static final Logger LOG = LoggerFactory.getLogger(AbstractSort.class);

    public void testSort() {
        int[] a = ConsoleUtils.readLine();
        int cycleCount = 100;
        long start = System.nanoTime();
        LOG.info("执行开始时间：" + start);
        for(int i=0; i<cycleCount; i++) {
            sort(a);
        }
        long end = System.nanoTime();
        LOG.info("执行结束时间：" + end + "，耗时：" + (end - start)/cycleCount);
        ConsoleUtils.putOut(a);
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
