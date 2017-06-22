package com.aprilCircuits;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by nfn8y on 4/24/17.
 */
public class FredoAndMaths {
    public static void main(String[] args) throws IOException{
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int t = Integer.parseInt(stringTokenizer.nextToken());
        StringBuilder out = new StringBuilder();
        while(t-->0) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            long x = Long.parseLong(stringTokenizer.nextToken());
            long k = Long.parseLong(stringTokenizer.nextToken());
            long m = Long.parseLong(stringTokenizer.nextToken());
            while(k>0) {
                while(k>0 && x<m) {
                    x = (long)Math.pow(x, x); k/=2;
                }
                x %= m;
            }
            out.append(x).append("\n");
        }
        System.out.print(out.toString());
    }
}
