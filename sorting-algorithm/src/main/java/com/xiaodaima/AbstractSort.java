package com.xiaodaima;

/**
 *  排序抽象， 添加一些输入和打印日志方法
 */
public abstract class AbstractSort implements Sortable {

    public void testSort() {
        int[] a = ConsoleUtils.readLine();
        sort(a);
        ConsoleUtils.putOut(a);
    }

}
