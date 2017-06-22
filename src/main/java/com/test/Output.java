package com.test;

/**
 * Created by nfn8y on 5/20/17.
 */
import java.util.*;

class Output{
    public static void main(String args[])  {
        int[][] a = new int[5][2];
        System.out.println(a.length);
    }
    static void b(int[] a) {
        a[0] = 0;
        System.out.print(Arrays.toString(a));
    }
}