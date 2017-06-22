package com.arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Created by nfn8y on 6/20/17.
 */
public class WeighingTheStones {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int t = Integer.parseInt(stringTokenizer.nextToken());
        StringBuilder stringBuilder = new StringBuilder();
        while(t-->0) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int n = Integer.parseInt(stringTokenizer.nextToken());
            int[] r = new int[n], a = new int[n];
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for(int i=0; i<n; i++) r[i] = Integer.parseInt(stringTokenizer.nextToken());
            Arrays.sort(r);
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for(int i=0; i<n; i++) a[i] = Integer.parseInt(stringTokenizer.nextToken());
            Arrays.sort(a);
            int aMax = a[0], aFreq = 1, rMax = r[0], rFreq = 1, aI = 1, rI = 1;
            for(int i=1; i<n; i++) {
                if(a[i] == a[i-1]) {
                    aI++;
                    if(aI == aFreq) {
                        if(a[i] > aMax) aMax = a[i];
                    } else if(aI > aFreq) {
                        aFreq = aI; aMax = a[i];
                    }
                } else {
                    if(aFreq == 1 && a[i] > a[i-1]) {
                        aMax = a[i];
                    }
                    aI = 1;
                }
                if(r[i] == r[i-1]) {
                    rI++;
                    if(rI == rFreq) {
                        if(r[i] > rMax) rMax = r[i];
                    } else if(rI > rFreq) {
                        rFreq = rI; rMax = r[i];
                    }
                } else {
                    if(rFreq == 1 && r[i] > r[i-1]) {
                        rMax = r[i];
                    }
                    rI = 1;
                }
            }
            stringBuilder.append((aMax == rMax)?"Tie":((aMax > rMax)?"Ankit":"Rupam")).append("\n");
        }
        System.out.print(stringBuilder.toString());
    }
}
