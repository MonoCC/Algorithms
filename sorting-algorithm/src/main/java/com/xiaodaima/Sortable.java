package com.xiaodaima;

/**
 * 排序接口
 */
public interface Sortable {

    //为什么不返回值，如果返回值，
    // 1. 让人误会，会返回新的数组
    // 2. 如果返回新的数组，假设数组非常大，需要拷贝一份，那就两份内存了
    // GC，内存压力很大，浪费内存，所以考虑到这些不进行返回值，对原数组进行修改。
    void sort(int[] s);
}
