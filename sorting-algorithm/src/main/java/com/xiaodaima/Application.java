package com.xiaodaima;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by chongdi.yang on 2016/10/18.
 */
public class Application {

    public static void main(String[] args) {
        int capcity = 5000;
        int cycle = 500;
        int[] a = new int[capcity];
        Random random = new Random();
        for(int i=0; i<capcity; i++) {
            a[i] = random.nextInt();
        }
        new JdkSort().testSort(a, cycle, false);
        new Insertion().testSort(a, cycle, false);
        new Bubble().testSort(a, cycle, false);
        new Quick().testSort(a, cycle, false);
        new Selection().testSort(a, cycle, false);


    }
}
