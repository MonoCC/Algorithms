package com.xiaodaima;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by chongdi.yang on 2016/10/18.
 */
public class Application {

    public static void main(String[] args) {
        int capcity = 50000;
        int[] a = new int[capcity];
        Random random = new Random();
        for(int i=0; i<capcity; i++) {
            a[i] = random.nextInt();
        }
        int cycle = 5000;

        for(int i=0; i<cycle; i++) {
            System.out.println("======================================");
            int[] toArray = Arrays.copyOf(a, a.length);
            new JdkSort().testSort(toArray, false);

            toArray = Arrays.copyOf(a, a.length);
            new Insertion().testSort(toArray, false);

            toArray = Arrays.copyOf(a, a.length);
            new Shells().testSort(toArray, false);

            toArray = Arrays.copyOf(a, a.length);
            new Bubble().testSort(toArray, false);

            toArray = Arrays.copyOf(a, a.length);
            new Quick().testSort(toArray, false);

            toArray = Arrays.copyOf(a, a.length);
            new Selection().testSort(toArray, false);
        }




    }
}
