package com.xiaodaima;

import java.util.Arrays;

/**
 * Created by chongdi.yang on 2016/10/18.
 */
public class JdkSort extends AbstractSort implements Sortable {
    @Override
    public String getName() {
        return "Jdk（java jdk系统提供排序）";
    }

    @Override
    public void sort(int[] s) {
        Arrays.sort(s);
    }
}
