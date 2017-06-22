package com.mayEasy;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by nfn8y on 5/17/17.
 *   5 4
     1 2
     3 4
     4 5
     1 3
 */
public class DisjointExample {
    int arr[]; int size[] = new int[arr.length];
    DisjointExample(int arr[]) {
        this.arr = arr;
        this.size = new int[arr.length];
        Arrays.fill(size, 1);
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int arr[] = new int[n+1];
        for(int i=0;i<n+1;i++) arr[i] = i;
        DisjointExample dj = new DisjointExample(arr);
        while(m-->0) {
            int x = scanner.nextInt(); int y = scanner.nextInt();
            dj.union(x, y);
            System.out.println(dj.countToString());
        }
        scanner.close();
    }
    public int root(int i) {
        while(arr[ i ] != i) {
            arr[ i ] = arr[ arr[ i ] ] ;
            i = arr[ i ];
        }
        return i;
    }
    public void union(int x,int y) {
        int[]a = arr;
        int root_X = root(x);
        int root_Y = root(y);
        if(size[root_X] < size[root_Y ]) {
            a[ root_X ] = a[root_Y];
            size[root_Y] += size[root_X];
        }
        else {
            a[ root_Y ] = a[root_X];
            size[root_X] += size[root_Y];
        }
    }
    public String countToString() {
        StringBuilder out = new StringBuilder();
        Arrays.sort(arr);
        int temp = -1, len=0;
        for(int i=1;i<arr.length; i++) {
            if(temp == arr[i] || len==0) {
                len++;
            }
            else {
                if(len!=0) {
                    out.append(len).append(" ");
                    len = 1;
                }
            }
            temp = arr[i];
        }
        if(len!=0) out.append(len).append(" ");
        return out.toString();
    }
}
