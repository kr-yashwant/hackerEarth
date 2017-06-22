package com.mayEasy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Created by nfn8y on 5/2/17.
 */
public class ShinoSubString {
    public static void main(String[] args) throws IOException {
        StringBuilder out = new StringBuilder();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int n = Integer.parseInt(stringTokenizer.nextToken());
        int q = Integer.parseInt(stringTokenizer.nextToken());
        //String[] arr = new String[n], arr2 = new String[n];
        O[] arr = new O[n];
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for(int i=0; i<n; i++) {
            arr[i] = new O(i, stringTokenizer.nextToken());
        }
        Arrays.sort(arr);
        while(q-->0) {
            String s = bufferedReader.readLine(); int j= -1, k=-1, l = arr.length; boolean maxF = false, minF = false;
            for(int i=0; i<l; i++) {
                if(!minF) {
                    if (arr[i].getVal().contains(s)) {
                        minF = true;
                        j = arr[i].getOrder();
                    }
                }
                if(!maxF) {
                    if(arr[l-1-i].getVal().contains(s)) {
                        maxF = true;
                        k = arr[l-i-1].getOrder();
                    }
                }
                if(minF && maxF) break;
            }
            out.append(j).append(" ").append(k).append("\n");
        }
        System.out.println(out.toString());
    }
}
class O implements Comparable<O>{
    private int order;
    private String val;

    public O(int order, String val) {
        this.order = order;
        this.val = val;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public String getVal() {
        return val;
    }

    public void setVal(String val) {
        this.val = val;
    }

    @Override
    public int compareTo(O o) {
        return this.val.compareTo(o.val);
    }
}
