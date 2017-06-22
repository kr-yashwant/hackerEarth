package com.juneCircuits;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by nfn8y on 6/22/17.
 */
public class DexterPlaysWithGP {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        StringBuilder stringBuilder = new StringBuilder();
        int t = Integer.parseInt(stringTokenizer.nextToken());
        mainWhile: while(t-->0) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            long r = Long.parseLong(stringTokenizer.nextToken()),
                    s = Long.parseLong(stringTokenizer.nextToken()),
                        p = Long.parseLong(stringTokenizer.nextToken());
            long z = 1; long term = 1;
            long i=1;
            if(z==s) {
                stringBuilder.append(1).append("\n"); continue mainWhile;
            }
            for(i=1; i<p; i++) {
                term = gpNextTerm(r, term, p);
                z += term;
                if(z==s) {
                    stringBuilder.append(i+1).append("\n"); continue mainWhile;
                }
            }
            stringBuilder.append("-1").append("\n");
        }
        System.out.print(stringBuilder.toString());
    }
    public static long gpNextTerm(long r, long t, long p) {
        System.out.println("Next Item ->"+ (t*r)%p);
        return (t*r)%p;
    }
}
